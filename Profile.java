package com.example.user;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.scanner.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.ByteMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.File;
import java.io.FileOutputStream;


public class Profile extends Activity {
	DBAdapter1 db = null;
TextView tvDetails;
	ImageView imgQR;
	String username;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.details);
		tvDetails= (TextView) findViewById(R.id.tvDetails1);
		imgQR= (ImageView) findViewById(R.id.ivImage);
		Intent i = getIntent();
		username = i.getStringExtra("username");
		db = new DBAdapter1(this);
		db.open();
		Cursor c = db.getUserByUsername(username);

		if (c.moveToFirst()) {
			// do {
			DisplayDetails(c);
			// } while (c.moveToNext());
		}
		c.close();
		db.close();
		System.out.println("2");
	}
	String path;
public  void generateQRCODE(View v){
	QRCodeWriter writer = new QRCodeWriter();

	try {
		ByteMatrix bitMatrix = writer.encode("userdetails:"+tvDetails.getText()
				.toString(),
				BarcodeFormat.QR_CODE, 512, 512);
		int width = 512;
		int height = 512;
		Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (bitMatrix.get(x, y)==0)
					bmp.setPixel(x, y, Color.BLACK);
				else
					bmp.setPixel(x, y, Color.WHITE);
			}
		}
		FileOutputStream out = null;
		try {
			 path = Environment.getExternalStorageDirectory().toString();
			path=path+"/"+username+".png";
			out = new FileOutputStream(path);
			bmp.compress(Bitmap.CompressFormat.PNG, 100, out); // bmp is your Bitmap instance
			// PNG is a lossless format, the compression factor (100) is ignored
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		imgQR.setImageBitmap(bmp);
	} catch (Exception e) {
		//Log.e("QR ERROR", ""+e);
e.printStackTrace();
	}
}

	public void DisplayDetails(Cursor c) {

		// ---create a layout---


		try {

			final String userdetails = "\nUsername:~~~~~ " + c.getString(1)
					+ "\n\nUser Type:~~~~ " + c.getString(2) + "\n\nName:~~~~ "
					+ c.getString(5) + " " + c.getString(6)
					+ "\n\nFather's Name:~~~~ " + c.getString(4) + "\n\nMobile:~~~~ "
					+ c.getString(7) + "\n\nEmail id:~~~~ " + c.getString(8)
					+ "\n\nAddress:~~~~ " + c.getString(9) + "\n\nRegisration Date:~~~~ss "
					+ c.getString(10);

			tvDetails.setText(userdetails);


			db.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}
public  void share(View v){
	Intent intentShareFile = new Intent(Intent.ACTION_SEND);
	File fileWithinMyDir = new File(path);

	if(fileWithinMyDir.exists()) {


		intentShareFile.setType("application/pdf");
		intentShareFile.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://"+fileWithinMyDir));

		intentShareFile.putExtra(Intent.EXTRA_SUBJECT,
				"Sharing QRCODE...");
		intentShareFile.putExtra(Intent.EXTRA_TEXT, "Sharing QRCODE...");

		startActivity(Intent.createChooser(intentShareFile, "Share QRCODE"));
	}
}
@Override
public void onBackPressed() {
	// TODO Auto-generated method stub
	super.onBackPressed();
	db.close();
}
}
