package ciceronulus.main;



import java.io.FileOutputStream;
import java.io.IOException;




import android.R.id;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
String TAG = "main activity";

private static final String DATABASEname = "paradigm.db";
//private static final String DATABASE_PATH = "/data/data/" + "Ciceronulus" + "/databases/";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		
		Helper help = new Helper(getBaseContext(), DATABASEname);
		Log.d(TAG, "new Helper()"); 
	
		
		 try  
	      { 
	        //Copy the database from assets 
	        help.openDatabase(getBaseContext(), DATABASEname); 
	        Log.d(TAG, "createDatabase database created"); 
	      }  
	      catch (IOException mIOException)  
	      { 
	         throw new Error("ErrorCopyingDatabase"); 
	     } 
		
		
	// SQLiteDatabase db = help.getWritableDatabase();
	 //SQLiteDatabase db = SQLiteDatabase.openDatabase(help.getDBpath()+DATABASEname, null, 0);
		// help.checkDatabase(DATABASE_PATH, DATABASEname)
		// help.onCreate(db);
		// Log.d(TAG,db.getPath());
		
		
	}

	
	public void onClick(View view) {
		Log.d(TAG, "c:");
		EditText input = (EditText) findViewById(R.id.input);
		String inputText = input.getText().toString();
		Log.d(TAG, inputText);

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
