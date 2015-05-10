package com.parkclient;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity /*implements OnClickListener*/ {

	Toast tst;
	Button btn1, btn2;
	// 2. 按钮单击响应事件
	/*
    class MyClickListener implements OnClickListener
    {
    	@Override
    	public void onClick(View v)
    	{
    		// TODO Auto-generated method stub
    		switch (v.getId()) 
    		{
    			case R.id.button1:
    				tst = Toast.makeText(MainActivity.this, "111111111", Toast.LENGTH_SHORT);
    				tst.show(); 
    				break;       
    			case R.id.button2:
    				tst = Toast.makeText(MainActivity.this, "222222222", Toast.LENGTH_SHORT);
    				tst.show(); 
    				break;
    			default: 
    				break; 
    		}  
    	}
    }
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);

//        btn1.setOnClickListener(this);
//        btn2.setOnClickListener(this);
        
//        btn1.setOnClickListener(new MyClickListener());
//        btn2.setOnClickListener(new MyClickListener());
       
        // 1. 按钮单击事件响应
        /*
        btn1.setOnClickListener(new OnClickListener() { 
        	@Override
        	public void onClick(View v) { 
        	Toast tst = Toast.makeText(MainActivity.this, "111111111", Toast.LENGTH_SHORT);
        	tst.show();         
        	}
        });        
        
        btn2.setOnClickListener(new OnClickListener() { 
        	@Override
        	public void onClick(View v) { 
        	Toast tst = Toast.makeText(MainActivity.this, "22222222", Toast.LENGTH_SHORT);
        	tst.show();         
        	}
        });*/

    }
//    @Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		switch (v.getId()) 
		{
			case R.id.button1:
				tst = Toast.makeText(MainActivity.this, "111111111", Toast.LENGTH_SHORT);
				tst.show(); 
				Intent in = new Intent();
				in.setClass(this, Login.class);
				startActivity(in);
				break;       
			case R.id.button2:
				tst = Toast.makeText(MainActivity.this, "222222222", Toast.LENGTH_SHORT);
				tst.show(); 
				break;
			default: 
				break; 
		}  
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
