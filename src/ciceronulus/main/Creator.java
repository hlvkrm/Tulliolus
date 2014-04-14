package ciceronulus.main;

import java.util.ArrayList;

import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.SolveInfo;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import ciceronulus.words.IrregularVerb;
import ciceronulus.words.Word;

public class Creator {
	
	private static final String DATABASEname = "paradigm.db";
    private Helper help;
    public SQLiteDatabase db;
	
	ArrayList<Word> allNouns;
	ArrayList<Word> allVerbs;
	ArrayList<Word> allPronouns;
	ArrayList<Word> allAdverbs;
	ArrayList<Word> allAdjectives;
	ArrayList<Word> allNumerals;
	ArrayList<Word> ALLWORDS;

	IrregularVerb iv = new IrregularVerb();
	String TAG = "creating";
	
	public Creator(Context c) {
		allNouns = new ArrayList();
		allVerbs = new ArrayList();
		allPronouns = new ArrayList();
		allAdverbs = new ArrayList();
		allVerbs = new ArrayList();
		ALLWORDS = new ArrayList();
		
		help = new Helper(c, DATABASEname);
		db = help.getWritableDatabase();
		
		createNouns();
		createVerbs();
		
		ALLWORDS.addAll(allNouns);
		ALLWORDS.addAll(allVerbs);
		ALLWORDS.addAll(iv.getIrregularVerbs());

	db.close();

	
	}
	
	public ArrayList getAllWords(){

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
	public ArrayList getAllNouns(){
		return allNouns;
	}
	
	public ArrayList getAllVerbs(){
		return allVerbs;
	}
	


	public void createNouns(){

		 int id=1;
	
		Log.d(TAG, "COUNT(*) FROM Noun");
		Cursor cursor=null;
		try{
		cursor = db.rawQuery("SELECT COUNT(_id) AS countid FROM Noun", null);
		cursor.moveToFirst();
		
		Log.d(TAG, "nounCount");
		int nounCount = cursor.getInt(0);
		Log.d(TAG, nounCount+"");
		
		String stem, end, gender;
		Word newWord;
	
		
		
		Log.d(TAG, "Creating endings arraylist");
		ArrayList <String> endings = new ArrayList();
		endings.add("NomSing");
		endings.add("AccSing");
		endings.add("GenSing");
		endings.add("DatSing");
		endings.add("AblSing");
		endings.add("VocSing");
		endings.add("NomPlur");
		endings.add("AccPlur");
		endings.add("GenPlur");
		endings.add("DatPlur");
		endings.add("AblPlur");
		endings.add("VocPlur");
		
		//creates all possible instances of nouns (i.e. all stems + all relative declensions)
		while (id<(nounCount)){
	
		
		int endingIndex=0;
		while (endingIndex<endings.size()){	//creating each declension of a noun
			
				if ((endingIndex!=endings.size()) && !(endingIndex > endings.size()) ){
					ArrayList <String> Parse = new ArrayList<String>();
					
					cursor = db.rawQuery("SELECT Stem FROM Noun WHERE (_id = "+id+") ", null);
					cursor.moveToFirst();
					stem = cursor.getString(0);
		
					
					cursor = db.rawQuery("SELECT Declension FROM Noun WHERE (_id = "+id+") ", null);
					cursor.moveToFirst();
					String declension = cursor.getString(0);
				
					
					cursor = db.rawQuery("SELECT DeclensionType FROM Noun WHERE (_id = "+id+") ", null);
					cursor.moveToFirst();
					String declensionType = cursor.getString(0);
					
					
					cursor = db.rawQuery("SELECT " + endings.get(endingIndex)
							+" FROM " + declension + " WHERE (DeclensionType = \""
									+ declensionType
									+ "\")", null);
					cursor.moveToFirst();
					end = cursor.getString(0);
					if (end == null){
						end="";
					}
			
					
					cursor = db.rawQuery("SELECT Gender FROM Noun WHERE (_id = "+id+") ", null);
					cursor.moveToFirst();
					gender = cursor.getString(0);
			
		
					Parse.add(gender);
					Parse.add(endings.get(endingIndex));
																//adds gender and declension to Parse arraylist
					

					newWord = new Word(stem+end, "noun", "",Parse);
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
		finally{cursor.close();}
		
	            }
	     
	

	public void createVerbs(){
		Cursor cursor=null;
		try{
			
		int id=1;
		
		cursor = db.rawQuery("SELECT COUNT(*) FROM Verb", null);
		cursor.moveToFirst();
		
		int verbCount = cursor.getInt(0);
		Log.d(TAG,"verbCount: " +verbCount);
		cursor.close();
		
		
		Word newWord;
	
		ArrayList <String> endings = new ArrayList<String>();
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
		
		ArrayList <String> endingsCommon = new ArrayList<String>();
		endingsCommon.add("VerbEndActIndPerf");
		endingsCommon.add("VerbEndActIndPerfFut");
		endingsCommon.add("VerbEndActIndPluperf");
		endingsCommon.add("VerbEndActInfPerf");
		endingsCommon.add("VerbEndActSubjPerf");
		endingsCommon.add("VerbEndActSubjPluperf");
	
		Log.d(TAG, "cursor open");
		
		while (id<(verbCount)){
	
			
	int endingIndex=0;
		while (endingIndex<endings.size()){

			cursor = db.rawQuery("SELECT COUNT(_id) FROM "+endings.get(endingIndex), null);
			cursor.moveToFirst();
			int endings0 = cursor.getInt(0); //number of endings (i.e. entries) in an endings table (e.g. VerbEndPassSubjImperf)
			int endings0Index = 0;
			int conjugationValue=1;
			
			while (endings0Index<endings0){
				
				
					ArrayList <String> Parse = new ArrayList<String>();
					
					cursor = db.rawQuery("SELECT StemPresent FROM Verb WHERE (_id = "+id+")", null);
					cursor.moveToFirst();
					String stemPresent = cursor.getString(0);
					Log.d(TAG, stemPresent);
					
					cursor = db.rawQuery("SELECT Conjugation FROM Verb WHERE (_id = "+id+")", null);
					cursor.moveToFirst();
					int conjugation = cursor.getInt(0);
					
					
					int conjugationIndex = getTableIndex(conjugation, conjugationValue);
	
					
					cursor = db.rawQuery(
							"SELECT End FROM "+endings.get(endingIndex)+" WHERE (_id = "+conjugationIndex+") "
							, null);
					cursor.moveToFirst();
					String end = cursor.getString(0);
					
					
					cursor = db.rawQuery(
							"SELECT Voice FROM "+endings.get(endingIndex)+" WHERE (_id = "+conjugationIndex+") "
							, null);
					cursor.moveToFirst();
					String voice = cursor.getString(0);
					
					cursor = db.rawQuery(
							"SELECT Mood FROM "+endings.get(endingIndex)+" WHERE (_id = "+conjugationIndex+") "
							, null);
					cursor.moveToFirst();
					String mood = cursor.getString(0);
					
					cursor = db.rawQuery(
							"SELECT Tense FROM "+endings.get(endingIndex)+" WHERE (_id = "+conjugationIndex+") "
							, null);
					cursor.moveToFirst();
					String tense = cursor.getString(0);
					
					
					cursor = db.rawQuery(
							"SELECT Person FROM "+endings.get(endingIndex)+" WHERE (_id = "+conjugationIndex+") "
							, null);
					cursor.moveToFirst();
					String person = cursor.getString(0);
					
					cursor = db.rawQuery(
							"SELECT Number FROM "+endings.get(endingIndex)+" WHERE (_id = "+conjugationIndex+") "
							, null);
					cursor.moveToFirst();
					String number = cursor.getString(0);
			
		
					Parse.add(voice);
					Parse.add(mood);
					Parse.add(tense);
					Parse.add(person);
					Parse.add(number);
																//adds gender and declension to Parse arraylist
					

					newWord = new Word(stemPresent+end, "verb","", Parse);
					allVerbs.add(newWord);

					
					if(conjugationValue>5){conjugationValue=1;}
					conjugationValue++;
					endings0Index++;
					
					
			}
					endingIndex++;
		
	}
		
	
		
		int endingCommonIndex=0;
		while (endingCommonIndex<endingsCommon.size()){
			
			cursor = db.rawQuery("SELECT COUNT(_id) FROM "+endingsCommon.get(endingCommonIndex), null);
			cursor.moveToFirst();
			int endings0 = cursor.getInt(0); //number of endings (i.e. entries) in an endings table (e.g. VerbEndPassSubjImperf)
			int endings0Index = 0;
			int conjugationValue=1;
			
			while (endings0Index<endings0){
				
				
					ArrayList <String> Parse = new ArrayList<String>();
					
					cursor = db.rawQuery("SELECT StemPerfect FROM Verb WHERE (_id = "+id+")", null);
					cursor.moveToFirst();
					String stemPresent = cursor.getString(0);
		
					
					
					cursor = db.rawQuery(
							"SELECT End FROM "+endingsCommon.get(endingCommonIndex)+" WHERE (_id = "+conjugationValue+") "
							, null);
					cursor.moveToFirst();
					String end = cursor.getString(0);
					
					
					cursor = db.rawQuery(
							"SELECT Voice FROM "+endingsCommon.get(endingCommonIndex)+" WHERE (_id = "+conjugationValue+") "
							, null);
					cursor.moveToFirst();
					String voice = cursor.getString(0);
					
					cursor = db.rawQuery(
							"SELECT Mood FROM "+endingsCommon.get(endingCommonIndex)+" WHERE (_id = "+conjugationValue+") "
							, null);
					cursor.moveToFirst();
					String mood = cursor.getString(0);
					
					cursor = db.rawQuery(
							"SELECT Tense FROM "+endingsCommon.get(endingCommonIndex)+" WHERE (_id = "+conjugationValue+") "
							, null);
					cursor.moveToFirst();
					String tense = cursor.getString(0);
					
					
					cursor = db.rawQuery(
							"SELECT Person FROM "+endingsCommon.get(endingCommonIndex)+" WHERE (_id = "+conjugationValue+") "
							, null);
					cursor.moveToFirst();
					String person = cursor.getString(0);
					
					cursor = db.rawQuery(
							"SELECT Number FROM "+endingsCommon.get(endingCommonIndex)+" WHERE (_id = "+conjugationValue+") "
							, null);
					cursor.moveToFirst();
					String number = cursor.getString(0);
			
		
					Parse.add(voice);
					Parse.add(mood);
					Parse.add(tense);
					Parse.add(person);
					Parse.add(number);
																//adds gender and declension to Parse arraylist
					

					newWord = new Word(stemPresent+end, "verb","", Parse);
					allVerbs.add(newWord);
					
				
					if(conjugationValue>5){conjugationValue=1;}
					
					conjugationValue++;
					endings0Index++;
					
					
			}
			endingCommonIndex++;
		
		}
		
		id++;
	}
		}
		
	
		finally{cursor.close();}
		
		Log.d(TAG, "cursor close");
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
	
	public int compare(String w){
		boolean same=false;
		
		int index = -1;
		
		int count = 0;
		
	    while (count<ALLWORDS.size() && same==false){
	    	
	    Word compareWord = (Word) ALLWORDS.get(count);
	    Log.d(TAG, compareWord.toString());
	    
	    String compareString = compareWord.getInstance();
	    Log.d(TAG, compareString+"//"+w);
	    
	    if (compareString.equals(w)){
	    	 Log.d(TAG, "TRUE");
	    	index = count;
	    	same = true;
	    }
	    
	    count++;
	    }
	    
		return index;
	}
	
	public int getTableIndex(int conjugation, int conjugationValue){
		//conjugationValue:
		//		1s = 1		1p = 4	
		//		2s = 2		2p = 5
		//		3s = 3		3p = 6
		
		int i = (conjugationValue*4)-(4-conjugation);
			//nota bene: 4 because there are 4 different conjugations
		
		return i;
		
	}
}
