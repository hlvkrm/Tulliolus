package tulliolus.words;

import java.util.Vector;

import tulliolus.main.Creator;
import android.database.sqlite.SQLiteDatabase;
/**An object created by EITHER the abstraction of a stem + ending combination from paradigm.db, 
 * OR hard-coded generations from the <i>tulliolus.words.generate</i> package. Includes all the parse and reference information
 * from the database.
 * @param 
 * String instance <i>(i.e. specfic declension/conjugation of a word (e.g. hominem, hominibus, amet))</i><br>
 * <b>String</b> category <i>(e.g. noun, verb, pronoun, etc.)</i><br>
 * <b>String</b> definition<br>
 * <b>String</b> note <i>(used as a catch-all component for any specific structural notes (e.g. transivity, postpositivity))</i><br>
 * <b>Vector<String></b> Parse || <b>String</b> ParseString
 *
 */
public class Word {
	
		String instance;
		String category;
		String note;
		Vector<String> Parse;
		String parseString;
		String definition;
		
		public Word (String instance, String category, String definition, String note, Vector<String> Parse){
				this.instance = instance;
				this.category = category;
				this.definition = definition;
				this.note = note;
				this.Parse = Parse;
		
			}
		
		public Word (String instance, String category, String definition, String note, String parseString){
			this.instance = instance;
			this.category = category;
			this.definition = definition;
			this.note = note;
			this.parseString = parseString;
		
		}
		public Word (){}
		
		public String getInstance(){
			
			return instance;
		}
		
		public String getCategory(){
			
			return category;
		}
		
		public String getDefinition(){
			
			return definition;
		}
		
		public String getNote(){
			
			return note;
		}
		
		public Vector<String> getParse(){
			
			return Parse;
		}
		/**Returns a string of the word in the following format:
		 * [instance / category / note /parseString]
		 * @return String
		 */
		public String toString(){
			
			if (Parse==null){
				return parseString;
			}
			else{
			return "["+instance+" / "+category+" / "+note+" /"+ parseString()+"]";
			}
		}
		/**
		 * Takes the Parse vector and renders it into a parse string. 
		 * Accounts for cases where the parse of a word is in the form of a vector.
		 * @return String
		 */
		public String parseString(){
			
			if (Parse!=null)
			{
				int count = 0;
				String parseStr ="";
				while (count<Parse.size()){
				parseStr += " " + Parse.get(count);
				count++;
			}
			
				return parseStr;
				}
			
			else {return toString();}
		}
		/**
		 * Takes the person of a Word from an int value to an ordinal value; the person is always
		 * located in the Parse vector as the 4th [index 3] entry:
		 * <br>
		 * 1 = first person; returns "first"<br>
		 * 2 = second person; returns "second"<br>
		 * 3 = third person; returns "third"
		 * @return String
		 */
		private String personToOrdinal(){
			
			String person = Parse.get(3);
			String ordinal = "";
			if(person.equals("1")){
				ordinal = "first";
			}
			if(person.equals("2")){
				ordinal = "second";
			}
			if(person.equals("3")){
				ordinal = "third";
		}
			
			return ordinal;
		}
		public String getOrderedParseValues(){
			String prologParse="";
			
			//NOUN: declension,number,gender,NOUN
			if (category.equals("noun")){
				prologParse = (Parse.get(0))
						+ (Parse.get(1).toUpperCase())
						+"Noun";
			}
			
			//PRONOUN: declension,number,gender,NOUN
				if (category.equals("pronoun")){
					prologParse = (Parse.get(0))
							+ (Parse.get(1).toUpperCase())
							+"Pronoun";
				}
				
				//VERB: person, number, VERB
			if (category.equals("verb")){
				prologParse = (personToOrdinal())
						+ (Parse.get(4).substring(0, 1).toUpperCase() + Parse.get(4).substring(1))
						+"Verb";
			}
			return prologParse;
			
			
		}
}
