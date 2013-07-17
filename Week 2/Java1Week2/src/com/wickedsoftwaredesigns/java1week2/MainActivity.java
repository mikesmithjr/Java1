package com.wickedsoftwaredesigns.java1week2;

import java.util.ArrayList;
import java.util.HashMap;

import com.wickedsoftwaredesigns.ecom.Money;
import com.wickedsoftwaredesigns.ecom.Phone;
import com.wickedsoftwaredesigns.ecom.Product;
import com.wickedsoftwaredesigns.libs.Forms;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

	RadioGroup productOptions;
	ArrayList<Product> products;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LinearLayout ll = new LinearLayout(this);
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		ll.setLayoutParams(lp);
		ll.setOrientation(LinearLayout.VERTICAL);
		
		LinearLayout entryBox = Forms.oneEntryWithButton(this, "Type Something", "Go");
		
		Button moneyButton = (Button) entryBox.findViewById(2);
		
		moneyButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				int selectedRadioId = productOptions.getCheckedRadioButtonId();
				RadioButton selectedRadio = (RadioButton) productOptions.findViewById(selectedRadioId);
				String radioText = (String) selectedRadio.getText();
				double price = 0;
				for (int i = 0; i < products.size(); i++) {
					if (radioText.compareTo(products.get(i).getName()) == 0) {
						price = products.get(i).getPrice();
					}
				}
				
				EditText moneyText = (EditText) v.getTag();
				double money = Double.parseDouble(moneyText.getText().toString());
				
				double refund = money - price;
				
				HashMap<Money, Integer> change = Money.getChange(refund);
				
				Log.i("Button Clicked:",
						"Dollar: " + change.get(Money.DOLLAR) + "\r\n" +
						"Quarter: " + change.get(Money.QUARTER) + "\r\n" +
						"Dine: " + change.get(Money.DIME) + "\r\n" +
						"Nickel: " + change.get(Money.NICKEL) + "\r\n" +
						"Penny: " + change.get(Money.PENNY)
						);
			}
		});
		
		products = new ArrayList<Product>();
		products.add(new Phone("Nexus 4", 299.99));
		products.add(new Phone("Nexus 7", 349.99));
		products.add(new Phone("Nexus 10", 499.99));
		products.add(new Phone("iPhone 4", 99.99));
		products.add(new Phone("iPhone 4S", 199.99));
		products.add(new Phone("iPhone 5", 299.99));
		
		String[] productNames = new String[products.size()];
		for (int i = 0; i < products.size(); i++) {
			productNames[i] = products.get(i).getName();
		}
		
		productOptions = Forms.getOptions(this, productNames);
		
		ll.addView(productOptions);
		
		ll.addView(entryBox);
		
		setContentView(ll);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}