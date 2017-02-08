package com.example.survograph;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.example.survograph.R;

public class MainActivity extends Activity {
String SDCARD=Environment.getExternalStorageDirectory().getPath();
TextView txtPermission;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txtPermission=(TextView) findViewById(R.id.txtpermission);
			}
	
	
	
	public void login(View v){
		Intent i = new Intent(getBaseContext(), LoginActivity.class);
		startActivity(i);
	}
	
    
    
	public void createAccount(View v){
		Intent i = new Intent(getBaseContext(), Registeration.class);
		 i.putExtra("usertype", "user");
		startActivity(i);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
