package com.wickedsoftwaredesigns.java1week1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	LinearLayout ll;
	LinearLayout.LayoutParams lp;
	EditText et;
	TextView result;
	String pilot1;
	String pilot2;
	String pilot3;
	String pilot4;
	String plane1;
	String plane2;
	String plane3;
	String plane4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		ll.setLayoutParams(lp);
		
		TextView tv = new TextView(this);
		tv.setText("Today's Pilot List:");
		ll.addView(tv);
		
		TextView pilotList = new TextView(this);
		pilot1 = getResources().getString(R.string.pilot1);
		pilot2 = getResources().getString(R.string.pilot2);
		pilot3 = getResources().getString(R.string.pilot3);
		pilot4 = getResources().getString(R.string.pilot4);
		pilotList.setText("Pilot 1: " + pilot1 + "\r\n" +
						  "Pilot 2: " + pilot2 + "\r\n" +
						  "Pilot 3: " + pilot3 + "\r\n" +
						  "Pilot 4: " + pilot4 + "\r\n");
		ll.addView(pilotList);
		
		TextView tv2 = new TextView(this);
		tv2.setText("Today's Plane List:");
		ll.addView(tv2);
		
		TextView planeList = new TextView(this);
		plane1 = getResources().getString(R.string.plane1);
		plane2 = getResources().getString(R.string.plane2);
		plane3 = getResources().getString(R.string.plane3);
		plane4 = getResources().getString(R.string.plane4);
		planeList.setText("Plane 1: " + plane1 + "\r\n" +
				  		  "Plane 2: " + plane2 + "\r\n" +
				  		  "Plane 3: " + plane3 + "\r\n" +
				  		  "plane 4: " + plane4 + "\r\n");
		ll.addView(planeList);
		
		et = new EditText(this);
		et.setHint("Enter Number of Flights");
		
		
		Button b = new Button(this);
		b.setText("Total");
		//ll.addView(b);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int plane1Time = getResources().getInteger(R.integer.plane1);
				int plane2Time = getResources().getInteger(R.integer.plane2);
				int plane3Time = getResources().getInteger(R.integer.plane3);
				int plane4Time = getResources().getInteger(R.integer.plane4);
				
				int entry = Integer.parseInt(et.getText().toString());
				
				int flightsPlane1 = plane1Time*entry;
				int flightsPlane2 = plane2Time*entry;
				int flightsPlane3 = plane3Time*entry;
				int flightsPlane4 = plane4Time*entry;
				
				result.setText(pilot1 + " has flown "+ plane1 + " for " + flightsPlane1 + " minutes today." +"\r\n" +
							   pilot1 + " has flown "+ plane2 + " for " + flightsPlane2 + " minutes today." +"\r\n" +
							   pilot1 + " has flown "+ plane3 + " for " + flightsPlane3 + " minutes today." +"\r\n" +
							   pilot1 + " has flown "+ plane4 + " for " + flightsPlane4 + " minutes today." +"\r\n"
						);
				
			}
		});
		
		LinearLayout form = new LinearLayout(this);
		form.setOrientation(LinearLayout.HORIZONTAL);
		lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		form.setLayoutParams(lp);
		
		form.addView(et);
		form.addView(b);
		
		ll.addView(form);
		
		result = new TextView(this);
		
		ll.addView(result);
		
		setContentView(ll);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
