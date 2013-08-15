package com.aperezhrd.gcdexpress;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InputNumbers extends Activity {
	public static final String EXTRA_FIRST_NUMBER  = "com.aperezhrd.gcdexpress.FIRST_NUMBER";
	public static final String EXTRA_SECOND_NUMBER = "com.aperezhrd.gcdexpress.SECOND_NUMBER";
	EditText etFirstNumber;
	EditText etSecondNumber;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_numbers);
        etFirstNumber  = (EditText) findViewById(R.id.etFirstNumber);
        etSecondNumber = (EditText) findViewById(R.id.etSecondNumber);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_input_numbers, menu);
        return true;
    }
    
    public int calculate(View v) {
    	int a = Integer.parseInt(etFirstNumber.getText().toString());
    	int b = Integer.parseInt(etSecondNumber.getText().toString());
    	
		Intent i = new Intent(this, EuclidesGCD.class);
		i.putExtra(EXTRA_FIRST_NUMBER,  a);
		i.putExtra(EXTRA_SECOND_NUMBER, b);
    	startActivity(i);
		return 0;
    }
    
}