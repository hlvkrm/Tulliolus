package ciceronulus.main;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
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

	private static final String DATABASEname = "paradigm.db";
    private DatabaseHelper database;
    private GrammarChecker grammarChecker;
    private static MainActivity mainActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        mainActivity = this;

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
			.add(R.id.container, new PlaceholderFragment()).commit();
		}

        grammarChecker = new GrammarChecker(this);
		database = new DatabaseHelper(getBaseContext(), DATABASEname);
	}

	public void onClick(View view) {

        switch (view.getId()) {

            case R.id.inputButton: {
                Log("Input button pressed");
                EditText input = (EditText) findViewById(R.id.input);
                String inputTextRaw = input.getText().toString();
                Log("inputTextRaw: "+inputTextRaw);

                try {
                    grammarChecker.correct(inputTextRaw);
                }
                catch (Exception e) {
                    Log.d(MainActivity.class.getCanonicalName(), "Error occurred onClick of button for input: "+inputTextRaw);
                    e.printStackTrace();
                }
                break;
            }
        }
	}

    public static void displayQueryResult(String queryResult) {
        mainActivity.showResultOnScreen(queryResult);
    }

    private void showResultOnScreen(final String queryResult) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView dialog = (TextView) findViewById(R.id.queryResult);
                EditText input = (EditText) findViewById(R.id.input);
                dialog.setText(queryResult);
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
