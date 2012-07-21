package com.osamashabrez.clientserver;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.text.Html;
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
    		case R.id.menu_about:
        		Log.d("Application about", "view dialouge about me");
                Dialog dialog;
            	AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(R.string.dialog_action_title)
                	.setMessage(Html.fromHtml("This tutorial on Android Client Server was written for <a href=\"http://osamashabrez.com\">OsamaShabrez.com</a>"))
                	.setCancelable(false)
                	.setIcon(android.R.drawable.ic_dialog_info)
                	.setPositiveButton(R.string.dialog_action_dismiss, null);
                dialog = builder.create();
                dialog.show();
    			break;
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
