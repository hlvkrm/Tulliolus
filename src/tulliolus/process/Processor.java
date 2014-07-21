package tulliolus.process;

import java.util.Vector;

import alice.tuprolog.MalformedGoalException;
import android.content.Context;
import android.util.Log;
import tulliolus.main.Creator;
import tulliolus.words.Word;
import tulliolus.words.phrases.ObjectPhrase;
import tulliolus.words.phrases.SubjectPhrase;
import tulliolus.words.phrases.VerbPhrase;
/**
 * Processes a String input into three vectors, and subsequently into three objects:
 * SubjectPhrase, ObjectPhrase, and VerbPhrase. 
 * @param String input
 * @getters SubjectPhrase subjectPhrase<br>
 * ObjectPhrase objectPhrase<br>
 * VerbPhrase verbPhrase<br>
 * String input<br>
 * Vector<Vector> ParseVector
 *
 */
public class Processor {
	String TAG = "vector processing";
	String input;
	Vector<Vector> parseVector;
	Vector<Word> word;
	Creator creator;
	Vector inputVerbPhrase, inputSubjectPhrase, inputObjectPhrase;
	SubjectPhrase sp; ObjectPhrase op; VerbPhrase vp;
	ConstructionCheck cc;
	
	public Processor(String input){
		
		this.input = input;
		parseVector = new Vector<Vector>();//has 2 further levels of vectors
		creator = new Creator();
		
		parseVector();
		cc = new ConstructionCheck(this);
		fillPhrases();
	}
	
	/**
	 * Inserts subjectPhrase, objectPhrase, and verbPhrase with their respective values. Calls the ConstructionCheck class
	 * to first check the input for constructions. The remainder (i.e. what words are left after all the constructions have been
	 * accounted for) is assumed to be consisted of simple nouns/adjectives, and are inserted into the correct Phrase vector 
	 * based on their parsed case (nom --> subjectPhrase, acc --> objectPhrase). Vector<Vector> constructionList (generated from the check()
	 * method of the ConstructionCheck class) contains the constructions in vectors, which have been labeled either subjectPhrase, 
	 * objectPhrase, or verbPhrase during check().
	 * 
	 */
	private void fillPhrases(){
		
		Vector constructionList = cc.check();
		Vector remainder = cc.getParseVector();// remainding words after construction grouping
		
		//subjectPhrase
		for (int i = 0; i< remainder.size(); i++)
		{
			int skip=0;
			int index = cc.search("nom", skip, remainder);
			if(index!=-1){
				inputSubjectPhrase.add(remainder.get(index));
				skip++;
			}
		}
		for (int i = 0; i< constructionList.size(); i++)
		{
			int skip=0;
			int index = cc.search("subjectPhrase", skip, constructionList);
			if(index!=-1){
				inputSubjectPhrase.add(constructionList.get(index));
				skip++;
			}
		}
		
		//objectPhrase
		for (int i = 0; i< remainder.size(); i++)
		{
			int skip=0;
			int index = cc.search("acc", skip, remainder);
			if(index!=-1){
				inputObjectPhrase.add(remainder.get(index));
				skip++;
			}
		}
		for (int i = 0; i< constructionList.size(); i++)
		{
			int skip=0;
			int index = cc.search("objectPhrase", skip, constructionList);
			if(index!=-1){
				inputObjectPhrase.add(constructionList.get(index));
				skip++;
			}
		}
		
		//verbPhrase
		for (int i = 0; i< remainder.size(); i++)
		{
			int skip=0;
			int index = cc.search("verb", skip, remainder);
			if(index!=-1){
				inputVerbPhrase.add(remainder.get(index));
				skip++;
			}
		}
		for (int i = 0; i< constructionList.size(); i++)
		{
			int skip=0;
			int index = cc.search("verbPhrase", skip, constructionList);
			if(index!=-1){
				inputVerbPhrase.add(constructionList.get(index));
				skip++;
			}
		}
		
		
		 sp = new SubjectPhrase(inputSubjectPhrase);
		 op = new ObjectPhrase(inputObjectPhrase);
		 vp = new VerbPhrase(inputVerbPhrase);
	}

	public void parseVector(){
		
		String[] Input = input.split(" ");
		
    	Vector instanceParseVector = new Vector ();
    		//instanceParseVector: a vector of parse values vectors (instanceParse)
    									//instanceParse vectors have the instance in index 0
    
    	/*For each word of an input:
    	 * 1: duplicate instances are searched for in db (e.g. domino(dat) and domino(abl))
    	 * 2: all instances are found and stored in Vector<Word> word 
		 * 3: all words in Vector<Word> word are individually stored in Vector<String> instanceParse
    	 * 	  with the inputted instance and the ordered parsed values from class Word.getOrderedParsedValues() 
    	 * 4: each instanceParse is stored in Vector<Vector<String>> instanceParseVector
    	 * 							 - an instanceParseVector essentially represents all the parsing variations of an instance
    	 * 									e.g. domino(dat) and domino(abl) would both be stored individually in an 
    	 * 											instanceParseVector to represent all the variations of "domino" 
    	 * 5: each instanceParseVector is added to Vector<Vector> parseVector
    	 * 							- each index of parseVector contains all the parse information of each instance
    	 * */
    	for (int index=0;index<Input.length; index++)
    	{
    		word = creator.toWord(Input[index]);
        	
    		int wordIndex=0;
    		String totalParseString = "", instanceString="";
    		while(wordIndex<word.size()){ //for multiple instances of one word
    			
    			Word w = word.get(wordIndex);
    			Vector<String> instanceParse = new Vector<String>();	
    			//instanceParse.add(w.getInstance());	//add instance to instanceParse
    			instanceString = w.getInstance();
    			instanceParse.add(w.getOrderedParseValues());// add String of ordered parsed values
    			totalParseString+=w.getOrderedParseValues()+" ";
    			instanceParse.addAll(w.getParse());	//add all parse values from parse vector (from class Word) after instance
    			
    			instanceParseVector.add(instanceParse); //add this instanceParse to parseVector

    			wordIndex++;
    		}
    		instanceParseVector.add(0,instanceString);
    		instanceParseVector.add(1,totalParseString);
    		
    				parseVector.add(instanceParseVector);
    		
    	}
    	
	}
	
	public Vector<Vector> getParseVector(){
		return parseVector;
	}
	public String getInput(){
		return input;
	}
	
	public SubjectPhrase getSubjectPhrase(){return sp;}
	public ObjectPhrase getObjectPhrase(){return op;}
	public VerbPhrase getVerbPhrase(){return vp;}
/*
	 public Vector order(Vector<Vector> parseVector) throws MalformedGoalException{
	    	
	    	orderedQueryVectors = new Vector();
	    	inputVerbPhrase = new Vector();
	    	inputSubjectPhrase = new Vector();
	    	inputObjectPhrase = new Vector();
	    	
	    	
	    	for (int index=0;index<parseVector.size();index++)//for each word
	    	{
	    		Vector vectorLvl0 = parseVector.get(index);
	    		
	    		for (int index0=0;index<parseVector.size(); index0++)	//for each instanceParseVector
	        	{
	    			Vector vectorLvl1 = (Vector) vectorLvl0.get(index0);
	    			
	    			
	        		for (int index1 = 0; index1<vectorLvl1.size(); index1++)	//for each instanceParse
	            	{
	        			Vector<Vector> instanceParse =	(Vector) vectorLvl1.get(index1);
	        			
	        			String orderedParse = (String) instanceParse.get(index).get(1);
	        			
	        			if (orderedParse.contains("Verb")){
	        			inputVerbPhrase.add(orderedParse);
	        			}
	        			if (orderedParse.contains("Noun")){
	        				if (orderedParse.contains("nom")){
	        					inputSubjectPhrase.add(orderedParse);
	        				}
	        				if (orderedParse.contains("acc")){
	        					inputObjectPhrase.add(orderedParse);
	        				}
	        			}
	            	}
	        	
	        	
	        	}
	    		
	    	}
	    	
	    	Vector<String> instanceQueryVector = new Vector();
	    	
	    	instanceQueryVector.addAll(inputVerbPhrase);
	    	instanceQueryVector.addAll(inputSubjectPhrase);
	    	instanceQueryVector.addAll(inputObjectPhrase);

	    	//e.g. firstSingVerb([_],[nomSingMNoun],[_],[_],[_],[_],[accSingMNoun],[_],[_],[_]).
	    	String query = instanceQueryVector.get(0)+"([_],";
	    	String blank = "[_]";
	    	
	    	Vector<String> parseOrder = new Vector<String>();
	    	parseOrder.add("Pronoun");
	    	parseOrder.add("Noun");
	    	parseOrder.add("Adjective");
	    	
	    	int i0 = 1;
	    	for (int i = 0; i<parseOrder.size(); i++){
	    	
	    		if(instanceQueryVector.get(i0).contains(parseOrder.get(i))){
	    			query+="["+instanceQueryVector.get(i)+"]";
	    			i0++;
	    		}
	    		else{
	    			query+=blank;
	    		}
	    		
	    		if(i==parseOrder.size()-1){
	    			query+= "]).";
	    		}
	    		else{
	    			query+= ",";
	    		}
	    	
	    	}
	    
	    	Log.d(TAG, query);
	    	
	    	//if (!correct(query))
	    	{
	    		
	    	}
	    	
	    return orderedQueryVectors;
	    }
	 */
}
