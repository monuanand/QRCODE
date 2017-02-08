package com.example.survograph;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewUserDetails extends Activity {
	DBAdapter1 db = null;
	String strfrom = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.profile);
		Intent i = getIntent();
		String strDBID = i.getStringExtra("DBID");
		System.out.println("DBID="+strDBID);
		strfrom = i.getStringExtra("from");
		db = new DBAdapter1(this);
		db.open();
		//Cursor c = null;
	
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

			final String userdetails = "\nUsername: " + c.getString(1)
					+ "\nUser Type: " + c.getString(2) + "\nName: "
					+ c.getString(5) + " " + c.getString(6)
					+ "\nFather's Name: " + c.getString(4) + "\nMobile: "
					+ c.getString(7) + "\nEmail id: " + c.getString(8)
					+ "\nAddress: " + c.getString(9) + "\nRegisration Date: "
					+ c.getString(10);

			tv1.setText(userdetails);
			// tv1.setMarqueeRepeatLimit(3);
			layout.addView(tv1);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void DisplayTicketDetails(Cursor c) {

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

			final String userdetails = "\nUsername: " + c.getString(1)
					+ "\nDate: " + c.getString(2) + "\nTime: " + c.getString(3)
					+ "\nStatus: " + c.getString(4) + "\nAmount: "
					+ c.getString(5)+ "\nNo. of Tickets: "+c.getString(6)+"\nLocation: "+c.getString(7)+"\nTicket Validity: 2 Hours Only";

			tv1.setText(userdetails);
			// tv1.setMarqueeRepeatLimit(3);
			layout.addView(tv1);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	public void DisplayAllPlatformTicketDetails(Cursor c) {

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

			final String userdetails = "\nUsername: " + c.getString(1)
					+ "\nDate: " + c.getString(2) + "\nTime: " + c.getString(3)
					+ "\nStatus: " + c.getString(4) + "\nAmount: "
					+ c.getString(5)+ "\nNo. of Tickets: "+c.getString(6)+"\nLocation: "+c.getString(7)+"\nTicket Validity: 2 Hours Only";

			tv1.setText(userdetails);
			// tv1.setMarqueeRepeatLimit(3);
			layout.addView(tv1);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	public void displayValidGeneralTicketsDetails(Cursor c) {

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

			final String userdetails = "\nUsername: " + c.getString(1)
					+ "\nDate: " + c.getString(2) + "\nTime: " + c.getString(3)
					+ "\nSource: "+c.getString(4)+"Destination:"+c.getString(5)+"\nStatus: " + c.getString(6) + "\nAmount: "
					+ c.getString(7)+ "\nNo. of Tickets: "+c.getString(8)+"\nLocation: "+c.getString(9)+"\nValidity: 36 Hours only";

			tv1.setText(userdetails);
			// tv1.setMarqueeRepeatLimit(3);
			layout.addView(tv1);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	public void DisplayAllGeneralTickets(Cursor c) {

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

			final String userdetails = "\nUsername: " + c.getString(1)
					+ "\nDate: " + c.getString(2) + "\nTime: " + c.getString(3)
					+ "\nSource: "+c.getString(4)+"Destination:"+c.getString(5)+"\nStatus: " + c.getString(6) + "\nAmount: "
					+ c.getString(7)+ "\nNo. of Tickets: "+c.getString(8)+"\nLocation: "+c.getString(9)+"\nValidity: 36 Hours only";

			tv1.setText(userdetails);
			// tv1.setMarqueeRepeatLimit(3);
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