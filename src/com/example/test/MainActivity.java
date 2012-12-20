package com.example.test;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ArrayList <HashMap<String, Object>> arrayList;
    private static final String TITLE = "titleNews";
    private static final String IMAGE = "imageLink";
    private static final String CATEGORY = "categoryNews";
    private static final String TEXT = "textNews";
    private static final String DATE = "dateNews";
    
    private ListView lv = null;
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView)findViewById(R.id.newsList);
		lv.setTextFilterEnabled(true);
		lv.setOnItemClickListener( new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				//Toast.makeText(getApplicationContext(),(String) parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
				System.out.println(parent.getItemAtPosition(position).toString());
				Toast.makeText(view.getContext(),parent.getItemAtPosition(position).toString()+" " + ((HashMap<String, Object>)parent.getItemAtPosition(position)).get(DATE), Toast.LENGTH_SHORT).show();
				Intent i = new Intent(getApplicationContext(), SelectedActivity.class);
				startActivity(i);
				
			}
			
		});
		addList();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	
	private void addList(){
		
		arrayList = new ArrayList<HashMap<String,Object>>();
		HashMap<String, Object> hm;
		
		 for(int i=1; i<10;i++){
			 hm = new HashMap<String, Object>();
			 hm.put(IMAGE, R.drawable.ic_action_name);
			 hm.put(TITLE, "новсть"+i);
			 hm.put(TEXT, "текст текст"+i);
			 hm.put(CATEGORY, "категория1");
			 hm.put(DATE, "1"+i+".12.12");
			 
			 arrayList.add(hm);
		 }
		 SimpleAdapter adapter =
				 new SimpleAdapter(this, arrayList,R.layout.item_list ,
						 new String[]{TITLE,IMAGE},
						 new int[]{R.id.titleNews,R.id.imageLink});
		 
		 lv.setAdapter(adapter);
		
	}
}
