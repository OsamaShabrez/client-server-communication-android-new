package com.osamashabrez.clientserver;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class Main extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	try {
    		switch (item.getItemId()) {
    		case R.id.menu_exit:
        		Log.d("Application exit", "exit selected from menu");
        		System.exit(0);
    			break;
    		default:
        		return super.onOptionsItemSelected(item);
    		}
    	} catch (Exception ex) {
    		Log.d("Menu item error", ex.getMessage());
    	}
		return true;
    }
}
