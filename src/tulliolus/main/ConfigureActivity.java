package tulliolus.main;

import java.util.Vector;

import tulliolus.main.R;
import tulliolus.process.GrammarCheck;
import tulliolus.words.Word;
import android.app.*;
import android.content.Intent;
import android.os.*;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConfigureActivity extends Activity{

	String TAG = "configuring";
	Creator creator;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_configure);
        creator = new Creator(this);
    }
     

 	public void onClick(View view) {

         switch (view.getId()) {
         		
             case R.id.create: {
            	 
            	 final View tempView = view;
            	 new Thread(new Runnable() {
					
					@Override
					public void run() {
						Button updatebutton = (Button) tempView.findViewById(R.id.update);
						updatebutton.setEnabled(false);
						creator.createAllWords();
						updatebutton.setEnabled(true);
					}
				}).start();
            	 
                break;
             }
             
             case R.id.update: {

                 creator.updateDatabase();
                 break;
             }
            
         }
 	}
 	

}