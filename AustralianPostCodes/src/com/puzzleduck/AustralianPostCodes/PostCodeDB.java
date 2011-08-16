package com.puzzleduck.AustralianPostCodes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

//import com.example.android.searchabledict.R;   // not sure why this was here


import android.app.SearchManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;

public class PostCodeDB {
    private static final String TAG = "PostCodeDB";


    //The columns we'll include in the dictionary table
    public static final String KEY_REGION = SearchManager.SUGGEST_COLUMN_TEXT_1;
    public static final String KEY_CODE = SearchManager.SUGGEST_COLUMN_TEXT_2;

    private static final String DATABASE_NAME = "australianpostcodes";
    private static final String FTS_VIRTUAL_TABLE = "FTSaustralianpostcodes";
    private static final int DATABASE_VERSION = 1;

//    private final PostCodeOpenHelper mDatabaseOpenHelper;
//    private static final HashMap<String,String> mColumnMap = buildColumnMap();

    
    
    private static class PostCodeOpenHelper extends SQLiteOpenHelper {

        private final Context mHelperContext;
        private SQLiteDatabase mDatabase;
    	
        private static final String FTS_TABLE_CREATE =
            "CREATE VIRTUAL TABLE " + FTS_VIRTUAL_TABLE +
            " USING fts3 (" +
            KEY_REGION + ", " +
            KEY_CODE + ");";
        
        
    	
	public PostCodeOpenHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mHelperContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
        mDatabase = db;
        mDatabase.execSQL(FTS_TABLE_CREATE);
        loadDictionary();
		
        
        
	}

    /**
     * Starts a thread to load the database table with words
     */
    private void loadDictionary() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    loadWords();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
    
    

    private void loadWords() throws IOException {
        Log.d(TAG, "Loading words...");
        final Resources resources = mHelperContext.getResources();
        InputStream inputStream = resources.openRawResource(R.raw.auspostcodes);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] strings = TextUtils.split(line, "_");/// change incompatible split from - to _
                if (strings.length < 2) continue;
                long id = addLocation(strings[0].trim(), strings[1].trim());
                if (id < 0) {
                    Log.e(TAG, "unable to add word: " + strings[0].trim());
                }
            }
        } finally {
            reader.close();
        }
        Log.d(TAG, "DONE loading words.");
    }


    /**
     * Add a word to the dictionary.
     * @return rowId or -1 if failed
     */
    public long addLocation(String word, String definition) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_REGION, word);
        initialValues.put(KEY_CODE, definition);

        return mDatabase.insert(FTS_VIRTUAL_TABLE, null, initialValues);
    }
    
    
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
    	
    }

    
    
    
}
