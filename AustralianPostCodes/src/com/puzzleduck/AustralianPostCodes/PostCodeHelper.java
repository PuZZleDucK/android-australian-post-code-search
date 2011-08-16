package com.puzzleduck.AustralianPostCodes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class PostCodeHelper extends SQLiteOpenHelper{

	private static final String DB_NAME = "ausPostCode.db";
	private static final int DB_VERSION = 1;
	private static final String DB_TABLE = "australianPostCodes";
	private static final String DB_COL_ID   = BaseColumns._ID;
	private static final String DB_COL_NAME = "suburbName";
	private static final String DB_COL_CODE = "suburbCode";
	private static final String DB_COL_STATE = "suburbState";
	
	
	public PostCodeHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION); //null is the factory for cursors... might be useful later
		// not doing anything else
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String queryString = "create table " + DB_TABLE + " ( "
			+ DB_COL_ID + " INT PRIMARY KEY ASC, " //SUPPLY null to use ascending key :)
			+ DB_COL_NAME + " TEXT FOREIGN KEY, "
			+ DB_COL_CODE + " TEXT FOREIGN KEY, "
			+ DB_COL_STATE + " TEXT );";
		Log.d("PZD_TAG:: "," SQL created: " + queryString);
		
		db.execSQL(queryString);
		Log.d("PZD_TAG:: "," SQL executed");
		
		//TODO: populate DB... from xml? txt?
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.d("PZD_TAG:: "," Post Code Helper ... UPGRADE!");
		if(oldVersion < newVersion)
		{
			switch(oldVersion)
			{
			case(1):
				// TODO: no updates... no changes yet
				break;
			default:
				// hopefully no one ever gets here
				break;
					
			}
			
		}
		
	}

}





























