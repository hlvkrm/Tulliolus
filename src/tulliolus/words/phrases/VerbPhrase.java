package tulliolus.words.phrases;

import java.util.Vector;

import tulliolus.words.WordParse;

public class VerbPhrase extends Phrase{

	public VerbPhrase(Vector<WordParse> Phrase){
		super(Phrase);
	}
	
	public Phrase getSubordinate(){
		verbPhrase = process.getVerbPhrase();
		return verbPhrase;
	}
}
