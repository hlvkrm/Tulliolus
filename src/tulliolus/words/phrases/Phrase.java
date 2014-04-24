package tulliolus.words.phrases;

import java.util.Vector;

import tulliolus.process.VectorProcessor;
import tulliolus.words.WordParse;
import android.content.Context;

public class Phrase {

		Vector<WordParse> Phrase;
		Context context;
		VectorProcessor process;
		SubjectPhrase subjectPhrase;
		ObjectPhrase objectPhrase;
		VerbPhrase verbPhrase;

		public Phrase(Vector<WordParse> Phrase){
			this.Phrase = Phrase;
			process = new VectorProcessor(toString(), this.context);
		}
		
		public String toString(){
			
			String s = "";
			
			for (int i = 0; i<Phrase.size();i++){
				s += Phrase.get(i).getInstance();
			}
			return s;
		}
}
