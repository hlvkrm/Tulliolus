package ciceronulus.respond;

import java.util.Vector;

import ciceronulus.words.Word;

public class ResponseGenerator {

	Vector<Word> input;
	
	public ResponseGenerator(Vector<Word> input){
	this.input = input;	
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
