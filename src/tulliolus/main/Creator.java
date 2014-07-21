package tulliolus.main;

import java.util.Vector;

import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.SolveInfo;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.sql.SQLException;

import tulliolus.words.Word;
import tulliolus.words.generate.IrregularNoun;
import tulliolus.words.generate.IrregularVerb;
import tulliolus.words.generate.Pronoun;

public class Creator {
	
	
	private static final String DATABASEname = "paradigm.db";
    private Helper help;
    public static SQLiteDatabase db;
	Context c;
    static Vector<Word> allNouns;
	static Vector<Word> allVerbs;
	static Vector<Word> allPronouns;
	static Vector<Word> allAdverbs;
	static Vector<Word> allAdjectives;
	static Vector<Word> allNumerals;
	static Vector<Word> ALLWORDS;

	IrregularVerb iv = new IrregularVerb(); IrregularNoun in = new IrregularNoun(); Pronoun p = new Pronoun();
	String TAG = "creating";
	
	public Creator() {
		
		help = new Helper(this.c, DATABASEname);
		db = help.getWritableDatabase();
		
		allNouns = new Vector();
		allVerbs = new Vector();
		allPronouns = new Vector();
		allAdverbs = new Vector();
		allVerbs = new Vector();
		ALLWORDS = new Vector();
	
	}
	

	public int getWordCount(){
	  
			Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM Word", null);
			cursor.moveToFirst();
			int count = cursor.getInt(0);
			cursor.close();
	
			return count;
	    }
	 /**
	   * Creates a Word object from an index int value. Returns the Word objectification of the instance associated with
	   * the input index in the database (table Word from paradigm.db).<br>
	   * Differs from similar method toWord(String instance) in that, because a specific 
	   * entry in the database is specified, one specific Word object can be returned.
	   * @param dbIndex
	   * @return int
	   */
	  public Word toWord(int dbIndex){
		  Word word;
		  
			Cursor cursor = db.rawQuery("SELECT Instance FROM Word WHERE (_id = "+dbIndex+") ", null);
			cursor.moveToFirst();
			String instance = cursor.getString(0);
			cursor.close();

			cursor = db.rawQuery("SELECT Category FROM Word WHERE (_id = "+dbIndex+") ", null);
			cursor.moveToFirst();
			String category = cursor.getString(0);
			cursor.close();
			
			cursor = db.rawQuery("SELECT Definition FROM Word WHERE (_id = "+dbIndex+") ", null);
			cursor.moveToFirst();
			String definition = cursor.getString(0);
			cursor.close();
			
			cursor = db.rawQuery("SELECT Note FROM Word WHERE (_id = "+dbIndex+") ", null);
			cursor.moveToFirst();
			String note = cursor.getString(0);
			cursor.close();
			
			cursor = db.rawQuery("SELECT Parse FROM Word WHERE (_id = "+dbIndex+") ", null);
			cursor.moveToFirst();
			String parse = cursor.getString(0);
			cursor.close();
			
			word = new Word (instance, category, definition, note, parse);
			
		  return word;
	  }
	  
	  /**
	   * Creates a Word object from an instance String. Returns a vector of all the words that matched the input instance in the database
	   * (table Word from paradigm.db).<br>
	   * Differs from toWord(int dbIndex) in that only the Instance field of the table is specified; so, multiple entries with the same
	   * Instance field are accounted for.
	   * @param instance
	   * @return Vector
	   */
	  public Vector<Word> toWord(String instance){
		  
		  Vector<Word> Instances = new Vector<Word>();
		  Word word;
		  
			Cursor cursor = db.rawQuery("SELECT _id FROM Word WHERE (Instance = \""+instance+"\") ", null);
			
			while(cursor.moveToNext()){
			int id = cursor.getInt(0);
			cursor.close();

			cursor = db.rawQuery("SELECT Category FROM Word WHERE (_id = "+id+") ", null);
			cursor.moveToFirst();
			String category = cursor.getString(0);
			cursor.close();
			
			cursor = db.rawQuery("SELECT Definition FROM Word WHERE (_id = "+id+") ", null);
			cursor.moveToFirst();
			String definition = cursor.getString(0);
			cursor.close();
			
			cursor = db.rawQuery("SELECT Note FROM Word WHERE (_id = "+id+") ", null);
			cursor.moveToFirst();
			String note = cursor.getString(0);
			cursor.close();
			
			cursor = db.rawQuery("SELECT Parse FROM Word WHERE (_id = "+id+") ", null);
			cursor.moveToFirst();
			String parse = cursor.getString(0);
			cursor.close();
			
			word = new Word (instance, category, definition, note, parse);
			Instances.add(word);
			}
			
			
		  return Instances;
	  }
	
	public void createAllWords(){
	
		createNouns();
		createVerbs();
		
		ALLWORDS.addAll(allNouns);
		ALLWORDS.addAll(in.getIrregularNouns());
		ALLWORDS.addAll(p.getPronouns());
		ALLWORDS.addAll(allVerbs);
		ALLWORDS.addAll(iv.getIrregularVerbs());

		insertWordstoDB();

	}
	
	public Vector getAllWords(){

		return ALLWORDS;
	}
	
	public String allWordsString(){
		String all="";
		
		int c = 0;
		while(c<ALLWORDS.size()){
			
			all+=" "+ALLWORDS.get(c);
		}
		return all;
		
	}
	public Vector getAllNouns(){
		return allNouns;
	}
	
	public Vector getAllVerbs(){
		return allVerbs;
	}
	


	public void createNouns(){

		 int id=1;
	
		Log.d(TAG, "COUNT(*) FROM Noun");
		Cursor cursor = db.rawQuery("SELECT COUNT(_id) AS countid FROM Noun", null);
		cursor.moveToFirst();
		
		
		Log.d(TAG, "nounCount");

		int nounCount = cursor.getInt(0);
		cursor.close();
		Log.d(TAG, nounCount+"");
		
		String stem, end, gender;
		Word newWord;
		
		Log.d(TAG, "Creating endings arraylist");
		Vector <String> endings = new Vector();
		endings.add("nomSing");
		endings.add("accSing");
		endings.add("genSing");
		endings.add("datSing");
		endings.add("ablSing");
		endings.add("vocSing");
		endings.add("nomPlur");
		endings.add("accPlur");
		endings.add("genPlur");
		endings.add("datPlur");
		endings.add("ablPlur");
		endings.add("vocPlur");
		
		//creates all possible instances of nouns (i.e. all stems + all relative declensions)
		while (id<(nounCount)){
	
		
		int endingIndex=0;
		while (endingIndex<endings.size()){	//creating each declension of a noun
			
				if ((endingIndex!=endings.size()) && !(endingIndex > endings.size()) ){
					Vector <String> Parse = new Vector<String>();
					
					cursor = db.rawQuery("SELECT Stem FROM Noun WHERE (_id = "+id+") ", null);
					cursor.moveToFirst();
					stem = cursor.getString(0);
					cursor.close();
		
					
					cursor = db.rawQuery("SELECT Declension FROM Noun WHERE (_id = "+id+") ", null);
					cursor.moveToFirst();
					String declension = cursor.getString(0);
					cursor.close();
				
					
					cursor = db.rawQuery("SELECT DeclensionType FROM Noun WHERE (_id = "+id+") ", null);
					cursor.moveToFirst();
					String declensionType = cursor.getString(0);
					cursor.close();
					
					cursor = db.rawQuery("SELECT Definition FROM Word WHERE (_id = "+id+") ", null);
					cursor.moveToFirst();
					String definition = cursor.getString(0);
					cursor.close();
					
					cursor = db.rawQuery("SELECT Note FROM Noun WHERE (_id = "+id+") ", null);
					cursor.moveToFirst();
					String note = cursor.getString(0);
					cursor.close();
					
					cursor = db.rawQuery("SELECT " + endings.get(endingIndex)
							+" FROM " + declension + " WHERE (DeclensionType = \""
									+ declensionType
									+ "\")", null);
					cursor.moveToFirst();
					end = cursor.getString(0);
					cursor.close();
					if (end == null){
						end="";
					}
			
					
					cursor = db.rawQuery("SELECT Gender FROM Noun WHERE (_id = "+id+") ", null);
					cursor.moveToFirst();
					gender = cursor.getString(0);
					cursor.close();
			
		
					
					Parse.add(endings.get(endingIndex));
					Parse.add(gender);
																//adds gender and declension to Parse arraylist
					

					newWord = new Word(stem+end, "noun", definition, note,Parse);
					//Log.d(TAG, newWord.toString());
					allNouns.add(newWord);
		
					endingIndex++;
		
				}
				else {
					endingIndex = 0;
				}
			}
		
		
		
		id++;
		}
		
	
		Log.d(TAG,"all nouns loaded");
		
		}
	

	public void createVerbs(){
		
		Word newWord;
	
		Vector <String> endings = new Vector<String>();
		endings.add("VerbEndActIndFut");
		endings.add("VerbEndActIndImperf");
		endings.add("VerbEndActIndPres");
		endings.add("VerbEndActSubjImperf");
		endings.add("VerbEndActSubjPres");
		endings.add("VerbEndPassIndFut");
		endings.add("VerbEndPassIndImperf");
		endings.add("VerbEndPassIndPres");
		endings.add("VerbEndPassSubjImperf");
		endings.add("VerbEndPassSubjPres");
		endings.add("VerbEndActInfPres");
		
		Vector <String> endingsCommon = new Vector<String>();
		endingsCommon.add("VerbEndActIndPerf");
		endingsCommon.add("VerbEndActIndPerfFut");
		endingsCommon.add("VerbEndActIndPluperf");
		endingsCommon.add("VerbEndActInfPerf");
		endingsCommon.add("VerbEndActSubjPerf");
		endingsCommon.add("VerbEndActSubjPluperf");
	
		
		Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM Verb", null);
		cursor.moveToFirst();
		int verbCount = cursor.getInt(0);
		Log.d(TAG,"verbCount: " +verbCount);
		cursor.close();
		Log.d(TAG, "cursor open");
		
		int id=1;
		while (id<(verbCount+1)){
			
			
			cursor = db.rawQuery("SELECT Definition FROM Word WHERE (_id = "+id+") ", null);
			cursor.moveToFirst();
			String definition = cursor.getString(0);
			cursor.close();
			
			
			String principalParts="";
			cursor = db.rawQuery("SELECT PP1 FROM Verb WHERE (_id = "+id+");", null);
			cursor.moveToFirst();
			principalParts+=cursor.getString(0);
			cursor.close();
			cursor = db.rawQuery("SELECT PP2 FROM Verb WHERE (_id = "+id+");", null);
			cursor.moveToFirst();
			principalParts+=" "+cursor.getString(0);
			cursor.close();
			cursor = db.rawQuery("SELECT PP3 FROM Verb WHERE (_id = "+id+");", null);
			cursor.moveToFirst();
			principalParts+=" "+cursor.getString(0);
			cursor.close();
			cursor = db.rawQuery("SELECT PP4 FROM Verb WHERE (_id = "+id+");", null);
			cursor.moveToFirst();
			principalParts+=" "+cursor.getString(0);
			cursor.close();
			
			String note = principalParts;
			cursor = db.rawQuery("SELECT Note FROM Verb WHERE (_id = "+id+");", null);
			cursor.moveToFirst();
			
			if(cursor.getString(0) != null) {
			note+=" "+cursor.getString(0);
			Log.d(TAG, note);
			cursor.close();
			}
		
			
			
	int endingIndex=0;
		while (endingIndex<endings.size() && id<(verbCount+1)){
			cursor = db.rawQuery("SELECT COUNT(_id) FROM "+endings.get(endingIndex), null);
			cursor.moveToFirst();
		
			int endingsInEndTable = cursor.getInt(0); //number of endings (i.e. entries) in an endings table (e.g. VerbEndPassSubjImperf)
				cursor.close();
				
			int conjugationValue=1;	
			int endingsInEndTableIndex = 0;
			
			while (endingsInEndTableIndex<(endingsInEndTable/4)){
				Log.d(TAG, "endingsInEndTableIndex:"+endingsInEndTableIndex+"//endingsInEndTable/4:"+(endingsInEndTable/4));
				
					Vector <String> Parse = new Vector<String>();
					
					cursor = db.rawQuery("SELECT StemPresent FROM Verb WHERE (_id = "+id+")", null);
					cursor.moveToFirst();
					String stemPresent = cursor.getString(0);
					cursor.close();
					
					cursor = db.rawQuery("SELECT Conjugation FROM Verb WHERE (_id = "+id+")", null);
					cursor.moveToFirst();
					int conjugation = cursor.getInt(0);
					cursor.close();
					
					
					int conjugationIndex = getTableIndex(conjugation, conjugationValue);
	
					
					cursor = db.rawQuery(
							"SELECT End FROM "+endings.get(endingIndex)+" WHERE (_id = "+conjugationIndex+") "
							, null);
					cursor.moveToFirst();
					String end = cursor.getString(0);
					cursor.close();
					
					
					cursor = db.rawQuery(
							"SELECT Voice FROM "+endings.get(endingIndex)+" WHERE (_id = "+conjugationIndex+") "
							, null);
					cursor.moveToFirst();
					String voice = cursor.getString(0);
					cursor.close();
					
					cursor = db.rawQuery(
							"SELECT Mood FROM "+endings.get(endingIndex)+" WHERE (_id = "+conjugationIndex+") "
							, null);
					cursor.moveToFirst();
					String mood = cursor.getString(0);
					cursor.close();
					
					cursor = db.rawQuery(
							"SELECT Tense FROM "+endings.get(endingIndex)+" WHERE (_id = "+conjugationIndex+") "
							, null);
					cursor.moveToFirst();
					String tense = cursor.getString(0);
					cursor.close();
					
					
					cursor = db.rawQuery(
							"SELECT Person FROM "+endings.get(endingIndex)+" WHERE (_id = "+conjugationIndex+") "
							, null);
					cursor.moveToFirst();
					String person = cursor.getString(0);
					cursor.close();
					
					cursor = db.rawQuery(
							"SELECT Number FROM "+endings.get(endingIndex)+" WHERE (_id = "+conjugationIndex+") "
							, null);
					cursor.moveToFirst();
					String number = cursor.getString(0);
					cursor.close();
			
		
					Parse.add(voice);
					Parse.add(mood);
					Parse.add(tense);
					Parse.add(person);
					Parse.add(number);
																//adds gender and declension to Parse arraylist
					

					newWord = new Word(stemPresent+end, "verb",definition, note, Parse);
					allVerbs.add(newWord);
					Log.d(TAG, newWord.toString());
					
					
					
					conjugationValue++;
					if(conjugationValue>6){conjugationValue=1;}
	
					endingsInEndTableIndex++;
					
				
			}
			endingIndex++;
		}
	
		id++;
		Log.d(TAG, "id:"+id);
	
		}
		
		////////////////////////////
		int idCommon=1;
		while (idCommon<(verbCount+1)){
			
			cursor = db.rawQuery("SELECT Definition FROM Word WHERE (_id = "+idCommon+") ", null);
			cursor.moveToFirst();
			String definition = cursor.getString(0);
			cursor.close();
			
			String note = "";
			cursor = db.rawQuery("SELECT Note FROM Verb WHERE (_id = "+idCommon+");", null);
			cursor.moveToFirst();
			
			if(cursor.getString(0) != null) {
			note=cursor.getString(0);
			Log.d(TAG, note);
			cursor.close();
			}
		
			
		
		int endingCommonIndex=0;
	
		while (endingCommonIndex<endingsCommon.size()){
			Log.d(TAG, "endingCommonIndex:"+endingCommonIndex+"//endingsCommon.size:"+endingsCommon.size());	
			cursor = db.rawQuery("SELECT COUNT(_id) FROM "+endingsCommon.get(endingCommonIndex), null);
			cursor.moveToFirst();
			int endings00 = cursor.getInt(0); //number of endings (i.e. entries) in an endings table (e.g. VerbEndPassSubjImperf)
			cursor.close();
			
			int endingsInEndTableIndex = 0;
			int conjugationValue=1;
			
			while (endingsInEndTableIndex<endings00){
				
				Log.d(TAG, "endingsInEndTableIndex:"+endingsInEndTableIndex+"//endings00:"+endings00);
					Vector <String> Parse = new Vector<String>();
					
					cursor = db.rawQuery("SELECT StemPerfect FROM Verb WHERE (_id = "+idCommon+")", null);
					cursor.moveToFirst();
					String stemPresent = cursor.getString(0);

					cursor = db.rawQuery(
							"SELECT End FROM "+endingsCommon.get(endingCommonIndex)+" WHERE (_id = "+conjugationValue+") "
							, null);
					cursor.moveToFirst();
					String end = cursor.getString(0);
					cursor.close();
					
					cursor = db.rawQuery(
							"SELECT Voice FROM "+endingsCommon.get(endingCommonIndex)+" WHERE (_id = "+conjugationValue+") "
							, null);
					cursor.moveToFirst();
					String voice = cursor.getString(0);
					cursor.close();
					
					cursor = db.rawQuery(
							"SELECT Mood FROM "+endingsCommon.get(endingCommonIndex)+" WHERE (_id = "+conjugationValue+") "
							, null);
					cursor.moveToFirst();
					String mood = cursor.getString(0);
					cursor.close();
					
					cursor = db.rawQuery(
							"SELECT Tense FROM "+endingsCommon.get(endingCommonIndex)+" WHERE (_id = "+conjugationValue+") "
							, null);
					cursor.moveToFirst();
					String tense = cursor.getString(0);
					cursor.close();
					
					
					cursor = db.rawQuery(
							"SELECT Person FROM "+endingsCommon.get(endingCommonIndex)+" WHERE (_id = "+conjugationValue+") "
							, null);
					cursor.moveToFirst();
					String person = cursor.getString(0);
					cursor.close();
					
					cursor = db.rawQuery(
							"SELECT Number FROM "+endingsCommon.get(endingCommonIndex)+" WHERE (_id = "+conjugationValue+") "
							, null);
					cursor.moveToFirst();
					String number = cursor.getString(0);
					cursor.close();
			
		
					Parse.add(voice);
					Parse.add(mood);
					Parse.add(tense);
					Parse.add(person);
					Parse.add(number);
																//adds gender and declension to Parse arraylist
					

					newWord = new Word(stemPresent+end, "verb",definition,note, Parse);
					allVerbs.add(newWord);
					Log.d(TAG, newWord.toString());
					
					
					conjugationValue++;
					if(conjugationValue>6){conjugationValue=1;}
					
					
					endingsInEndTableIndex++;
					
					
			}
			endingCommonIndex++;
		
		}
	
		idCommon++;
		Log.d(TAG, "idCommon:"+idCommon);
	
		}
		
		Log.d(TAG,"all verbs loaded");
		

		
		
	}  
    public void createAdjectives(){
	
	
	
}
	public void createAdverbs(){
	
	
	
}
	public void createNumerals(){
	
	
	
}
	
	
	public SQLiteDatabase getDatabase(){
		return db;
	}

	public int getTableIndex(int conjugation, int conjugationValue){
		int i = (conjugationValue*4)-(4-conjugation);
		return i;
	}

	public void insertWordstoDB(){
			db.execSQL("DELETE FROM Word");
			db.execSQL("DELETE from sqlite_sequence WHERE name='Word'");
			
			Log.d(TAG, "cleared Word table for insert");
		  Cursor cursor = db.rawQuery("SELECT COUNT(_id) AS countid FROM Noun", null);
    		cursor.moveToFirst();
    		
    		cursor.close();
    		
		int count = 0;
		String s = "";
				while (count<ALLWORDS.size()) {

	              s=
	               "INSERT INTO [Word] ([Instance], [Category], [Definition], [Note], [Parse]) "
	               + "VALUES ('"+ALLWORDS.get(count).getInstance()+
	               "', '"+ALLWORDS.get(count).getCategory()+
	               "', '"+ALLWORDS.get(count).getDefinition()+
	               "', '"+ALLWORDS.get(count).getNote()+"', '"
	               		+ ALLWORDS.get(count).parseString()+"');";

	              Log.d(TAG, s);
	              db.execSQL(s);
	          
	              
	                count++;
	            }
	          
	        
}
	
	public void updateDatabase(){
		
		help.updateDatabase();
	}
	}
