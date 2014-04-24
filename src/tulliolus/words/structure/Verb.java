package tulliolus.words.structure;

import tulliolus.words.Word;


public class Verb {
	
	Word verb;
	Subject subject;
	Object object;

	public Verb(Word verb, Subject subject, Object object){
		this.verb = verb;
		this.subject = subject;
		this.object = object;

		
	}

}
