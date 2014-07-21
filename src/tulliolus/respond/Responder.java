package tulliolus.respond;

import java.util.Random;
import java.util.Vector;

import android.util.Log;
import tulliolus.process.*;
import tulliolus.process.questions.Question;
import tulliolus.process.questions.QuestionCheck;
import tulliolus.words.*;
import tulliolus.words.phrases.*;

public class Responder {

	String TAG = "Responding";
	Random random;
	static Vector<QuestionCheck> Topics;
	QuestionCheck current;
	Processor process;
	SubjectPhrase subjectPhrase;
	ObjectPhrase objectPhrase;
	VerbPhrase verbPhrase;
	
	public Responder(GrammarCheck check){
	Log.d(TAG, "constructing");
	Topics = new Vector();
	process = check.getProcessor();
	subjectPhrase = process.getSubjectPhrase();
	objectPhrase = process.getObjectPhrase();
	verbPhrase = process.getVerbPhrase();
	random = new Random();
	Log.d(TAG, "constructing finished");
	}
	
	/**
	 * Creates a QuestionCheck for the input
	 */
	private QuestionCheck analyze(){
		Log.d(TAG, "analyzing");
		QuestionCheck checklist = new QuestionCheck(subjectPhrase.toString()); //the subject of the sentence is the topic
	
		//analyzing subjectPhrase

//CHECKING QUIS/QUID (SUBJECT)
		if(!subjectPhrase.isEmpty()){
			
			Word sp = subjectPhrase.combine();
			String note = sp.getNote();
			if(note.contains("person")){
				checklist.getQuisSubj().setAnswer(sp);
				checklist.getQuidSubj().setRelevancy(false);	//if the subject is "who", the subject won't be "what"
			}
			else{
				checklist.getQuidSubj().setAnswer(sp);
				checklist.getQuisSubj().setRelevancy(false);
			}
		
		}
		
//CHECKING QUEM/QUID (OBJECT)
		if(!objectPhrase.isEmpty()){
			
			Word op = objectPhrase.combine();
			String note = op.getNote();
			if(note.contains("person")){
				checklist.getQuem().setAnswer(op);
				checklist.getQuidObj().setRelevancy(false);	 //if the object is "who", the object won't be "what"
			}
			else{
				checklist.getQuidObj().setAnswer(op);
				checklist.getQuem().setRelevancy(false);
			}
		
		}
		
//CHECKING CUR
		//check for clauses of purpose (supines, ut...)/because

//CHECKING UBI
		
//CHECKING QUOMODO

//CHECKING QUALIS

		//CHECKING QUANTUS
//CHECKING QUOT
	
	Topics.add(checklist);
	current = checklist;
	
	Log.d(TAG, "analyzing finished");
	return checklist;
	}
	
/**
 * Generates a response to the input. The current topic (i.e. current QuestionCheck) is analyzed to assess which questions 
 * have/have not been answered. The type of response to be generated (question, statement, or command) is randomly selected.
 * Returns the complete response that is to be outputted to the UI.
 * @return String
 */
	public String generate(){
		Question chosenQuestion;
		String response = "";
		QuestionCheck currentRef = analyze();
		Vector unanswered = currentRef.getUnanswered();
		Vector answered = currentRef.getAnswered();
		
		
		int responseInt = randomizeResponse(); 
			responseInt = 0; //DELETE ONCE STATEMENT AND IMPERATIVE ARE CODED
			
		if (responseInt == 0){ //generating question
			
			if(unanswered.isEmpty()){// asks "why" if there is no other question to ask
				chosenQuestion = current.getCur(); //make sure this is done for the current topic
			}
			else{
			
			int questionChoice = random.nextInt(unanswered.size()); //choosing a random index from Vector unanswered
			chosenQuestion = currentRef.getList().get((Integer.parseInt((String)unanswered.get(questionChoice))));
					//getting the question by getting the vector of questions and getting the index of the randomized index from Vector left
			}
			
			int questionIndex = current.getList().indexOf(chosenQuestion);
			
			response = restate(questionIndex);
			
			
		}
		if (responseInt == 1){ //generating statement
			
			
		}
		if (responseInt == 2){
			
			
		}
		
		
		return response;
	}
	
	private String restate(int questionIndex){
		String restatement = "";
		
		switch (questionIndex){
		
		case 0: //QuidSubj
		
			restatement = "Quidne "+ objectPhrase.toString() + " " + verbPhrase.toString()+"?";
		
			break;
		
		case 1: //Quis
	
			restatement = "Quisne "+ objectPhrase.toString() + " " + verbPhrase.toString()+"?";

			break;
			
			
		case 2: //QuidObj
			restatement = "Quidne "+ subjectPhrase.toString() + " " + verbPhrase.toString()+"?";
			
			break;
		
		case 3: //Quem
		
			restatement = "Quemne "+ subjectPhrase.toString() + " " + verbPhrase.toString()+"?";
			
			break;
			
		case 7: //Qualis
			break;
			
		case 8: //Quantus
			break;
			
			
		case 9: //Quot
			
		default: //for cur ubi quomodo
			String questionWord = current.getList().get(questionIndex).getType();
			
			restatement = questionWord + " "+ subjectPhrase.toString() + " " + objectPhrase+ " "+ verbPhrase.toString()+"?";
			break;
		}
		
		
		return restatement;
		
	}
	/**
	 * Returns an int value indicating what kind of response is to be generated. <br>
	 * 0 = question <br>
	 * 1 = statement <br>
	 * 2 = imperative
	 * @return int
	 */
	private int randomizeResponse(){ 
		int response;
		response = random.nextInt(2); 
		return response;
		
	}
	
	//private int searchTopics(){}
	
}
