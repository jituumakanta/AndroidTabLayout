package com.example.jitu.androidtablayout;

/**
 * Created by jitu on 11/30/2016.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jitu on 11/30/2016.
 */

public class Tab3 extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager0;
    RecyclerView.Adapter adapter;
    List<ListItem> listTrndingNewsData9;
    //  ProgressDialog uploading;
    private int requestCount = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Toast.makeText(getActivity(),"hghg",Toast.LENGTH_LONG).show();
    }
    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView3);
        recyclerView.setHasFixedSize(true);
        layoutManager0 = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager0);
        listTrndingNewsData9 = new ArrayList<>();
        getData();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (isLastItemDisplaying(recyclerView)) {
                    getData();
                    Toast.makeText(getActivity(), "hihihihi", Toast.LENGTH_LONG).show();

                }
            }
        });
        return view;
    }



    private JsonObjectRequest getofferNews(int requestCount) {
        //final ProgressBar progressBar = (ProgressBar) getActivity().findViewById(R.id.progressBar2);

        //Displaying Progressbar
        // progressBar.setVisibility(View.VISIBLE);
        String url5 = "http://hellohelps.com/HelloHelps/test.php?page=";
        String url = url5 + String.valueOf(requestCount);
        JsonObjectRequest jsObjRequest5 = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData9(o);
                Toast.makeText(getActivity(), "hihihihi", Toast.LENGTH_LONG).show();
                //  progressBar.setVisibility(View.GONE);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                //  progressBar.setVisibility(View.GONE);
            }
        });
        //MySingleton.getInstance(getActivity()).addToRequestQueue(jsObjRequest5);
        return jsObjRequest5;

    }


    public void praseJsonNewsData9(JSONObject o) {
        JSONObject jj = o;
        JSONArray rr;
        JSONObject jjj;
        ListItem lt3;

        try {

            // converting object to array
            rr = jj.getJSONArray("articles");

            for (int i = 0; i < rr.length(); i++) {
                lt3 = new ListItem();
                jjj = rr.getJSONObject(i);
                String source = jjj.getString("source");
                String author = jjj.getString("author");
                String title = jjj.getString("title");
                String description = jjj.getString("description");
                String imageUrl = jjj.getString("imageUrl");
                String publishedAt = jjj.getString("publishedAt");

                lt3.setSource(source);
                lt3.setAuthor(author);
                lt3.setTitle(title);
                lt3.setDescription(description);
                lt3.setImageUrl(imageUrl);
                lt3.setPublishedAt(publishedAt);
                listTrndingNewsData9.add(lt3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        adapter = new CardAdapter2(listTrndingNewsData9, getActivity());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    private void getData() {
        //Adding the method to the queue by calling the method getDataFromServer
        // requestQueue.add(getDataFromServer(requestCount));
        MySingleton.getInstance(getActivity()).addToRequestQueue(getofferNews(requestCount));

        //Incrementing the request counter
        requestCount++;
    }


    private boolean isLastItemDisplaying(RecyclerView recyclerView) {
        if (recyclerView.getAdapter().getItemCount() != 0) {
            int lastVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
            if (lastVisibleItemPosition != RecyclerView.NO_POSITION && lastVisibleItemPosition == recyclerView.getAdapter().getItemCount() - 1)
                return true;
        }
        return false;
    }



}