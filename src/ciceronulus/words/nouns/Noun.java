package ciceronulus.words.nouns;

import ciceronulus.words.Word;

public class Noun extends Word{

	String lemma;
	String gender;
	String stem;
	String declension;
	String note;
	
	public Noun(String lemma, String gender, String stem, String declension, String note){
		this.lemma = lemma;
		this.gender = gender;
		this.stem = stem;
		this.declension = declension;
		this.note = note;
			
	}

	public Noun(){}
}
