package ciceronulus.words;

public class Verb extends Word{

	String pp1;
	String pp2;
	String pp3; 
	String pp4; 
	String stemPresent;
	String stemPerfect;
	String stemSupine;
	int conjugation;
	String note;
	
	public Verb (String pp1, String pp2, String pp3, String pp4, 
						String stemPresent, String stemPerfect, String stemSupine,
						int conjugation, String note){
		
		this.pp1 = pp1;
		this.pp2 = pp2;
		this.pp3 = pp3;
		this.pp4 = pp4;
		this.stemPresent = stemPresent;
		this.stemPerfect = stemPerfect;
		this.stemSupine = stemSupine;
		this.conjugation = conjugation;
		this.note = note;
		
	}
	
	public Verb (){}
	
	public int getTableIndex(int conjugation, int conjugationValue){
		//conjugationValue:
		//		1s = 1		1p = 4	
		//		2s = 2		2p = 5
		//		3s = 3		3p = 6
		
		int i = (conjugationValue*4)-(4-conjugation);
			//nota bene: 4 because there are 4 different conjugations
		
		return i;
		
	}
}
