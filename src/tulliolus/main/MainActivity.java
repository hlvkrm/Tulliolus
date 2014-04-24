package tulliolus.main;

import java.util.Vector;

import tulliolus.main.R;
import tulliolus.process.GrammarCheck;
import tulliolus.words.Word;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity{
	String TAG = MainActivity.class.getCanonicalName();

    private GrammarCheck check;
    private static MainActivity mainActivity;
    Creator creator;
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
	
	    creator = new Creator(this);
	//	db= create.getDatabase();
        check = new GrammarCheck(this);
		


	}


	public void onClick(View view) {
		
Log.d(TAG, "onclick");

        switch (view.getId()) {
        
        	case R.id.configure: {
        	Log.d(TAG, "configure");
       	 Intent i = new Intent(MainActivity.this, ConfigureActivity.class);
       	 startActivity(i);
       	 
       	 break;
        }
            case R.id.inputButton: {
            	Log.d(TAG, "input");
              
            	
                Log("Input button pressed");
                EditText input = (EditText) findViewById(R.id.input);
                String inputTextRaw = input.getText().toString();
                Log("inputTextRaw: "+inputTextRaw);
                
               TextView dialog = (TextView) findViewById(R.id.dialog);
             String newInput=(String) dialog.getText();
               
                String checkString= check.checkExists(inputTextRaw);
               if (checkString.equals(" "))
               {
            	   int compare = check.compare(inputTextRaw);
                   Log.d(TAG, "compared: "+compare);
 
                  
                   if(compare!=(-1))
                   	{
                   	
                   	Word word = creator.toWord(compare);
                   	newInput+=word.toString()+"\n";}
                 
                   dialog.setText(newInput);
               }
               else{
            	   newInput+="Non intellego"+checkString+".\n";
            	   dialog.setText(newInput);
               }
                
               input.setText("");
                
                
              /*

                try {
                    check.correct(inputTextRaw);
                }
                catch (Exception e) {
                    Log.d(MainActivity.class.getCanonicalName(), "Error occurred onClick of button for input: "+inputTextRaw);
                    e.printStackTrace();
                }*/
                break;
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
