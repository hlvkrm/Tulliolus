package tulliolus.words.phrases;

import java.util.Vector;

import tulliolus.words.Word;
import tulliolus.words.WordParse;

public class VerbPhrase extends Phrase{

	public VerbPhrase(Vector<WordParse> Phrase){
		super(Phrase);
	}
	
		public Word getMain(){
			
			Word main = Phrase.get(0);//edit later
			return main;
		}
	
		/**
		 * 
		 * @return
		 */
		public Word combine(){
			String instance = "";
			String definition="";
			String note="";
			
			for (int i = 0; i < Phrase.size(); i++){
				Word temp = Phrase.get(i);
				instance+= temp.getInstance().substring(0,2);
				definition += " // "+temp.getDefinition();
				note += " // "+temp.getNote();
			}
			
			Word concat= new Word(instance, "verb", definition, note, ""); 
			
			return concat;
		}

}
