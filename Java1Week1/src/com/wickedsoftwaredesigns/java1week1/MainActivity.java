/*
 * project     Java1Week1
 * 
 * package		com.wickedsoftwaredesigns.java1week1
 * 
 * @author     Michael R. Smith Jr
 * 
 * date			Jul 11, 2013
 */
package com.wickedsoftwaredesigns.java1week1;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources.NotFoundException;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

// TODO: Auto-generated Javadoc
/**
 * The Class MainActivity.
 */
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
	String currentPilot;
	ToggleButton pilot1Button;
	ToggleButton pilot2Button;
	ToggleButton pilot3Button;
	ToggleButton pilot4Button;
	Boolean flying;
	TextView letsFly;
	
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		//Builds Linear Layout
		ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		
		ll.setLayoutParams(lp);
		//Adds Airfields Text
		TextView airfields = new TextView(this);
		airfields.setText("Local Airfields:");
		ll.addView(airfields);
		
		//Array and Loop to build the list of Airfields and add their TextView's
		String[] airfieldsArray = {"Bachaus Field", "Richardson RC Field", "North Dallas RC Club", "Sky High RC Field"};
		for (int i = 0; i < airfieldsArray.length; i++) {
			TextView airfield = new TextView(this);
			airfield.setText(airfieldsArray[i]);
			airfield.setId(i);
			ll.addView(airfield);
		}
		
		//Creating Pilots List
		TextView tv = new TextView(this);
		tv.setText("Today's Pilot List:");
		ll.addView(tv);
		//Getting Pilot's names from the string resource file and creating their TextView List
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
		
		//Creating the Plane List
		TextView tv2 = new TextView(this);
		tv2.setText("Today's Plane List:");
		ll.addView(tv2);
		//Getting Plane names from the string resource file and creating their TextView List
		TextView planeList = new TextView(this);
		plane1 = getResources().getString(R.string.plane1);
		plane2 = getResources().getString(R.string.plane2);
		plane3 = getResources().getString(R.string.plane3);
		plane4 = getResources().getString(R.string.plane4);
		planeList.setText("Plane 1: " + plane1 + "\r\n" +
				  		  "Plane 2: " + plane2 + "\r\n" +
				  		  "Plane 3: " + plane3 + "\r\n" +
				  		  "Plane 4: " + plane4 + "\r\n");
		ll.addView(planeList);
		
		//Building the pilot selection section
		TextView choosePilot = new TextView(this);
		choosePilot.setText("Please Select a Pilot");
		ll.addView(choosePilot);
		
		et = new EditText(this);
		et.setHint("Enter Number of Flights");
		//Building button for pilot 1
		pilot1Button = new ToggleButton(this);
		pilot1Button.setText(pilot1);
		pilot1Button.setTextOn(pilot1);
		pilot1Button.setTextOff(pilot1);
		pilot1Button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				currentPilot = pilot1;
				currentPilotColor(pilot1);
				pilot2Button.setChecked(false);
				pilot3Button.setChecked(false);
				pilot4Button.setChecked(false);
				flying = true;
				
			}
		});
		//Building button for pilot 2
		pilot2Button = new ToggleButton(this);
		pilot2Button.setText(pilot2);
		pilot2Button.setTextOn(pilot2);
		pilot2Button.setTextOff(pilot2);
		pilot2Button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				currentPilot = pilot2;
				currentPilotColor(pilot2);
				pilot1Button.setChecked(false);
				pilot3Button.setChecked(false);
				pilot4Button.setChecked(false);
				flying = true;
			}
		});
		//Building button for pilot 3
		pilot3Button = new ToggleButton(this);
		pilot3Button.setText(pilot3);
		pilot3Button.setTextOn(pilot3);
		pilot3Button.setTextOff(pilot3);
		pilot3Button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				currentPilot = pilot3;
				currentPilotColor(pilot3);
				pilot1Button.setChecked(false);
				pilot2Button.setChecked(false);
				pilot4Button.setChecked(false);
				flying = true;
			}
		});
		//Building button for pilot 4
		pilot4Button = new ToggleButton(this);
		pilot4Button.setText(pilot4);
		pilot4Button.setTextOn(pilot4);
		pilot4Button.setTextOff(pilot4);
		pilot4Button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				currentPilot = pilot4;
				currentPilotColor(pilot4);
				pilot1Button.setChecked(false);
				pilot2Button.setChecked(false);
				pilot3Button.setChecked(false);
				flying = true;
			}
		});
		
		//Building button for starting flight time calculation
		Button b = new Button(this);
		b.setText("Total Flight Time");
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				
				//Pulling plane flight times from integer resource file
				int plane1Time = getResources().getInteger(R.integer.plane1);
				int plane2Time = getResources().getInteger(R.integer.plane2);
				int plane3Time = getResources().getInteger(R.integer.plane3);
				int plane4Time = getResources().getInteger(R.integer.plane4);
				//Gathering info user input into the text field
				int entry = Integer.parseInt(et.getText().toString());
				//Calculating total Flight time per plane 
				int flightsPlane1 = plane1Time*entry;
				int flightsPlane2 = plane2Time*entry;
				int flightsPlane3 = plane3Time*entry;
				int flightsPlane4 = plane4Time*entry;
				//Building the TextView list with the Pilot Name Plane Name and total flight time
				result.setText(currentPilot + " has flown "+ plane1 + " for " + flightsPlane1 + " minutes today." +"\r\n" +
							   currentPilot + " has flown "+ plane2 + " for " + flightsPlane2 + " minutes today." +"\r\n" +
							   currentPilot + " has flown "+ plane3 + " for " + flightsPlane3 + " minutes today." +"\r\n" +
							   currentPilot + " has flown "+ plane4 + " for " + flightsPlane4 + " minutes today." +"\r\n"
						);
				
				//Adding an if statement to check Boolean value to see if we are flying today
				try {
					if(flying == true){
						
						letsFly.setText("Let's Go Flying!!");
					}else {
						letsFly.setText("No Flying Today!!");
					}
				} catch (NotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		//Building new layout for Pilot selection buttons
		LinearLayout pilotButtons = new LinearLayout(this);
		pilotButtons.setOrientation(LinearLayout.HORIZONTAL);
		lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		pilotButtons.setLayoutParams(lp);
		
		pilotButtons.addView(pilot1Button);
		pilotButtons.addView(pilot2Button);
		pilotButtons.addView(pilot3Button);
		pilotButtons.addView(pilot4Button);
		
		//Building new layout for flight time entry form.
		LinearLayout form = new LinearLayout(this);
		form.setOrientation(LinearLayout.HORIZONTAL);
		lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		form.setLayoutParams(lp);
		
		//adding misc. text views to the main view and sub views
		form.addView(et);
		form.addView(b);
		
		ll.addView(pilotButtons);
		
		ll.addView(form);
		
		letsFly = new TextView(this);
		
		
		
		ll.addView(letsFly);
		
		
		result = new TextView(this);
		
		ll.addView(result);
		
		setContentView(ll);
	}

	/**
	 * Current pilot background color.
	 * This checks to see which pilot is selected and changes the background color of the view for each pilot.
	 * @param currentPilot the current pilot
	 */
	public void currentPilotColor(String currentPilot){
		if(currentPilot == pilot1){
			ll.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
			
		} else if(currentPilot == pilot2){
			ll.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
			
		} else if(currentPilot == pilot3){
			ll.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
			
		} else if(currentPilot == pilot4){
			ll.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
			
		}
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
