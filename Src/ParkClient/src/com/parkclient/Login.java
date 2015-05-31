package com.parkclient;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class Login extends Activity {

	Toast tst;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		switch (v.getId()) 
		{
			case R.id.register:
				Intent in = new Intent();
				in.setClass(this, PersonMgr.class);
				startActivity(in);
//				tst = Toast.makeText(Login.this, "ÎÒÒª×¢²á", Toast.LENGTH_SHORT);
//				tst.show(); 
				break;
			default: 
				break; 
		}  
	}

}
