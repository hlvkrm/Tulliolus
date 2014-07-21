package tulliolus.words.phrases;

import java.util.Vector;
import tulliolus.process.Processor;
import tulliolus.words.WordParse;
import android.content.Context;
/**
 * Extended by SubjectPhrase, ObjectPhrase, and VerbPhrase.
 * 
 */
public class Phrase {

		Vector<WordParse> Phrase;
		Processor process;
		SubjectPhrase subjectPhrase;
		ObjectPhrase objectPhrase;
		VerbPhrase verbPhrase;

	/**
	 * Parent of SubjectPhrase, ObjectPhrase, and VerbPhrase. 
	 * @param Phrase
	 */
		public Phrase(Vector Phrase){
			this.Phrase = Phrase;
			process = new Processor(toString());
		}
		
		public String toString(){
			
			String s = "";
			
			for (int i = 0; i<Phrase.size();i++){
			
				if(i==0){
				s += Phrase.get(i).getInstance();}
				
				else{
					s += " "+Phrase.get(i).getInstance();} //making sure there is a space only between words, and not before/after the phrase
			}
			return s;
		}
		
		public Vector getPhraseVector(){
			return Phrase;
		}
		public boolean isEmpty(){
			return Phrase.isEmpty();
		}
}
