package com.parkclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PersonMgr extends Activity {

	Toast tst;
     
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_person_mgr);
	}

	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		switch (v.getId()) 
		{
			case R.id.mgr_login:
				Intent in = new Intent();
				in.setClass(this, Login.class);
				startActivity(in);
				break;
			case R.id.returnBtn:
				Intent in1 = new Intent();
				in1.setClass(this, MainActivity.class);
				startActivity(in1);
			case R.id.my_park_area:
				tst = Toast.makeText(this, "我的车位", Toast.LENGTH_SHORT);
				tst.show(); 
				break;
			case R.id.my_order:
				tst = Toast.makeText(this, "我的订单", Toast.LENGTH_SHORT);
				tst.show(); 
				break;
			case R.id.msg_center:
				tst = Toast.makeText(this, "消息中心", Toast.LENGTH_SHORT);
				tst.show(); 
				break;
			case R.id.setting:
				tst = Toast.makeText(this, "设置", Toast.LENGTH_SHORT);
				tst.show(); 
				break;
			default: 
				break; 
		}  
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
