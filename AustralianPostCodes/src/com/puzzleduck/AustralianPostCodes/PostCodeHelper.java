package com.puzzleduck.AustralianPostCodes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

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
			+ DB_COL_ID + " INT, "
			+ DB_COL_NAME + " TEXT, "
			+ DB_COL_CODE + " TEXT, "
			+ DB_COL_STATE + " TEXT );";
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}





























