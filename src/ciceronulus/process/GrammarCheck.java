package ciceronulus.process;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Vector;
import java.util.Vector;

import ciceronulus.main.Creator;
import ciceronulus.main.MainActivity;
import ciceronulus.words.Word;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;

public class GrammarCheck {

    private static Prolog prolog;
    private static Context context;
    Vector ALLWORDS;
    Creator creator;


    public GrammarCheck(Context context) {
        this.context = context;

        prolog = new Prolog();

        AssetManager assManager = context.getAssets();
        try {
            Log("Reading grammar00.pl from Assets");
            InputStream is0 = assManager.open("grammar00.pl");

            Log("Loading grammar to Prolog");
            Theory grammar = new Theory(new BufferedInputStream(is0));
            prolog.setTheory(grammar);
        } catch (Exception e) {
            Log("Error reading grammar00.pl from Assets");
            e.printStackTrace();
        }
        Log("Prolog ready");
        
        creator = new Creator();
        ALLWORDS = creator.getAllWords();
    }

    public Vector<String> checkExists(String input){
    	String[] PA = input.split(" ");
    	Vector<String> notExists = new Vector<String>();
    	notExists.add("BLANK");
    	
    	Vector<String> exists = new Vector<String>();
    	
		int index=0;
		int compare = -2;
		while (index<PA.length)
		{
			compare = compare(PA[index]);
			if (compare>-1){
				exists.add(PA[compare]);
			}
			else{
				notExists.add(PA[compare]);
			}
		}
    	
    	if (notExists.size()==1){
    
    		return exists;
    	}
    	else{
    		return notExists;
    	}
    }
    
    public int compare(String w){
		boolean same=false;
		
		int index = -1;
		int count = 0;
	    while (count<ALLWORDS.size() && same==false){
	    	
	    Word compareWord = (Word) ALLWORDS.get(count);
	    Log(compareWord.toString());
	    
	    String compareString = compareWord.getInstance();
	    Log(compareString+"//"+w);
	    
	    if (compareString.equals(w)){
	    	 Log("TRUE");
	    	index = count;
	    	same = true;
	    }
	    
	    count++;
	    }
	    
		return index;
	}


    public void correct(final String input) throws MalformedGoalException{

        new Thread(new Runnable() {
            @Override
            public void run() {
            	
            	Vector check = checkExists(input);
            	if(check.get(0).equals("BLANK")){
            		
            	}
            	
            	
                boolean result = false;
                try {
                    SolveInfo answer = prolog.solve(input);
                    result = answer.isSuccess();

                } catch (Exception e) {
                    Log("Error occurred during Prolog stuff. Check log");
                    e.printStackTrace();
                    MainActivity.displayResult(result+ "Exception occurred during Prolog stuff. Check log for error trace.");
                }
                MainActivity.displayResult(result+ "");
            }
        }).start();
    }
    
    private void Log(String message) {
        Log.d(GrammarCheck.class.getCanonicalName(), message);
    }
}
