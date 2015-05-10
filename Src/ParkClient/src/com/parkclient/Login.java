package com.parkclient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.ProgressDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class Login extends Activity {

	Toast tst;
    private String TAG = this.getClass().getSimpleName();
    private RequestQueue mRequestQueue;
    private ProgressDialog pd;
    private ArrayList<NewsModel> arrNews ;
    
    private Handler handler =new Handler(){
        @Override
        public void handleMessage(Message msg){
           super.handleMessage(msg);
           pd.dismiss();
        }
     };
     
     
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}

    @Override
    protected void onStart()
    {
    	startRequest();
		super.onStart();  
    }
    

	private void startRequest()
	{
       pd= ProgressDialog.show(Login.this, "µÇÂ½", "µÇÂ¼ÖÐ£¬ÇëÉÔºò...");
       new Thread()
       {
          public void run()
          {
//            String url = "http://192.168.1.104/APP/parkpark/login.php?";
//          	JsonObjectRequest jr = createPostModeRequest(Request.Method.POST,url);
            String url = "http://192.168.1.104/APP/parkpark/login.php?uname=admin&upassword=admin";
          	JsonObjectRequest jr = createGetModeRequest(Request.Method.GET,url);
          	addToRequestQueue(jr);
          }
       }.start();
	 }
	
	public RequestQueue getRequestQueue() 
	{
		if (mRequestQueue == null) {
			mRequestQueue = Volley.newRequestQueue(getApplicationContext());
			}        
		return mRequestQueue;    
	}

	public <T> void addToRequestQueue(Request<T> req, String tag) 
	{
		req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }
	
	public <T> void addToRequestQueue(Request<T> req) 
	{
		req.setTag(TAG);
        getRequestQueue().add(req);
    }

	public JsonObjectRequest createGetModeRequest(int method, String url)
	{
		JsonObjectRequest jr = new JsonObjectRequest(url,null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i(TAG,response.toString());
                parseJSON(response);
                handler.sendEmptyMessage(0);
;            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG,error.getMessage());
                handler.sendEmptyMessage(0);
            }
        });
		return jr;
	}
	
	public JsonObjectRequest createPostModeRequest(int method, String url)
	{
		Map<String,String> map=new HashMap<String,String>();
		map.put("uname", "admin");
		map.put("upassword", "admin");
		JSONObject params=new JSONObject(map);
		JsonObjectRequest jr = new JsonObjectRequest(method,url,params,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i(TAG,response.toString());
                parseJSON(response);
                handler.sendEmptyMessage(0);
;            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG,error.getMessage());
                handler.sendEmptyMessage(0);
            }
        });
		return jr;
	}

    private void parseJSON(JSONObject json){
        try{
            JSONObject value = json.getJSONObject("value");
            JSONArray items = value.getJSONArray("items");
            for(int i=0;i<items.length();i++){

                    JSONObject item = items.getJSONObject(i);
                    NewsModel nm = new NewsModel();
                    nm.setTitle(item.optString("title"));
                    nm.setDescription(item.optString("description"));
                    nm.setLink(item.optString("link"));
                    nm.setPubDate(item.optString("pubDate"));
                    arrNews.add(nm);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    class NewsModel{
        private String title;
        private String link;
        private String description;
        private String pubDate;

        void setTitle(String title) {
            this.title = title;
        }

        void setLink(String link) {
            this.link = link;
        }

        void setDescription(String description) {
            this.description = description;
        }

        void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }

        String getLink() {
            return link;
        }

        String getDescription() {
            return description;
        }

        String getPubDate() {
            return pubDate;
        }

        String getTitle() {

            return title;
        }
    }

    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
