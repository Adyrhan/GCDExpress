package com.aperezhrd.gcdexpress;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class EuclidesGCD extends Activity {
	TextView tvGCD;
	TableLayout tableEuclides;
	private final int TEXTVIEW_MIN_EMS = 4;
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_euclides_gcd);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		tvGCD = (TextView) findViewById(R.id.tvGCD);
		
		Intent intentFromInput = getIntent();
		int a = intentFromInput.getIntExtra(InputNumbers.EXTRA_FIRST_NUMBER, 0);
		int b = intentFromInput.getIntExtra(InputNumbers.EXTRA_SECOND_NUMBER, 0);
		
		GCD gcd = new GCD(a, b);
		tvGCD.setText(Integer.toString(gcd.getGCD()));
		
		// Draw the Euclides algorithm table //
		//                                   //
		tableEuclides = (TableLayout) findViewById(R.id.table);
		
		TableRow tr = new TableRow(this);
		TextView tv = new TextView(this);
		tv.setText("(  )");
		
		tr.addView(tv);
		
		// Quotients
		for(Division division : gcd.getDivisions()) {
			tv = new TextView(this);
			tv.setText(Integer.toString(division.getQuotient()));
			tv.setMinEms(TEXTVIEW_MIN_EMS);
			tr.addView(tv);
		}
		tableEuclides.addView(tr);
		
		tr = new TableRow(this);
		
		// Dividends and divisors
		tv = new TextView(this);
		tv.setText(Integer.toString(gcd.getDivisions().get(0).getDividend())); //Adding the first one
		tv.setMinEms(TEXTVIEW_MIN_EMS);
		tr.addView(tv);
		for(Division division : gcd.getDivisions()) {
			tv = new TextView(this);
			tv.setText(Integer.toString(division.getDivisor()));
			tv.setMinEms(TEXTVIEW_MIN_EMS);
			tr.addView(tv);
		}
		tableEuclides.addView(tr);
		
		tr = new TableRow(this);
		// Remainders
		for(Division division : gcd.getDivisions()) {
			tv = new TextView(this);
			tv.setText(Integer.toString(division.getRemainder()));
			tv.setMinEms(5);
			tr.addView(tv);
		}
		tableEuclides.addView(tr);
		
		
		// Show the Up button in the action bar.
		if(android.os.Build.VERSION.SDK_INT >
		   android.os.Build.VERSION_CODES.HONEYCOMB)
			getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_euclides_gcd, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
