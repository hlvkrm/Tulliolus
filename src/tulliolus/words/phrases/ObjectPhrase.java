package tulliolus.words.phrases;

import java.util.Vector;

import tulliolus.words.WordParse;

public class ObjectPhrase extends Phrase{
	
	public ObjectPhrase(Vector<WordParse> Phrase){
		super(Phrase);
	}
	
	public Phrase getSubordinate(){
		objectPhrase = process.getObjectPhrase();
		return objectPhrase;
	}
}
