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

public class VectorProcessor {
	String input;
	Vector<Vector> parseVector;
	Vector<Word> word;
	String TAG = "vector processing";
	Creator creator;
	Vector inputVerbPhrase, inputSubjectPhrase, inputObjectPhrase, orderedQueryVectors;
	
	public VectorProcessor(String input, Context context){
		
		this.input = input;
		parseVector = new Vector<Vector>();//has 2 further levels of vectors
		creator = new Creator(context);
		
		//CALL METHODS ON CREATE
	}
	
	public Vector parseVector(){
		
		String[] Input = input.split(" ");
		
    	Vector<Vector<String>> instanceParseVector = new Vector<Vector<String>>();
    		//instanceParseVector: a vector of parse values vectors (instanceParse)
    									//instanceParse vectors have the instance in index 0
    	int index=0;
    	
    	
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
    	while(index<Input.length)
    	{
    		word = creator.toWord(Input[index]);
        	
    		int wordIndex=0;
    		while(wordIndex<word.size()){ //for multiple instances of one word
    			Word w = word.get(wordIndex);
    			Vector<String> instanceParse = new Vector<String>();	
    		//	instanceParse.add(w.getInstance());	//add instance to instanceParse
    			instanceParse.add(w.getOrderedParseValues());// add String of ordered parsed values
    			instanceParse.addAll(w.getParse());	//add all parse values from parse vector (from class Word) after instance
    			
    			instanceParseVector.add(instanceParse); //add this instanceParse to parseVector

    			wordIndex++;
    		}
    				parseVector.add(instanceParseVector);
    		
    		
    		index++;
    	}
    	
    	return parseVector;
    	
	}

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
	    	parseOrder.add("Noun");
	    	parseOrder.add("Adjective");
	    	parseOrder.add("Pronoun");
	    	parseOrder.add("Noun");
	    	parseOrder.add("Adjective");
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
	 
	 public SubjectPhrase getSubjectPhrase(){
		 SubjectPhrase sp = new SubjectPhrase(inputSubjectPhrase);
		 return sp;
	 }
	 
	 public ObjectPhrase getObjectPhrase(){
		 ObjectPhrase op = new ObjectPhrase(inputObjectPhrase);
		 return op;
	 }
	 
	 public VerbPhrase getVerbPhrase(){
		 VerbPhrase vp = new VerbPhrase(inputVerbPhrase);
		 return vp;
	 }
}
