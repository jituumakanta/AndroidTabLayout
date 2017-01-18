package com.example.jitu.androidtablayout;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    //This is our tablayout
    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    public List<ListItem> listTrndingNewsData, listTrndingNewsData3, listTrndingNewsData4, listTrndingNewsData5, listTrndingNewsData6, listTrndingNewsData7, listTrndingNewsData8, listTrndingNewsData9;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Toast.makeText(MainActivity.this,"hghg",Toast.LENGTH_LONG).show();
        //Adding toolbar to the activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Recommend"));
        tabLayout.addTab(tabLayout.newTab().setText("India"));
        tabLayout.addTab(tabLayout.newTab().setText("Sports"));
        tabLayout.addTab(tabLayout.newTab().setText("Technology"));
        tabLayout.addTab(tabLayout.newTab().setText("Increadble"));
        tabLayout.addTab(tabLayout.newTab().setText("World"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.pager);
        //Creating our pager adapter
        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());
        //Adding adapter to pager
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //Adding onTabSelectedListener to swipe views
      //  tabLayout.setOnTabSelectedListener(this);
      //  tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

   /* private void getTrndingNews() {

        String url = "https://newsapi.org/v1/articles?source=the-hindu&sortBy=top&apiKey=deefb5dee51948a0a57217651cb54c47";
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData(o);

                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);

        String url1 = "https://newsapi.org/v1/articles?source=the-times-of-india&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData(o);

                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest1);

        String url2 = "https://newsapi.org/v1/articles?source=the-telegraph&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest2 = new JsonObjectRequest(Request.Method.GET, url2, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData(o);

                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest2);

        String url3 = "https://newsapi.org/v1/articles?source=the-huffington-post&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest3 = new JsonObjectRequest(Request.Method.GET, url3, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData(o);

                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest3);

        String url4 = "https://newsapi.org/v1/articles?source=reuters&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest4 = new JsonObjectRequest(Request.Method.GET, url4, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData(o);

                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest4);

        String url5 = "https://newsapi.org/v1/articles?source=focus&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest5 = new JsonObjectRequest(Request.Method.GET, url5, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest5);


    }

    public void praseJsonNewsData(JSONObject o) {
        JSONObject jj = o;
        JSONArray rr;
        JSONObject jjj;
        ListItem lt;

        try {
            String statuss = jj.getString("status");
            String sourcee = jj.getString("source");
            String sortBy = jj.getString("sortBy");
            // converting object to array
            rr = jj.getJSONArray("articles");

            for (int i = 0; i < rr.length(); i++) {
                lt = new ListItem();
                jjj = rr.getJSONObject(i);
                String authorr = jjj.getString("author");
                String titlee = jjj.getString("title");
                String descriptionn = jjj.getString("description");
                String urll = jjj.getString("url");
                String urlToImagee = jjj.getString("urlToImage");
                String publishedAtt = jjj.getString("publishedAt");

                lt.setAuthor(authorr);
                lt.setTitle(titlee);
                lt.setDescription(descriptionn);
                lt.setUral(urll);
                lt.seturlToImage(urlToImagee);
                lt.setpPublishedAt(publishedAtt);
                lt.setSouce(sourcee);
                listTrndingNewsData.add(lt);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        adapter = new CardAdapter1(listTrndingNewsData, this);
        recyclerView.setAdapter(adapter);


    }

    private void getCricketNews() {
        String url5 = "https://newsapi.org/v1/articles?source=espn&sortBy=top&apiKey=deefb5dee51948a0a57217651cb54c47";
        JsonObjectRequest jsObjRequest5 = new JsonObjectRequest(Request.Method.GET, url5, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData3(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest5);

        String url1 = "https://newsapi.org/v1/articles?source=espn-cric-info&sortBy=top&apiKey=deefb5dee51948a0a57217651cb54c47";
        JsonObjectRequest jsObjRequest1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData3(o);

                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest1);

        String url6 = "https://newsapi.org/v1/articles?source=bbc-sport&sortBy=top&apiKey=deefb5dee51948a0a57217651cb54c47";
        JsonObjectRequest jsObjRequest6 = new JsonObjectRequest(Request.Method.GET, url6, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData3(o);

                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest6);

        String url7 = "https://newsapi.org/v1/articles?source=football-italia&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest7 = new JsonObjectRequest(Request.Method.GET, url7, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData3(o);

                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest7);

        String url8 = "https://newsapi.org/v1/articles?source=four-four-two&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest8 = new JsonObjectRequest(Request.Method.GET, url8, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData3(o);

                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest8);

        String url9 = "https://newsapi.org/v1/articles?source=bbc-sport&sortBy=top&apiKey=deefb5dee51948a0a57217651cb54c47";
        JsonObjectRequest jsObjRequest9 = new JsonObjectRequest(Request.Method.GET, url9, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData3(o);

                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest9);

        String url10 = "https://newsapi.org/v1/articles?source=nfl-news&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest10 = new JsonObjectRequest(Request.Method.GET, url10, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData3(o);

                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest10);

        String url11 = "https://newsapi.org/v1/articles?source=sky-sports-news&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest11 = new JsonObjectRequest(Request.Method.GET, url11, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData3(o);

                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest11);

        String url12 = "https://newsapi.org/v1/articles?source=talksport&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest12 = new JsonObjectRequest(Request.Method.GET, url12, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData3(o);

                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest12);

        String url13 = "https://newsapi.org/v1/articles?source=the-sport-bible&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest13 = new JsonObjectRequest(Request.Method.GET, url13, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData3(o);

                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest13);

    }

    public void praseJsonNewsData3(JSONObject o) {
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
                listTrndingNewsData3.add(lt3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        adapter = new CardAdapter1(listTrndingNewsData3, this);
        recyclerView.setAdapter(adapter);

    }

    private void getTechnologyNews() {

        String url5 = "https://newsapi.org/v1/articles?source=engadget&sortBy=top&apiKey=deefb5dee51948a0a57217651cb54c47";
        JsonObjectRequest jsObjRequest5 = new JsonObjectRequest(Request.Method.GET, url5, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData4(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest5);

        String url9 = "https://newsapi.org/v1/articles?source=new-scientist&sortBy=top&apiKey=deefb5dee51948a0a57217651cb54c47";
        JsonObjectRequest jsObjRequest9 = new JsonObjectRequest(Request.Method.GET, url9, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData4(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest9);

        String url3 = "https://newsapi.org/v1/articles?source=techradar&sortBy=top&apiKey=deefb5dee51948a0a57217651cb54c47";
        JsonObjectRequest jsObjRequest3 = new JsonObjectRequest(Request.Method.GET, url3, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData4(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest3);


        String url4 = "https://newsapi.org/v1/articles?source=techradar&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest4 = new JsonObjectRequest(Request.Method.GET, url4, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData4(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest4);


        String url7 = "https://newsapi.org/v1/articles?source=t3n&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest7 = new JsonObjectRequest(Request.Method.GET, url7, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData4(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest7);


        String url6 = "https://newsapi.org/v1/articles?source=new-scientist&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest6 = new JsonObjectRequest(Request.Method.GET, url6, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData4(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest6);


        String url8 = "https://newsapi.org/v1/articles?source=mashable&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest8 = new JsonObjectRequest(Request.Method.GET, url8, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData4(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest8);


        String url10 = "https://newsapi.org/v1/articles?source=entertainment-weekly&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest10 = new JsonObjectRequest(Request.Method.GET, url10, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData4(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest10);


        String url11 = "https://newsapi.org/v1/articles?source=engadget&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest11 = new JsonObjectRequest(Request.Method.GET, url11, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData4(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest11);


    }

    public void praseJsonNewsData4(JSONObject o) {
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
                listTrndingNewsData4.add(lt3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        adapter = new CardAdapter1(listTrndingNewsData4, this);
        recyclerView.setAdapter(adapter);
    }

    private void getIncreadbleNews() {

        String url5 = "https://newsapi.org/v1/articles?source=national-geographic&sortBy=top&apiKey=deefb5dee51948a0a57217651cb54c47";
        JsonObjectRequest jsObjRequest5 = new JsonObjectRequest(Request.Method.GET, url5, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData5(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest5);

        String url51 = "https://newsapi.org/v1/articles?source=ars-technica&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest51 = new JsonObjectRequest(Request.Method.GET, url51, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData5(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest51);

        String url511 = "https://newsapi.org/v1/articles?source=new-scientist&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest511 = new JsonObjectRequest(Request.Method.GET, url511, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData5(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest511);


    }

    public void praseJsonNewsData5(JSONObject o) {
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
                listTrndingNewsData5.add(lt3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        adapter = new CardAdapter1(listTrndingNewsData5, this);
        recyclerView.setAdapter(adapter);
    }

    private void getworldNews() {

        String url5 = "https://newsapi.org/v1/articles?source=time&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest5 = new JsonObjectRequest(Request.Method.GET, url5, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData6(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest5);


        String url7 = "https://newsapi.org/v1/articles?source=the-washington-post&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest7 = new JsonObjectRequest(Request.Method.GET, url7, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData6(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest7);

        String url8 = "https://newsapi.org/v1/articles?source=the-wall-street-journal&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest8 = new JsonObjectRequest(Request.Method.GET, url8, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData6(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest8);

        String url81 = "https://newsapi.org/v1/articles?source=the-guardian-au&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest81 = new JsonObjectRequest(Request.Method.GET, url81, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData6(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest81);

        String url82 = "https://newsapi.org/v1/articles?source=the-economist&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest82 = new JsonObjectRequest(Request.Method.GET, url82, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData6(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest82);

        String url83 = "https://newsapi.org/v1/articles?source=sky-news&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest83 = new JsonObjectRequest(Request.Method.GET, url83, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData6(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest83);

        String url84 = "https://newsapi.org/v1/articles?source=newsweek&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest84 = new JsonObjectRequest(Request.Method.GET, url84, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData6(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest84);

        String url842 = "https://newsapi.org/v1/articles?source=mirror&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest842 = new JsonObjectRequest(Request.Method.GET, url842, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData6(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest842);


        String url841 = "https://newsapi.org/v1/articles?source=metro&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest841 = new JsonObjectRequest(Request.Method.GET, url841, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData6(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest841);


        String url8411 = " https://newsapi.org/v1/articles?source=gruenderszene&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest8411 = new JsonObjectRequest(Request.Method.GET, url8411, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData6(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest8411);


        String url8414 = "https://newsapi.org/v1/articles?source=fortune&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest8414 = new JsonObjectRequest(Request.Method.GET, url8414, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData6(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest8414);


        String url84131 = "https://newsapi.org/v1/articles?source=financial-times&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest84131 = new JsonObjectRequest(Request.Method.GET, url84131, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData6(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest84131);


        String url8417 = "https://newsapi.org/v1/articles?source=daily-mail&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest8417 = new JsonObjectRequest(Request.Method.GET, url8417, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData6(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest8417);

        String url89 = "https://newsapi.org/v1/articles?source=cnbc&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest89 = new JsonObjectRequest(Request.Method.GET, url89, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData6(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest89);


        String url891 = "https://newsapi.org/v1/articles?source=bloomberg&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest891 = new JsonObjectRequest(Request.Method.GET, url891, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData6(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest891);


        String url8911 = " https://newsapi.org/v1/articles?source=bbc-news&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest8911 = new JsonObjectRequest(Request.Method.GET, url8911, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData6(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest8911);


    }

    public void praseJsonNewsData6(JSONObject o) {
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
                listTrndingNewsData6.add(lt3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        adapter = new CardAdapter1(listTrndingNewsData6, this);
        recyclerView.setAdapter(adapter);
    }

    private void getIndiaNews() {

        String url5 = "https://newsapi.org/v1/articles?source=ars-technica&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest5 = new JsonObjectRequest(Request.Method.GET, url5, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData7(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest5);

        String url7 = "https://newsapi.org/v1/articles?source=hacker-news&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest7 = new JsonObjectRequest(Request.Method.GET, url7, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData7(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest7);

        String url71 = "https://newsapi.org/v1/articles?source=national-geographic&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest71 = new JsonObjectRequest(Request.Method.GET, url71, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData7(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest71);



        String url51 = "https://newsapi.org/v1/articles?source=reddit-r-all&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest51 = new JsonObjectRequest(Request.Method.GET, url51, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData7(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest51);


        String url511 = "https://newsapi.org/v1/articles?source=the-lad-bible&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest511 = new JsonObjectRequest(Request.Method.GET, url511, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData7(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest511);

        String url5111 = "https://newsapi.org/v1/articles?source=the-next-web&sortBy=latest&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest5111 = new JsonObjectRequest(Request.Method.GET, url5111, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData7(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest5111);

        String url51111 = "https://newsapi.org/v1/articles?source=wired-de&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest51111 = new JsonObjectRequest(Request.Method.GET, url51111, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData7(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest51111);


    }

    public void praseJsonNewsData7(JSONObject o) {
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
                listTrndingNewsData7.add(lt3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        adapter = new CardAdapter1(listTrndingNewsData7, this);
        recyclerView.setAdapter(adapter);
    }

    private void getentertainmentNews() {

        String url5 = "https://newsapi.org/v1/articles?source=entertainment-weekly&sortBy=top&apiKey=deefb5dee51948a0a57217651cb54c47";
        JsonObjectRequest jsObjRequest5 = new JsonObjectRequest(Request.Method.GET, url5, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData8(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest5);

        String url51 = "https://newsapi.org/v1/articles?source=mtv-news&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest51 = new JsonObjectRequest(Request.Method.GET, url51, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData8(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest51);

        String url511 = "https://newsapi.org/v1/articles?source=ign&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest511 = new JsonObjectRequest(Request.Method.GET, url511, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData8(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest511);


        String url52 = " https://newsapi.org/v1/articles?source=associated-press&sortBy=top&apiKey=41dbfb9f7c854533ab8ac78c91b664ed";
        JsonObjectRequest jsObjRequest52 = new JsonObjectRequest(Request.Method.GET, url52, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData8(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest52);


    }

    public void praseJsonNewsData8(JSONObject o) {
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
                listTrndingNewsData8.add(lt3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        adapter = new CardAdapter1(listTrndingNewsData8, this);
        recyclerView.setAdapter(adapter);
    }

    private void getofferNews() {

        String url5 = "http://hellohelps.com/HelloHelps/getnews.php";
        JsonObjectRequest jsObjRequest5 = new JsonObjectRequest(Request.Method.GET, url5, null, new Response.Listener<JSONObject>() {
            JSONObject o;

            @Override
            public void onResponse(JSONObject response) {
                o = response;
                praseJsonNewsData9(o);
                // Toast.makeText(getApplicationContext(),""+o,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest5);


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
        adapter = new CardAdapter2(listTrndingNewsData9, this);
        recyclerView.setAdapter(adapter);
    }*/


}
