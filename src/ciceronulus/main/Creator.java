package ciceronulus.main;

import java.util.Vector;

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

import ciceronulus.words.IrregularNoun;
import ciceronulus.words.IrregularVerb;
import ciceronulus.words.Pronoun;
import ciceronulus.words.Word;

public class Creator {
	
	private static final String DATABASEname = "paradigm.db";
    private Helper help;
    public SQLiteDatabase db;
	
    static Vector<Word> allNouns;
	static Vector<Word> allVerbs;
	static Vector<Word> allPronouns;
	static Vector<Word> allAdverbs;
	static Vector<Word> allAdjectives;
	static Vector<Word> allNumerals;
	static Vector<Word> ALLWORDS;

	IrregularVerb iv = new IrregularVerb(); IrregularNoun in = new IrregularNoun(); Pronoun p = new Pronoun();
	String TAG = "creating";
	
	public Creator(Context c) {
		allNouns = new Vector();
		allVerbs = new Vector();
		allPronouns = new Vector();
		allAdverbs = new Vector();
		allVerbs = new Vector();
		ALLWORDS = new Vector();
		
		help = new Helper(c, DATABASEname);
		db = help.getWritableDatabase();
		
		createNouns();
		createVerbs();
		
		ALLWORDS.addAll(allNouns);
		ALLWORDS.addAll(in.getIrregularNouns());
		ALLWORDS.addAll(p.getPronouns());
		ALLWORDS.addAll(allVerbs);
		ALLWORDS.addAll(iv.getIrregularVerbs());

	db.close();

	
	}
	
	public Creator(){}
	
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
		Cursor cursor=null;
		
		cursor = db.rawQuery("SELECT COUNT(_id) AS countid FROM Noun", null);
		cursor.moveToFirst();
	
		Log.d(TAG, "nounCount");

		int nounCount = cursor.getInt(0);
		cursor.close();
		Log.d(TAG, nounCount+"");
		
		String stem, end, gender;
		Word newWord;
	
		
		
		Log.d(TAG, "Creating endings arraylist");
		Vector <String> endings = new Vector();
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
	

	public void createVerbs(){
		Cursor cursor=null;
	
		int id=1;
		
		cursor = db.rawQuery("SELECT COUNT(*) FROM Verb", null);
		cursor.moveToFirst();
		int verbCount = cursor.getInt(0);
		Log.d(TAG,"verbCount: " +verbCount);
		cursor.close();
		
		
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
		
		Vector <String> endingsCommon = new Vector<String>();
		endingsCommon.add("VerbEndActIndPerf");
		endingsCommon.add("VerbEndActIndPerfFut");
		endingsCommon.add("VerbEndActIndPluperf");
		endingsCommon.add("VerbEndActInfPerf");
		endingsCommon.add("VerbEndActSubjPerf");
		endingsCommon.add("VerbEndActSubjPluperf");
	
		Log.d(TAG, "cursor open");
		
		while (id<(verbCount+1)){
	
			
	int endingIndex=0;
		while (endingIndex<endings.size()){

			cursor = db.rawQuery("SELECT COUNT(_id) FROM "+endings.get(endingIndex), null);
			cursor.moveToFirst();
		
			int endings0 = cursor.getInt(0); //number of endings (i.e. entries) in an endings table (e.g. VerbEndPassSubjImperf)
			int endings0Index = 0;
			int conjugationValue=1;
				cursor.close();
				
				
			while (endings0Index<endings0){
				
				
					Vector <String> Parse = new Vector<String>();
					
					cursor = db.rawQuery("SELECT StemPresent FROM Verb WHERE (_id = "+id+")", null);
					cursor.moveToFirst();
					String stemPresent = cursor.getString(0);
					cursor.close();
					Log.d(TAG, stemPresent);
					
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
				
				
					Vector <String> Parse = new Vector<String>();
					
					cursor = db.rawQuery("SELECT StemPerfect FROM Verb WHERE (_id = "+id+")", null);
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
	
	//public int compare(String w) {MOVED TO GRAMMARCHECK}

	public int getTableIndex(int conjugation, int conjugationValue){
		int i = (conjugationValue*4)-(4-conjugation);
		return i;
	}
}
