package tulliolus.process;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Vector;
import java.util.Vector;

import tulliolus.main.Creator;
import tulliolus.main.MainActivity;
import tulliolus.words.Word;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;

public class GrammarCheck {
	Creator creator;
	String TAG = "grammar checking";
    SQLiteDatabase db;
    Processor process;
    String input;
    
    public GrammarCheck(String input) {
    	this.input = input;
    	process = new Processor(input);
        creator = new Creator();
        db = creator.getDatabase();
    }
    
    /**
     * Checks if every word in the input exists in the database. Returns the partially complete output if there are
     * any words in the input that does not exist. <br>
     *  e.g. <br>
     *  <i>if an input does not exist:</i> return: "homibus", "feminaes", et "sice" <br>
     *  <i>if all inputs exist:</i> return: " "
     * 
     * @return String
     **/
    public String exists(){
    	
    	String[] Input = input.split(" ");
    	Vector<String> notExist = new Vector<String>();
    	
    	int index=0;
    	while(index<Input.length)
    	{
    		Vector<Word> word = creator.toWord(Input[index]);
    		
    		if (word.isEmpty()){
    			notExist.add(Input[index]);
    		}
    	
    		index++;
    	}
    	
    	String not = " ";
    	index=0;
    	int maxIndex = notExist.size()-1;
    	while(index<notExist.size()){
   
    	if((index == maxIndex) && (maxIndex!=0))
    		{not += "et "+ "\""+notExist.get(index)+ "\"";}
    	
    	if(maxIndex==0)
		{not += "\""+notExist.get(index)+ "\"";}
    	
    	if((maxIndex == 1))
		{not += "\""+notExist.get(index)+ "\""+" et "+ "\""+notExist.get(index+1)+ "\"";
		index++;}
    	
    	if(!(index == maxIndex) && (maxIndex!=0)&&!(maxIndex==0) && !(maxIndex == 1))
    	{not += "\""+notExist.get(index)+ "\", ";}
    	
    	index++;
    	}
    	
  
    	return not;
    }
    
    /**
     * Searches the database for the input word and returns the index (i.e. int value in the "_id" field).
     * If -1 is returned, this word does not exist in the database.
     * @param inputWord
     * @return int
     */
    public int compare(String inputWord){
		
		int index = -1;
	    try{
	    	Log.d(TAG, "SELECT Instance FROM Word WHERE (Instance = \""+inputWord+"\")");
		Cursor cursor = (creator.getDatabase()).rawQuery("SELECT Instance FROM Word WHERE (Instance = \""+inputWord+"\")", null);
  		cursor.moveToFirst();
  		String compareString = cursor.getString(0);
  		cursor.close();	
  		
  		if (compareString != null){
  			cursor = (creator.getDatabase()).rawQuery("SELECT _id FROM Word WHERE (Instance = \""+inputWord+"\")", null);
	    	cursor.moveToFirst();
	    	index = cursor.getInt(0);}
	    }
	    catch(Exception e){
	    	
	    	Log.d(TAG, e.toString());
	    	
	    	
	    }
	    
		return index;
	}
   
    
    public Processor getProcessor(){
    	return process;
    }
}

    /* prolog = new Prolog();

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
    
    */

/*
    public boolean correct() throws MalformedGoalException{
   
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
                
                
                return result;
            }
    */
    

/*
    
    public String toProlog(String input) throws MalformedGoalException{
    	String prologInput = "s(";
    	process = new VectorProcessor(input, context);
    	Vector parseVector = process.parseVector();
    	//order(parseVector);
    	
    	
    	////DO SOMETHING WITH PARSE VECTOR
    	return prologInput;///change
   
    }
 
    */