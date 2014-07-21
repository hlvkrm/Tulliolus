package tulliolus.words.structure;

import java.util.Vector;

import tulliolus.words.Word;
import tulliolus.words.phrases.SubjectPhrase;

public class Subject{
	State state;
	Word word;
	
	public Subject(Word word,State state){
		this.state = state;
		this.word = word;
	}
	public State getState(){
	return state;
	}
	public Word getWord(){
		return word;
		}
	
}
