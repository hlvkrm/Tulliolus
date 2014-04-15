package ciceronulus.main;

import java.util.Vector;

import ciceronulus.process.GrammarCheck;
import ciceronulus.words.Word;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	String TAG = MainActivity.class.getCanonicalName();

    private GrammarCheck check;
    private static MainActivity mainActivity;
    Creator create;
    SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        mainActivity = this;

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
			.add(R.id.container, new PlaceholderFragment()).commit();
		}
	//	db= create.getDatabase();
        check = new GrammarCheck(this);
		
        create = new Creator(getBaseContext());
        //create.createNouns();
	}


	public void onClick(View view) {

        switch (view.getId()) {

            case R.id.inputButton: {

                String newInput="";
            	
                Log("Input button pressed");
                EditText input = (EditText) findViewById(R.id.input);
                String inputTextRaw = input.getText().toString();
                Log("inputTextRaw: "+inputTextRaw);
                
                TextView dialog = (TextView) findViewById(R.id.dialog);
                int compare = check.compare(inputTextRaw);
                Log.d(TAG, "compared: "+compare);
                
                newInput+= (String) dialog.getText();
                
                Vector wordList = create.getAllWords();
                if(compare!=(-1))
                	{newInput+="\n"+((Word)wordList.get(compare)).toString();}
              
                dialog.setText(newInput);
                
              /*

                try {
                    check.correct(inputTextRaw);
                }
                catch (Exception e) {
                    Log.d(MainActivity.class.getCanonicalName(), "Error occurred onClick of button for input: "+inputTextRaw);
                    e.printStackTrace();
                }
                break;*/
            }
        }
	}

    public static void displayResult(String result) {
        mainActivity.showResultOnScreen(result);
    }

    private void showResultOnScreen(final String dialog) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView dialog = (TextView) findViewById(R.id.dialog);
                EditText input = (EditText) findViewById(R.id.input);
                dialog.setText((CharSequence) dialog);
                input.setText(null);
            }
        });
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
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,	false);
			return rootView;
		}
	}


    private void Log(String message){
        Log.d(MainActivity.class.getCanonicalName(),message);
    }
    
    
}
