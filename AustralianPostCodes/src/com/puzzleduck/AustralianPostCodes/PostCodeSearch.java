package com.puzzleduck.AustralianPostCodes;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;



public class PostCodeSearch extends Activity {
    /** Called when the activity is first created. */
	private RegionClickListener aRegionClickListener = new RegionClickListener();
	
	static AutoCompleteTextView regionTextView;
	static AutoCompleteTextView codeTextView;

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
          String query = intent.getStringExtra(SearchManager.QUERY);
//          doMySearch(query);

        
        
        
        regionTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteRegion);
        codeTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteCode);
        regionTextView.setHint(R.string.region_hint);
       // reduce threshhold & color
        ((AutoCompleteTextView) findViewById(R.id.autoCompleteRegion)).setThreshold(1);// zero seems to have no effect
        ((AutoCompleteTextView) findViewById(R.id.autoCompleteCode)).setThreshold(1);// zero seems to have no effect
        ((AutoCompleteTextView) findViewById(R.id.autoCompleteRegion)).setDropDownBackgroundResource(R.drawable.drop_bg);
        ((AutoCompleteTextView) findViewById(R.id.autoCompleteCode)).setDropDownBackgroundResource(R.drawable.drop_bg);
        

        //set listeners
        ((AutoCompleteTextView) findViewById(R.id.autoCompleteRegion)).setOnItemClickListener(aRegionClickListener);
//        ((AutoCompleteTextView) findViewById(R.id.autoCompleteRegion)).setOnItemSelectedListener(this);

//        ((AutoCompleteTextView) findViewById(R.id.autoCompleteCode)).setOnItemClickListener(this);
//        ((AutoCompleteTextView) findViewById(R.id.autoCompleteCode)).setOnItemSelectedListener(this);
        

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<String>(this, R.layout.list_item, getResources().getStringArray(R.array.autocomplete_region)); 
        regionTextView.setAdapter(regionAdapter);

        ArrayAdapter<String> codeAdapter = new ArrayAdapter<String>(this, R.layout.list_item, getResources().getStringArray(R.array.autocomplete_code)); 
        codeTextView.setAdapter(codeAdapter);

        
    }//if
        
    }//onCreate

//	@Override //(AdapterView<?> parent, View view, int position, long id)
//	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//		// TODO Auto-generated method stub
//		AutoCompleteTextView codeTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteCode);
//
//		if(parent.getId() == R.id.autoCompleteRegion) //not working... seperate listeners instead....
//		{
//	//		((AutoCompleteTextView) findViewById(R.id.autoCompleteCode)).setSelection(position);
//	//		codeTextView.setSelection(position);
//			codeTextView.setText("hi");
//		}else
//		{
//
//			codeTextView.setText("bye");
//		}
//	}//onCreate
//
//	@Override//(AdapterView<?> parent, View view, int position, long id)
//	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//		// TODO Auto-generated method stub
//		
//		
//	}
//
//	@Override
//	public void onNothingSelected(AdapterView<?> arg0) {
//		//  Auto-generated method stub... do nothing anyhow
//		
//	}
    
    
    
    
    //reverseResultsText
    
    
    
    
}//class