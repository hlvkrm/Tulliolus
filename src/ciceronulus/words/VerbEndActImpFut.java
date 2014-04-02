package ciceronulus.words;

import java.util.ArrayList;

public class VerbEndActImpFut extends VerbEnding{
	
	String end;
	String voice;
	String mood;
	String tense;
	String person; 
	String number;
	String aspect;
	
	public VerbEndActImpFut(String end, String voice,String mood, String tense, String person, String number, String aspect) {
		this.end = end;
		this.voice = voice;
		this.mood = mood;
		this.tense = tense;
		this.person = person;
		this.number = number;
		this.aspect = aspect;
		
	}
	
	public ArrayList<String> addToParse(ArrayList<String> Parse){
		
		Parse.add(end);
		Parse.add(voice);
		Parse.add(mood);
		Parse.add(tense);
		Parse.add(person);
		Parse.add(number);
		Parse.add(aspect);
		
		return Parse;
		
	}
	
}
