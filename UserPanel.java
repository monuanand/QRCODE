package com.example.survograph;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;

public class UserPanel extends Activity {
	String userid;
	private ProgressDialog prgDialog;
	
	String value;
	
	private SharedPreferences preferences;
	private String username;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_panel);
		username=getIntent().getStringExtra("username");
		preferences = PreferenceManager
				.getDefaultSharedPreferences(getApplicationContext());
	}

public void profile(View v){
	Intent i = new Intent(getBaseContext(), Profile.class);
	i.putExtra("username", username);
	i.putExtra("username", username);
	startActivity(i);
}
	

	public void save(View v) {
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void check(View v){
	
	}
	
	
	
	
}
