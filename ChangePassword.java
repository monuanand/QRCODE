package com.example.survograph;

import com.example.survograph.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassword extends Activity {
	String strCurrentPass = null, strNewPass = null, strConfirmPass = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_change_password);
		final EditText etCurrentPass = (EditText) findViewById(R.id.etCurrentPassword);
		final EditText etNewPass = (EditText) findViewById(R.id.etNewPassword);
		final EditText etconfirmpass = (EditText) findViewById(R.id.etConfirmPassword);

		Intent i = getIntent();
		final String username = i.getStringExtra("username");
		Button btnUpdatePass = (Button) findViewById(R.id.btnChangePass);
		Button btnCancelUpdate = (Button) findViewById(R.id.btnCancelUpdatePassword);
		btnUpdatePass.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				strCurrentPass = etCurrentPass.getText().toString();
				strConfirmPass = etconfirmpass.getText().toString();
				strNewPass = etNewPass.getText().toString();
				if (strConfirmPass.length() < 6) {
					Toast.makeText(getApplication(),
							"Password should be more than six characters!",
							Toast.LENGTH_SHORT).show();
				} else {
					System.out.println("curr" + strCurrentPass + "new:"
							+ strNewPass + "confirm:" + strConfirmPass);
					DBAdapter1 db = new DBAdapter1(getApplication());
					db.open();
					if (db.validateUser(username, strCurrentPass)) {

						if (strNewPass.equalsIgnoreCase(strConfirmPass)) {

							db.updatePassword(username, strNewPass);
							Toast.makeText(getApplication(),
									"Password Updated!", Toast.LENGTH_SHORT)
									.show();
						} else
							Toast.makeText(
									getApplication(),
									"New Password & Confirm Password Field do not match.",
									Toast.LENGTH_SHORT).show();
					} else
						Toast.makeText(getApplication(), "Wrong Password!",
								Toast.LENGTH_SHORT).show();

					db.close();
					finish();
				}
			}
		});
		btnCancelUpdate.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.change_password, menu);
		return true;
	}

}
