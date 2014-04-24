package tulliolus.respond;

import java.util.Vector;

import tulliolus.process.*;
import tulliolus.words.*;
import tulliolus.words.phrases.*;

public class Responder {

	Vector<WordParse> input;// instance, category, note, parseString, parse[]
							//ordered
	
	VectorProcessor process;
	SubjectPhrase subjectPhrase;
	ObjectPhrase objectPhrase;
	VerbPhrase verbPhrase;
	
	public Responder(Vector<WordParse> input, GrammarCheck check){
	this.input = input;	
	process = check.getVectorProcessor();
	subjectPhrase = process.getSubjectPhrase();
	objectPhrase = process.getObjectPhrase();
	verbPhrase = process.getVerbPhrase();
	}
	
	public void analyze(){
		
		
		
	}
	
	public String generate(){
		String response = "";
		String subject, object, verb;

		
		subject = generateSubject();
		object = generateObject();
		verb = generateVerb();
		
		return response;
	}
	
	public String generateSubject(){
		String subject = "";
		
		return subject;
	}
	
	public String generateObject(){
		String object = "";
		
		return object;
	}
	
	public String generateVerb(){
		String verb = "";
		
		return verb;
	}
	
	public Vector<Word> findSubject(){
		Vector<Word> subject = new Vector<Word>();
	
		return subject;
		
	}
	
	public Vector<Word> findObject(){
		Vector<Word> object = new Vector<Word>();
		
		return object;
	}
	
	public Vector<Word> findVerb(){
		Vector<Word> verb = new Vector<Word>();
		
		return verb;
		
	}
	
	
}
