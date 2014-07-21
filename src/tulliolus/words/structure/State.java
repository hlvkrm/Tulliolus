package tulliolus.words.structure;

public class State {
	int activity;
	Verb doing;
	public State(Verb doing, int activity){
		this.doing = doing;
		this.activity = activity;
	}
	
	public void setActivity(int a){
		activity = a;
	}
	
	public String getState(){
		
		String note = doing.getWord().getNote();
		String[] noteArray= note.split(" ");
		String pp1 = noteArray[1]; //the second word in "note" of verbs is the second principal part
																		//i.e. present infinitive
		String state = pp1+"."+activity;
		return state;
	}

}
