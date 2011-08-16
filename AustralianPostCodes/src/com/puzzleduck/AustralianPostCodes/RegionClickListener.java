package com.puzzleduck.AustralianPostCodes;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class RegionClickListener extends Activity implements OnItemClickListener {

//	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//		String temp = getResources().getStringArray(R.array.autocomplete_code)[position];//crash
//		String temps[] = getResources().getStringArray(R.array.autocomplete_code);//crash	
//		PostCodeSearch.codeTextView.setText("...");
//		PostCodeSearch.codeTextView.setListSelection(position);
//		PostCodeSearch.codeTextView.refreshDrawableState();
		
//		Resources res = getResources();
//		String[] codes = res.getStringArray(R.array.autocomplete_code);
		PostCodeSearch.codeTextView.setText("..." );
		//+ codes[position]
		
//		AutoCompleteTextView codeTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteCode);
		
		
//				if(parent.getId() == R.id.autoCompleteRegion) //not working... seperate listeners instead....
//				{
			//		((AutoCompleteTextView) findViewById(R.id.autoCompleteCode)).setSelection(position);
			//		codeTextView.setSelection(position);
//				}else
//				{
		
//					codeTextView.setText("bye");
//				}
	}

}
