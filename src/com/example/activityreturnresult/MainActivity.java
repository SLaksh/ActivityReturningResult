package com.example.activityreturnresult;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener 
{
	Button btnGetResult;
    EditText etX, etY;
    TextView tvResult;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        btnGetResult = (Button) findViewById(R.id.btnGetResult);
        etX = (EditText) findViewById(R.id.etX);
        etY = (EditText) findViewById(R.id.etY);
        tvResult = (TextView)findViewById(R.id.tvResult); 
        btnGetResult.setOnClickListener(this);
    }
     @Override
    public void onClick(View view) 
    {
 
        // 1. create an intent pass class name or intent action name 
        Intent intent = new Intent(this,AnotherActivity.class);
 
        // 2. put X, Y in intent
        intent.putExtra("x",  etX.getText().toString());
        intent.putExtra("y",  etY.getText().toString());
 
        // 3. start the activity for result with a request code =1
        //By calling startActivityForResult with Activity2, your current activity will be
        //notified when the Activity2 is finished (back button pressed), 
        //and this way you can also get information from it. 
        
        startActivityForResult(intent, 1);
    }
    	//callback method to get the result from the other activity
    @Override
    protected void onActivityResult(int requestCode, 
    		int resultCode, Intent data) 
    {
 
             if(resultCode == RESULT_OK)
             {      
               tvResult.setText(data.getIntExtra("result",-1)+"");          
             }
 
    }
 
}
	


