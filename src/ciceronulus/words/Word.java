package ciceronulus.words;

import java.util.ArrayList;

import android.database.sqlite.SQLiteDatabase;
import ciceronulus.main.Creator;

public class Word {
	
String instance;
String category;
String note;
ArrayList<String> Parse;


public Word (String instance, String category, String note, ArrayList<String> Parse){
		this.instance = instance;
		this.category = category;
		this.note = note;
		this.Parse = Parse;

	}



public String getInstance(){
	
	return instance;
}

public String getCategory(){
	
	return category;
}

public String getNote(){
	
	return category;
}

public ArrayList<String> getParse(){
	
	return Parse;
}

public String toString(){
	
	return "["+instance+" / "+category+" / "+note+" /"+ parseString()+"]";
	
}

public String parseString(){
	int count = 0;
	String parseStr ="";
	while (count<Parse.size()){
		parseStr += " " + Parse.get(count);
		count++;
	}
	
	return parseStr;
}
}
