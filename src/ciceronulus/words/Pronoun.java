package ciceronulus.words;

import java.util.Vector;

public class Pronoun {
	
	
	static Vector<Word> Hic, Ille, Iste, Is, Ipse;
	static Vector<Word> QuiR, QuiI;
	static Vector<Word>Ego, Tu, Nos, Vos, Sui;
	static Vector<Word> all;
	
	String type = "pronoun";
	String nomSing = "nomSing"; String accSing = "accSing"; String genSing = "genSing"; String datSing = "datSing";
		String ablSing = "ablSing"; String vocSing = "vocSing";
	String nomPlur = "nomPlur"; String accPlur = "accPlur"; String genPlur = "genPlur"; String datPlur = "datPlur";
		String ablPlur = "ablPlur"; String vocPlur = "vocPlur";	
		
	String m = "m"; String f = "f"; String n = "n";
		
	public Pronoun(){
	Hic = new Vector();
		createHic();
	}
	public Vector<Word> getPronouns(){
		all = new Vector();
		all.addAll(Hic);

		return all;
	}
	private void createHic(){
		Vector<String> hic0 = new Vector();
		hic0.add(nomSing); hic0.add(m); 
		Hic.add(new Word("hic", type, "", hic0));
		
		Vector<String> hic1 = new Vector();
		hic1.add(nomSing); hic1.add(f); 
		Hic.add(new Word("haec", type, "", hic1));
		
		Vector<String> hic2 = new Vector();
		hic2.add(nomSing); hic2.add(n); 
		Hic.add(new Word("hoc", type, "", hic2));
		
		Vector<String> hic3 = new Vector();
		hic3.add(accSing); hic3.add(m); 
		Hic.add(new Word("hunc", type, "", hic3));
		
		Vector<String> hic4 = new Vector();
		hic4.add(accSing); hic4.add(f); 
		Hic.add(new Word("hanc", type, "", hic4));
		
		Vector<String> hic5 = new Vector();
		hic5.add(accSing); hic5.add(n); 
		Hic.add(new Word("hoc", type, "", hic5));
		
		Vector<String> hic6 = new Vector();
		hic6.add(genSing); hic6.add(m); 
		Hic.add(new Word("huius", type, "", hic6));
		
		Vector<String> hic7 = new Vector();
		hic7.add(genSing); hic7.add(f); 
		Hic.add(new Word("huius", type, "", hic7));
		
		Vector<String> hic8 = new Vector();
		hic8.add(genSing); hic8.add(n); 
		Hic.add(new Word("huius", type, "", hic8));
		
		Vector<String> hic9 = new Vector();
		hic9.add(datSing); hic9.add(m); 
		Hic.add(new Word("huic", type, "", hic9));
		
		Vector<String> hic10 = new Vector();
		hic10.add(datSing); hic10.add(f); 
		Hic.add(new Word("huic", type, "", hic10));
		
		Vector<String> hic11 = new Vector();
		hic11.add(datSing); hic11.add(n); 
		Hic.add(new Word("huic", type, "", hic11));
		
		Vector<String> hic12 = new Vector();
		hic12.add(ablSing); hic12.add(m); 
		Hic.add(new Word("hoc", type, "", hic12));
		
		Vector<String> hic13 = new Vector();
		hic13.add(ablSing); hic13.add(f); 
		Hic.add(new Word("hac", type, "", hic13));
		
		Vector<String> hic14 = new Vector();
		hic14.add(ablSing); hic14.add(n); 
		Hic.add(new Word("hoc", type, "", hic14));
		
		Vector<String> hi0 = new Vector();
		hi0.add(nomPlur); hi0.add(m); 
		Hic.add(new Word("hi", type, "", hi0));
		
		Vector<String> hi1 = new Vector();
		hi1.add(nomPlur); hi1.add(f); 
		Hic.add(new Word("hae", type, "", hi1));
		
		Vector<String> hi2 = new Vector();
		hi2.add(nomPlur); hi2.add(n); 
		Hic.add(new Word("haec", type, "", hi2));
		
		Vector<String> hi3 = new Vector();
		hi3.add(accPlur); hi3.add(m); 
		Hic.add(new Word("hos", type, "", hi3));
		
		Vector<String> hi4 = new Vector();
		hi4.add(accPlur); hi4.add(f); 
		Hic.add(new Word("has", type, "", hi4));
		
		Vector<String> hi5 = new Vector();
		hi5.add(accPlur); hi5.add(n); 
		Hic.add(new Word("haec", type, "", hi5));
		
		Vector<String> hi6 = new Vector();
		hi6.add(genPlur); hi6.add(m); 
		Hic.add(new Word("horum", type, "", hi6));
		
		Vector<String> hi7 = new Vector();
		hi7.add(genPlur); hi7.add(f); 
		Hic.add(new Word("harum", type, "", hi7));
		
		Vector<String> hi8 = new Vector();
		hi8.add(genPlur); hi8.add(n); 
		Hic.add(new Word("horum", type, "", hi8));
		
		Vector<String> hi9 = new Vector();
		hi9.add(datPlur); hi9.add(m); 
		Hic.add(new Word("his", type, "", hi9));
		
		Vector<String> hi10 = new Vector();
		hi10.add(datPlur); hi10.add(f); 
		Hic.add(new Word("his", type, "", hi10));
		
		Vector<String> hi11 = new Vector();
		hi11.add(datPlur); hi11.add(n); 
		Hic.add(new Word("his", type, "", hi11));
		
		Vector<String> hi12 = new Vector();
		hi12.add(ablPlur); hi12.add(m); 
		Hic.add(new Word("his", type, "", hi12));
		
		Vector<String> hi13 = new Vector();
		hi13.add(ablPlur); hi13.add(f); 
		Hic.add(new Word("his", type, "", hi13));
		
		Vector<String> hi14 = new Vector();
		hi14.add(ablPlur); hi14.add(n); 
		Hic.add(new Word("his", type, "", hi14));
		
	}
	
	public Vector<Word> getHic(){
	return Hic;	
	}
	
}
