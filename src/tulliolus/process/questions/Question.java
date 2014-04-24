package tulliolus.process.questions;

public class Question {

	boolean answered, relevant;
	String answer;
	public Question(boolean answered, String answer, boolean relevant, String response){
		this.answered = answered;
		this.answer = answer;
		this.relevant = relevant;
	}
	
	public void setAnswered(boolean change){
		answered = change;
	}
	public boolean getAnswered(){
		return answered;
	}
	
	public void setAnswer(String answer){
		this.answer = answer;
	}
	public String getAnswer(){
		return answer;
	}
	public void setRelevancy(boolean change){
		relevant = change;
	}
	public boolean getRelevancy(){
		return relevant;
	}
}
