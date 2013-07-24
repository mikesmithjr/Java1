package com.wickedsoftwaredesigns.movielisting;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	RadioGroup movieOptions;
	TextView resultView;
	String[] movieList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout ll = new LinearLayout(this);
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		ll.setLayoutParams(lp);
		ll.setOrientation(LinearLayout.VERTICAL);

		//Creating Array Adapter for spinner view
		Resources res = getResources();
		movieList = res.getStringArray(R.array.movie_array);
		
		//Spinner Adapter
		ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, movieList);
		spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		//Creating Spinner
		Spinner viewSpinner = new Spinner(this);
		viewSpinner.setAdapter(spinnerAdapter);
		lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		viewSpinner.setLayoutParams(lp);
		ll.addView(viewSpinner);
		viewSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
				String spinnerText = movieList[position];
				resultView.setText(JSON.readJSON(spinnerText));
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> arg0){
			
			}
		});
			
		resultView = new TextView(this);
		lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		resultView .setLayoutParams(lp);
		
		
		
		
		ll.addView(resultView);
		setContentView(ll);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
