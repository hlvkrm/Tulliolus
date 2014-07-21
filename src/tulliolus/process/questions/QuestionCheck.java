package tulliolus.process.questions;

import java.util.Vector;

import tulliolus.respond.Response;

public class QuestionCheck {

	Vector<Question> Questions;
	String topic;
	public QuestionCheck(String topic){
		this.topic = topic;
		Questions = new Vector<Question>();
		//Question(String type, Word answer, Response(String type, String mod) response)
		Questions.add(new Question("QuidSubj",null, new Response("thing",null)));
		Questions.add(new Question("Quis",null, new Response("person",null)));
		Questions.add(new Question("QuidObj",null, new Response("thing",null)));
		Questions.add(new Question("Quem",null, new Response("person",null)));
		Questions.add(new Question("Cur",null, new Response("explanation",null)));
		Questions.add(new Question("Ubi",null, new Response("place",null)));
		Questions.add(new Question("Quomodo",null, new Response("adverbPhrase",null)));
		Questions.add(new Question("Qualis",null, new Response("type",null)));
		Questions.add(new Question("Quantus",null, new Response("degree",null)));
		Questions.add(new Question("Quot",null, new Response("number",null)));
	
		
	
	}
	
	public String getTopic(){
		
		return topic;
	}
	
	public Vector<Question> getList(){
		return Questions;
	}
/**
 * Returns a vector containing the indexes of the unanswered questions.
 * @return Vector
 */
	public Vector getUnanswered(){ //CHECK IF I CAN ADD PRIMITIVES TO VECTORS
		Vector indexVector = new Vector();
		
		for(int i=0; i<Questions.size();i++){
			if(!Questions.get(i).answered()){
				indexVector.add(i);
			}
		}
		
		return indexVector;
	}
	
/**
 * Returns a vector containing the indexes of the answered questions.
 * @return Vector
 */
	public Vector getAnswered(){ //CHECK IF I CAN ADD PRIMITIVES TO VECTORS
			Vector indexVector = new Vector();
			
			for(int i=0; i<Questions.size();i++){
				if(Questions.get(i).answered()){
					indexVector.add(i);
				}
			}
			
			return indexVector;
		}
	
////////////////////////////////////////////////////////////////////////////////////////////////
///GETTERS
	
	/**
	 * Index 0 of Vector<Question> Questions in QuestionCheck class.
	 * @return Question QuidSubj
	 */
	public Question getQuidSubj(){
		return Questions.get(0);
	}
	
	/**
	 * Index 1 of Vector<Question> Questions in QuestionCheck class.
	 * @return Question QuisSubj
	 */
	public Question getQuisSubj(){
		return Questions.get(1);
	}
	
	/**
	 * Index 2 of Vector<Question> Questions in QuestionCheck class.
	 * @return Question QuidObj
	 */
	public Question getQuidObj(){
		return Questions.get(2);
	}
	
	/**
	 * Index 3 of Vector<Question> Questions in QuestionCheck class.
	 * @return Question Quem
	 */
	public Question getQuem(){
		return Questions.get(3);
	}
	
	/**
	 * Index 4 of Vector<Question> Questions in QuestionCheck class.
	 * @return Question Cur
	 */
	public Question getCur(){
		return Questions.get(4);}
	
	/**
	 * Index 5 of Vector<Question> Questions in QuestionCheck class.
	 * @return Question Ubi
	 */
	public Question getUbi(){
		return Questions.get(5);
	}
	
	/**
	 * Index 6 of Vector<Question> Questions in QuestionCheck class.
	 * @return Question Quomodo
	 */
	public Question getQuomodo(){
		return Questions.get(6);
	}
	
	/**
	 * Index 7 of Vector<Question> Questions in QuestionCheck class.
	 * @return Question Qualis
	 */
	public Question getQualis(){
		return Questions.get(7);
	}
	
	/**
	 * Index 8 of Vector<Question> Questions in QuestionCheck class.
	 * @return Question Quantus
	 */
	public Question getQuantus(){
		return Questions.get(8);
	}
	
	/**
	 * Index 9 of Vector<Question> Questions in QuestionCheck class.
	 * @return Question Quot
	 */
	public Question getQuot(){
		return Questions.get(9);
	}
	
}
