package tulliolus.process.questions;

import tulliolus.respond.Response;
import tulliolus.words.Word;

public class Question {
	boolean answered, relevant;
	String type;
	Word answer;
	Response response;
	public Question(String type, Word answer, Response response){
		this.type = type;
		this.answer = answer;
		this.response = response;
	}
	
	public boolean checkRelevancy(){
		///
		
		return relevant;
	}
	public void setRelevancy(boolean relevant){
		this.relevant = relevant;
	}
	public boolean relevant(){
		return relevant;
	}
	public String getType(){
		return type;
	}
	
	public boolean answered(){
		return answered;
	}
	
	public void setAnswer(Word answer){
		this.answer = answer;
	}
	public Word getAnswer(){
		answered= true;
		return answer;
	}

	public Response getResponse(){
		return response;
	}
}
