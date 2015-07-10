package com.example.mypizzapie;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.database.Cursor;

public class MainActivity extends Activity  
{
	Button vegbtn, cheesebtn,pepperonibtn, gardenbtn, dbsavebtn, newpage,costbtn;
	TextView nametv, phonetv;
	EditText nameet, phoneet, qet, tet, vet, pet, cet,get;
	
	int myeditnum,myeditnum1, myeditnum2, myeditnum3, sums=0, costtotal;
	DataHandler handler;
   
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        vegbtn = (Button) findViewById(R.id.vegbtn);
        cheesebtn =  (Button) findViewById(R.id.cheesebtn);
        pepperonibtn = (Button) findViewById(R.id.pepronibtn);
        gardenbtn = (Button) findViewById(R.id.imageView2);
        dbsavebtn = (Button) findViewById(R.id.dbbtn);
        costbtn = (Button) findViewById(R.id.costbtn);
        newpage =  (Button) findViewById(R.id.nextbtn);
        
        nameet = (EditText) findViewById(R.id.editText1);
        phoneet = (EditText) findViewById(R.id.editText2);
        
        qet = (EditText) findViewById(R.id.editText3);
        tet = (EditText) findViewById(R.id.editText4);
        
        vet = (EditText) findViewById(R.id.count1);
        cet = (EditText) findViewById(R.id.count2);
        pet = (EditText) findViewById(R.id.count3);
        get = (EditText) findViewById(R.id.count4);
        
        vegbtn.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v) 
			{
				
		String myEdit = vet.getText().toString();
		myeditnum = Integer.parseInt(myEdit);
 		Toast.makeText(MainActivity.this, "You clicked Veggi : " +
		"Qty " + myeditnum,  Toast.LENGTH_LONG).show();
	 		}
		});
        
        
        cheesebtn.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v) 
			{
				
		String myEdit = cet.getText().toString();
		myeditnum1 = Integer.parseInt(myEdit);
 		Toast.makeText(MainActivity.this, "You clicked Cheese : " +
		"Qty " + myeditnum1,  Toast.LENGTH_LONG).show();
	 		}
		});

        pepperonibtn.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v) 
			{
				
		String myEdit = pet.getText().toString();
		myeditnum2 = Integer.parseInt(myEdit);
 		Toast.makeText(MainActivity.this, "You clicked Pepperoni : " +
		"Qty " + myeditnum2,  Toast.LENGTH_LONG).show();
	 		}
		});

        gardenbtn.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v) 
			{
				
		String myEdit = get.getText().toString();
		myeditnum3 = Integer.parseInt(myEdit);
 		Toast.makeText(MainActivity.this, "You clicked gardenfresh : " +
		"Qty " + myeditnum3,  Toast.LENGTH_LONG).show();
	 		}
		});
    
    
    costbtn.setOnClickListener(new View.OnClickListener() {
 		public void onClick(View v) {
 			sums = myeditnum + myeditnum1 + myeditnum2 + myeditnum3;
 		  	costtotal = (myeditnum *5 + myeditnum1 *6+ myeditnum2 *7 + myeditnum3*8);
 			qet.setText(String.valueOf(sums));
 			tet.setText(String.valueOf(costtotal)); 					
 		}
	});
    
    dbsavebtn.setOnClickListener(new OnClickListener() 
	{
	public void onClick(View v) 
	{
	String getName = nameet.getText().toString();
	String getphno = phoneet.getText().toString();
	String getqty = qet.getText().toString();
	String gettotal = tet.getText().toString();
	
	handler = new DataHandler(getBaseContext());
	handler.open();
	long id = handler.insertData(getName, getphno,getqty, gettotal);
	Toast.makeText(getBaseContext(), "Data inserted", Toast.LENGTH_LONG).show();
	handler.close();  	
   }
 });
newpage.setOnClickListener(new View.OnClickListener() {
		
 		public void onClick(View v) 
 		{
// 			Toast.makeText(MainActivity.this, "You clicked this button : ",  Toast.LENGTH_LONG).show();
 			Intent intent = new Intent(MainActivity.this, Paymentpage.class);
		 	startActivity(intent);
		}
	});	

    }
}
//	@Override
//	public void onClick(View v) {
//		// TODO Auto-generated method stub
//		
//	}
  
//    @Override
 //   public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
   //     getMenuInflater().inflate(R.menu.main, menu);
     //   return true;
   // }
    
//    }  
//}
