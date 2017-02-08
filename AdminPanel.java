package com.example.survograph;


import com.example.survograph.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AdminPanel extends Activity {
	private String username;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin_panel);
		TextView tv=(TextView) findViewById(R.id.tvWelcome_admin);
		username=getIntent().getStringExtra("username");
		tv.setText(getIntent().getStringExtra("firstname"));
	}
	
	public void profile(View v){
		Intent i = new Intent(getBaseContext(), Profile.class);
		i.putExtra("username", username);
		i.putExtra("username", username);
		startActivity(i);
	}
	
	
	
	public void changePassword(View v){
		Intent i = new Intent(getBaseContext(), ChangePassword.class);
		i.putExtra("username", username);
		i.putExtra("from", "upload");
		startActivity(i);
	}
	
	
	
	public void logout(View v){
		Intent i1 = new Intent(getBaseContext(),
				LoginActivity.class);
		i1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i1);
	}
}
