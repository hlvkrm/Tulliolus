package ciceronulus.words;

import java.util.Vector;

import ciceronulus.main.Creator;

public class ParsedValue 
{
	String input;
	Vector<String> ParseArray;
	Vector<Word> WordList;
	Creator creator;
	
	
	public ParsedValue(String input)
	{
		this.input = input;

		creator = new Creator();
		ParseArray = new Vector<String>();
		WordList = creator.getAllWords();
		
	}	
	
	public Vector<String> toParseArray(){
		
		return ParseArray;
		
	}
}
