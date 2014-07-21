package tulliolus.words.structure;

import tulliolus.words.Word;


public class Verb {
	
	Word word;
	int activity, transitivity;
	
//get definition from Word class;
// activity/transitivity: 
		//activeExclusive:1 passiveExclusive:-1 either:0
	
	public Verb(Word word, int activity, int transitivity){
		this.word = word;
		this.activity = activity;///get from word
		this.transitivity = transitivity;//get from word

	}
	
	public Word getWord(){
		return word;
	}
	public int getActivity(){
		return activity;
	}
	public int getTransitivity(){
		return transitivity;
	}
	public String toString(){return word.toString();}

}
