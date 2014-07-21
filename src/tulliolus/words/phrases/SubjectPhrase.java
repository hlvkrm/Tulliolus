package tulliolus.words.phrases;

import java.util.Vector;

import android.content.Context;
import tulliolus.process.*;
import tulliolus.words.*;

/**
 * Contains a vector.
 * Extends Phrase. Contains method combine() to condense into a Word.
 */
public class SubjectPhrase extends Phrase {

	public SubjectPhrase(Vector<Vector> Phrase){
		super(Phrase);
	}
/**
 * Combines words in a phrase to create a new Word; the instance parameter is a combination of the first three characters of each word.
 * @return String
 */
	public Word combine(){
		
		//FIX: COMBINE WORDS TO CREATE A NEW WORD
		String instance = "";
		String definition="";
		String note="";
		
		for (int i = 0; i < Phrase.size(); i++){
			Word temp = Phrase.get(i);
			instance+= temp.getInstance().substring(0,2);
			definition += " // "+temp.getDefinition();
			note += " // "+temp.getNote();
		}
		
		Word concat= new Word(instance, "noun", definition, note, "nom"); 
		
		return concat;
	}

	
}
