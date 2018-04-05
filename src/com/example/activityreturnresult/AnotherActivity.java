package com.example.activityreturnresult;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AnotherActivity extends Activity implements OnClickListener 
{
	 	TextView tvSum;
	    Button btnSendResult;
	    int result;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);	  
	 
	     btnSendResult = (Button) findViewById(R.id.btnSendResult);
	     btnSendResult.setOnClickListener(this);
	 
	        // 1. get passed intent 
	        Intent intent = getIntent();
	 
	        // 2. get x & y from intent
	        int x = Integer.parseInt(intent.getStringExtra("x"));
	        int y = Integer.parseInt(intent.getStringExtra("y"));
	        result = x + y;
	 
	        // 3. get reference to tvSum 
	        tvSum = (TextView)findViewById(R.id.tvSum);
	 
	        // 4. display x+y on textView 
	        tvSum.setText(x+" + "+y+" = "+result);
	 	    }	   

	@Override
	public void onClick(View view) 
	{
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",result);
        setResult(RESULT_OK,returnIntent);     
        finish();		
	}	
}
