package com.example.mypizzapie;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHandler {
	public static final String NAME = "name";
 	public static final String MOBILE = "phno";
 	public static final String QTY = "totalqty";
 	public static final String AMOUNT = "dollars";
 			
	public static final String TABLE_NAME = "empty";
	public static final String DATA_BASE_NAME = "emptydb";
	public static final int DATABASE_VERSION = 3; 
	
	public static final String TABLE_CREATE = 
			"create table empty (name text not null, phno text not null, " +
			"totalqty text not null, dollars text not null); ";
	
	DataBaseHelper dbhelper;
 	Context ctx;
	SQLiteDatabase db;
	public DataHandler(Context ctx)
	{
		this.ctx = ctx;
		dbhelper = new DataBaseHelper(ctx);
	}
		
	private static class DataBaseHelper extends SQLiteOpenHelper 
	{
		public DataBaseHelper(Context ctx)
		{
			super(ctx, DATA_BASE_NAME,null,DATABASE_VERSION);
		}
		public void onCreate(SQLiteDatabase db)
		 {
			 try
			 {
			 db.execSQL(TABLE_CREATE);
			 }
			 catch(SQLException e)
			 {
				e.printStackTrace();
			 }
		 }
		
		 public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
		 	{
			 db.execSQL("DROP TABLE IF EXISTS empty");
			 onCreate(db);
		 	}
	}
	
	public DataHandler open()
	{
	db = dbhelper.getWritableDatabase();
	return this;
	}
//CLOSE THE DATABASE 
public void close()			
	{
	dbhelper.close();
	}
//INSERT THE DATA INTO TABLE
 
public long insertData(String name, String phono, String total,  String amount)
	{
		ContentValues content = new ContentValues();
		content.put(NAME, name);
		content.put(MOBILE, phono);
		content.put(QTY, total);
		content.put(AMOUNT, amount);
		return db.insertOrThrow(TABLE_NAME, null, content);
}

//RETRIVE THE DATA FROM DATABASE WE ARE USING A CURSOR METHOD
public Cursor returnData()
	{
		return db.query(TABLE_NAME, new String[] {NAME, MOBILE, QTY, AMOUNT},null, null, null, null, null);
	}
  
}
