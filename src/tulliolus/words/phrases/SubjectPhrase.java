package tulliolus.words.phrases;

import java.util.Vector;

import android.content.Context;
import tulliolus.process.*;
import tulliolus.words.*;


public class SubjectPhrase extends Phrase {

	public SubjectPhrase(Vector<WordParse> Phrase){
		super(Phrase);
	}
	
	public Phrase getSubordinate(){
		subjectPhrase = process.getSubjectPhrase();
		return subjectPhrase;
	}
	
}
