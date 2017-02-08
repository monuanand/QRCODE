package com.example.survograph;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Profile extends Activity {
	DBAdapter1 db = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.profile);
		Intent i = getIntent();
		String strusername = i.getStringExtra("username");
		db = new DBAdapter1(this);
		db.open();
		Cursor c = db.getUserByUsername(strusername);

		if (c.moveToFirst()) {
			// do {
			DisplayDetails(c);
			// } while (c.moveToNext());
		}
		c.close();
		db.close();
		System.out.println("2");
	}

	public void DisplayDetails(Cursor c) {

		// ---create a layout---
		final LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);

		LinearLayout.LayoutParams layoutParam = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		layoutParam.gravity = Gravity.BOTTOM;

		this.addContentView(layout, layoutParam);

		final TextView tv1 = new TextView(this);
		tv1.setTextSize(15);

		try {

			final String userdetails = "\nUsername:~~~~~ " + c.getString(1)
					+ "\n\nUser Type:~~~~ " + c.getString(2) + "\n\nName:~~~~ "
					+ c.getString(5) + " " + c.getString(6)
					+ "\n\nFather's Name:~~~~ " + c.getString(4) + "\n\nMobile:~~~~ "
					+ c.getString(7) + "\n\nEmail id:~~~~ " + c.getString(8)
					+ "\n\nAddress:~~~~ " + c.getString(9) + "\n\nRegisration Date:~~~~ss "
					+ c.getString(10);

			tv1.setText(userdetails);

			layout.addView(tv1);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}
@Override
public void onBackPressed() {
	// TODO Auto-generated method stub
	super.onBackPressed();
	db.close();
}
}
