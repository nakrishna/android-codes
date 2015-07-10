package com.example.mypizzapie;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Paymentpage extends Activity
{
	Button paybtn;
	protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_page);
    
	paybtn = (Button)findViewById (R.id.paybtn);
	paybtn.setOnClickListener(new View.OnClickListener() {
		
	 	public void onClick(View v) 
	 	{
	 		Toast.makeText(Paymentpage.this, "You Payment Approved ",  Toast.LENGTH_LONG).show();
	 		Toast.makeText(Paymentpage.this, " Thank you!!! ",  Toast.LENGTH_LONG).show();
		}
	});
    }
}
