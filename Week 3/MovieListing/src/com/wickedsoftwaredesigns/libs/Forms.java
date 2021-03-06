/*
 * project     MovieListing
 * 
 * package		com.wickedsoftwaredesigns.libs
 * 
 * @author     Michael R. Smith Jr
 * 
 * date			Jul 25, 2013
 */
package com.wickedsoftwaredesigns.libs;

import android.content.Context;

import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;

// TODO: Auto-generated Javadoc
/**
 * The Class Forms.
 */
public class Forms {

	/**
	 * Single entry with button.
	 *
	 * @param context the context
	 * @param hint the hint
	 * @param buttonText the button text
	 * @return the linear layout
	 */
	public static LinearLayout singleEntryWithButton(Context context, String hint, String buttonText){
		LinearLayout ll = new LinearLayout(context);
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		ll.setLayoutParams(lp);
		
		EditText et = new EditText(context);
		lp = new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);
		et.setHint(hint);
		et.setLayoutParams(lp);
		et.setId(1);
		
		Button b = new Button(context);
		b.setText(buttonText);
		b.setId(2);
		b.setTag(et);
		
		ll.addView(et);
		ll.addView(b);
		
		return ll;
	}
	
	/**
	 * Gets the options.
	 *
	 * @param context the context
	 * @param options the options
	 * @return the options
	 */
	public static RadioGroup getOptions(Context context, String[] options){
		
		RadioGroup boxes = new RadioGroup(context);
		for(int i=0; i<options.length; i++){
			RadioButton rb = new RadioButton(context);
			rb.setText(options[i]);
			boxes.addView(boxes);
		}
		
		
		
		return boxes;
		
		
	}
	
	
}
