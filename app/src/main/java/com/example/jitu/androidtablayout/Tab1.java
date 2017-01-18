package com.example.jitu.androidtablayout;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
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

public class Tab1 extends Fragment {
    RecyclerView recyclerView0;
    RecyclerView.LayoutManager layoutManager0;
    RecyclerView.Adapter adapter0;
    List<ListItem> listTrndingNewsData0;
    //ProgressDialog uploading;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.tab1, container, false);
        recyclerView0 = (RecyclerView) view.findViewById(R.id.recyclerView1);
        recyclerView0.setHasFixedSize(true);

        layoutManager0 = new LinearLayoutManager(getActivity());
        recyclerView0.setLayoutManager(layoutManager0);
        listTrndingNewsData0 = new ArrayList<>();
      /*  listSuperHeroes = new ArrayList<>();
        ListItem ListItem = new ListItem();

        for (int i = 1; i < 40; i++) {
            ListItem.setName("hgng");
            ListItem.setUrl("fhncenj");
            listSuperHeroes.add(ListItem);
        }
        adapter = new CardAdapter(listSuperHeroes, getActivity());
        //Adding adapter to recyclerview
        recyclerView.setAdapter(adapter);*/
        getTrndingNews0();
        return view;
    }



    public void getTrndingNews0() {
        //uploading = ProgressDialog.show(getActivity(), "Loading", "Please wait...", false, false);
        String url5 = "https://newsapi.org/v1/articles?source=associated-press&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest5 = new JsonObjectRequest(Request.Method.GET, url5, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData0(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(getActivity()).addToRequestQueue(jsObjRequest5);

        String url1 = "https://newsapi.org/v1/articles?source=abc-news-au&sortBy=top&apiKey=    41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData0(o);

                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(getActivity()).addToRequestQueue(jsObjRequest1);

        String url3 = "https://newsapi.org/v1/articles?source=engadget&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest3 = new JsonObjectRequest(Request.Method.GET, url3, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData0(o);

                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(getActivity()).addToRequestQueue(jsObjRequest3);

        String url4 = "https://newsapi.org/v1/articles?source=entertainment-weekly&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest4 = new JsonObjectRequest(Request.Method.GET, url4, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData0(o);

                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(getActivity()).addToRequestQueue(jsObjRequest4);

        String url6 = "https://newsapi.org/v1/articles?source=google-news&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest6 = new JsonObjectRequest(Request.Method.GET, url6, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData0(o);

                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(getActivity()).addToRequestQueue(jsObjRequest6);

        String url7 = "https://newsapi.org/v1/articles?source=reuters&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest7 = new JsonObjectRequest(Request.Method.GET, url7, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData0(o);

                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(getActivity()).addToRequestQueue(jsObjRequest7);

        String url8 = "https://newsapi.org/v1/articles?source=the-hindu&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest8 = new JsonObjectRequest(Request.Method.GET, url8, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData0(o);

                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(getActivity()).addToRequestQueue(jsObjRequest8);
    }

    public void praseJsonNewsData0(JSONObject o) {
        JSONObject jj = o;
        JSONArray rr;
        JSONObject jjj;
        ListItem lt3;

        try {
            String statuss = jj.getString("status");
            String sourcee = jj.getString("source");
            String sortBy = jj.getString("sortBy");
            // converting object to array
            rr = jj.getJSONArray("articles");

            for (int i = 0; i < rr.length(); i++) {
                lt3 = new ListItem();
                jjj = rr.getJSONObject(i);
                String authorr = jjj.getString("author");
                String titlee = jjj.getString("title");
                String descriptionn = jjj.getString("description");
                String urll = jjj.getString("url");
                String urlToImagee = jjj.getString("urlToImage");
                String publishedAtt = jjj.getString("publishedAt");

                lt3.setAuthor(authorr);
                lt3.setTitle(titlee);
                lt3.setDescription(descriptionn);
                lt3.setUral(urll);
                lt3.seturlToImage(urlToImagee);
                lt3.setpPublishedAt(publishedAtt);
                lt3.setSouce(sourcee);
                listTrndingNewsData0.add(lt3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        adapter0 = new CardAdapter1(listTrndingNewsData0, getActivity());
        recyclerView0.setAdapter(adapter0);
        //uploading.dismiss();
    }

}