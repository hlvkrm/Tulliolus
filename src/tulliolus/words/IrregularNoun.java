package tulliolus.words;

import java.util.Vector;

public class IrregularNoun {

	static Vector<Word> Deus;
	static Vector<Word> all;
	
	String noun = "noun";
	String nomSing = "nomSing"; String accSing = "accSing"; String genSing = "genSing"; String datSing = "datSing";
		String ablSing = "ablSing"; String vocSing = "vocSing";
	String nomPlur = "nomPlur"; String accPlur = "accPlur"; String genPlur = "genPlur"; String datPlur = "datPlur";
		String ablPlur = "ablPlur"; String vocPlur = "vocPlur";	
		
	String m = "m"; String f = "f"; String n = "n";
		
	
	public IrregularNoun(){
		
		Deus = new Vector<Word>();
		createDeus();
		
	}
	
	public Vector<Word> getIrregularNouns(){
		all = new Vector();
		all.addAll(Deus);

		return all;
	}
	
	
	private void createDeus(){
	
		Vector<String> deus0 = new Vector();
		deus0.add(nomSing); deus0.add(m); 
		Deus.add(new Word("deus", noun, "", deus0));
		
		Vector<String> deus1 = new Vector();
		deus1.add(accSing); deus1.add(m); 
		Deus.add(new Word("deum", noun, "", deus1));
		
		Vector<String> deus2 = new Vector();
		deus2.add(genSing); deus2.add(m); 
		Deus.add(new Word("dei", noun, "", deus2));
		
		Vector<String> deus3 = new Vector();
		deus3.add(datSing); deus3.add(m); 
		Deus.add(new Word("deo", noun, "", deus3));
		
		Vector<String> deus4 = new Vector();
		deus4.add(ablSing); deus4.add(m); 
		Deus.add(new Word("deo", noun, "", deus4));
		
		Vector<String> deus5 = new Vector();
		deus5.add(vocSing); deus5.add(m); 
		Deus.add(new Word("deus", noun, "", deus5));
		
		Vector<String> deus6 = new Vector();
		deus6.add(vocSing); deus6.add(m); 
		Deus.add(new Word("dive", noun, "", deus6));
	}
	
	public Vector getDeus(){
		return Deus;
	}

}
