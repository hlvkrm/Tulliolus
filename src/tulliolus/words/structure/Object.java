package tulliolus.words.structure;

import java.util.Vector;

import tulliolus.words.Word;
import tulliolus.words.phrases.SubjectPhrase;

public class Object{
	State state;
	Word word;
	
	public Object(Word word,State state){
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
