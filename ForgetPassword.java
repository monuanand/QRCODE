package com.example.survograph;

import com.example.survograph.R;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetPassword extends Activity{
	EditText etForget=null;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.forget_password);
	Button btnSubmit=(Button)findViewById(R.id.btnSumbitForget);
	etForget=(EditText) findViewById(R.id.etforgetPass);
	btnSubmit.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String email=etForget.getText().toString();
			String mobile="";
			String pass="";
			try{
			DBAdapter1 db=new DBAdapter1(getApplicationContext());
			db.open();
			Cursor c= db.getUserMobileByEmail(email);
			mobile=c.getString(0);
			 pass=c.getString(1);
			System.out.print("mob="+mobile+"pass"+pass);
			
			db.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if(!mobile.equalsIgnoreCase("")){
				try{
					SmsManager smsManager = SmsManager.getDefault();
					
						smsManager.sendTextMessage(mobile, null,"Your Password is: "+pass ,
								null, null);
						Toast.makeText(getApplicationContext(),
								"Password has been sent on your mobile", Toast.LENGTH_SHORT)
								.show();
					}catch (Exception e) {
						// TODO: handle exception
						Toast.makeText(getApplicationContext(),
								"An erro occured", Toast.LENGTH_SHORT).show();
					}
			}else Toast.makeText(getApplicationContext(),
					"Emailid not valid.", Toast.LENGTH_SHORT).show();
			
				
		}
	});
	
}
}
