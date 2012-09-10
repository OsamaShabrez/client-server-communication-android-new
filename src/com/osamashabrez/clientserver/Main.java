package com.osamashabrez.clientserver;

import android.os.Bundle;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ArrayAdapter;

public class Main extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* 
         * requesting for indeterminate progress
         * icon as we have to call our asyc task
         * to perform queries on network. This
         * will let the user know app is
         * still processing in background
         */
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
    	String[] listitems = {"Game 1", "Game 2", "Game 3"};
    	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_view, listitems);
    	this.setListAdapter(adapter);
    }

    public void onWindowFocusChanged(boolean hasFocus) {
    	super.onWindowFocusChanged(hasFocus);
    	// activating the progress bar
    	setProgressBarIndeterminateVisibility(true);
    }

    /* 
     * Lets add some gold plating to our application
     * Will add an option menu with about and exit
     * menu items
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity, menu);
        return true;
    }

    /*
     * Driver for the option menu created above
     */
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
