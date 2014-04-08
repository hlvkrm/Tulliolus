package ciceronulus.words;

import java.util.ArrayList;

public class Word {
	
String instance;
String category;
ArrayList<String> Parse;//load all parse values (e.g. AccP, GenP, Voice, Mood etc.)
	
public Word (String instance, String category, ArrayList<String> Parse){
		this.instance = instance;
		this.category = category;
		this.Parse = Parse;
	}

public Word(){}
}
