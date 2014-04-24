package tulliolus.words;

import java.util.Vector;

import tulliolus.main.Creator;
import android.database.sqlite.SQLiteDatabase;

public class Word {
	
String instance;
String category;
String note;
Vector<String> Parse;
String parseString;


public Word (String instance, String category, String note, Vector<String> Parse){
		this.instance = instance;
		this.category = category;
		this.note = note;
		this.Parse = Parse;

	}

public Word (String instance, String category, String note, String parseString){
	this.instance = instance;
	this.category = category;
	this.note = note;
	this.parseString = parseString;

}
public Word (){}

public String getInstance(){
	
	return instance;
}

public String getCategory(){
	
	return category;
}

public String getNote(){
	
	return note;
}

public Vector<String> getParse(){
	
	return Parse;
}

public String toString(){
	
	if (Parse==null){
		return parseString;
	}
	else{
	return "["+instance+" / "+category+" / "+note+" /"+ parseString()+"]";
	}
}

public String parseString(){
	
	if (Parse!=null)
	{
		int count = 0;
		String parseStr ="";
		while (count<Parse.size()){
		parseStr += " " + Parse.get(count);
		count++;
	}
	
		return parseStr;
		}
	
	else {return toString();}
}

public String personToOrdinal(){
	
	String person = Parse.get(3);
	String ordinal = "";
	if(person.equals("1")){
		ordinal = "first";
	}
	if(person.equals("2")){
		ordinal = "second";
	}
	if(person.equals("3")){
		ordinal = "third";
}
	
	return ordinal;
}
public String getOrderedParseValues(){
	String prologParse="";
	
	//NOUN: declension,number,gender,NOUN
	if (category.equals("noun")){
		prologParse = (Parse.get(0))
				+ (Parse.get(1).toUpperCase())
				+"Noun";
	}
	
	//PRONOUN: declension,number,gender,NOUN
		if (category.equals("pronoun")){
			prologParse = (Parse.get(0))
					+ (Parse.get(1).toUpperCase())
					+"Pronoun";
		}
		
		//VERB: person, number, VERB
	if (category.equals("verb")){
		prologParse = (personToOrdinal())
				+ (Parse.get(4).substring(0, 1).toUpperCase() + Parse.get(4).substring(1))
				+"Verb";
	}
	return prologParse;
	
	
}
}
