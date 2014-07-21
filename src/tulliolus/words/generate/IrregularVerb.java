package tulliolus.words.generate;

import java.util.Vector;
import java.util.Collection;

import tulliolus.words.Word;
import android.util.Log;

public class IrregularVerb {

	String TAG = "irregular verbing";
	
	String presentStem,perfectStem,supineStem;
	String pp1, pp2, pp3, pp4;
	String note;
	boolean transitive;
	static Vector<Word> Esse, Posse, Ire, Ferri, Fieri;
	static Vector<Word> all;
	
	String verb = "verb";
	String esse = "esse";
	String first = "first"; String second = "second"; String third = "third";
	String sing = "sing"; String plur = "plur";
	String act = "act"; String pass = "pass";
	String ind = "ind"; String subj = "subj"; String imp = "imp"; String inf = "inf";
	String pres = "pres"; String fut = "fut"; String imperf = "imperf";
	String perf = "perf"; String pluperf = "pluperf"; String perfFut = "perfFut";
	
	
	/*
	public IrregularVerb(String presentStem, String perfectStem, String supineStem,
			String pp1, String pp2, String pp3, String pp4, String note, boolean transitive){
		
		this.presentStem = presentStem;
		this.perfectStem = perfectStem;
		this.supineStem = supineStem;
		this.pp1 = pp1;
		this.pp2 = pp2;
		this.pp3 = pp3;
		this.pp4 = pp4;
		this.note = note;
		this.transitive = transitive;
		
	}*/
	public IrregularVerb(){
		Esse = new Vector();
		Posse =  new Vector();
		Ire =  new Vector();
		Ferri =  new Vector();
		Fieri =  new Vector();
		
		createEsse();
		createPosse();
	}
	
	public Vector getIrregularVerbs(){
		all = new Vector();
		all.addAll(Esse);
		all.addAll(Posse);
		
		return all;
	}
	
	private void createEsse(){
	
		///actIndPres
		Vector<String> esse0 = new Vector();
		esse0.add("act"); esse0.add(ind); esse0.add(pres); esse0.add(first); esse0.add(sing);
		Esse.add(new Word("sum", verb, null, esse, esse0));

		Vector<String> esse1 = new Vector();
		esse1.add("act"); esse1.add(ind); esse1.add(pres); esse1.add(second); esse1.add(sing);
		Esse.add(new Word("es", verb, null, esse, esse1));

		Vector<String> esse2 = new Vector();
		esse2.add("act"); esse2.add(ind); esse2.add(pres); esse2.add(third); esse2.add(sing);
		Esse.add(new Word("est", verb, null, esse, esse2));

		Vector<String> esse3 = new Vector();
		esse3.add("act"); esse3.add(ind); esse3.add(pres); esse3.add(first); esse3.add(plur);
		Esse.add(new Word("sumus", verb, null, esse, esse3));

		Vector<String> esse4 = new Vector();
		esse4.add("act"); esse4.add(ind); esse4.add(pres); esse4.add(second); esse4.add(plur);
		Esse.add(new Word("estis", verb, null, esse, esse4));
		
		Vector<String> esse5 = new Vector();
		esse5.add("act"); esse5.add(ind); esse5.add(pres); esse5.add(third); esse5.add(plur);
		Esse.add(new Word("sunt", verb, null, esse, esse5));
		
		
		///actIndImperf
		Vector<String> esse6 = new Vector();
		esse6.add("act"); esse6.add(ind); esse6.add(imperf); esse6.add(first); esse6.add(sing);
		Esse.add(new Word("eram", verb, null, esse, esse6));

		Vector<String> esse7 = new Vector();
		esse7.add("act"); esse7.add(ind); esse7.add(imperf); esse7.add(second); esse7.add(sing);
		Esse.add(new Word("eras", verb, null, esse, esse7));

		Vector<String> esse8 = new Vector();
		esse8.add("act"); esse8.add(ind); esse8.add(imperf); esse8.add(third); esse8.add(sing);
		Esse.add(new Word("erat", verb, null, esse, esse8));

		Vector<String> esse9 = new Vector();
		esse9.add("act"); esse9.add(ind); esse9.add(imperf); esse9.add(first); esse9.add(plur);
		Esse.add(new Word("eramus", verb, null, esse, esse9));

		Vector<String> esse10 = new Vector();
		esse10.add("act"); esse10.add(ind); esse10.add(imperf); esse10.add(second); esse10.add(plur);
		Esse.add(new Word("eratis", verb, null, esse, esse10));
		
		Vector<String> esse11 = new Vector();
		esse11.add("act"); esse11.add(ind); esse11.add(imperf); esse11.add(third); esse11.add(plur);
		Esse.add(new Word("erant", verb, null, esse, esse11));
		
		
		
		///actIndFut
		
		Vector<String> esse12 = new Vector();
		esse12.add(act); esse12.add(ind); esse12.add(fut); esse12.add(first); esse12.add(sing);
		Esse.add(new Word("ero", verb, null, esse, esse12));

		Vector<String> esse13 = new Vector();
		esse13.add("act"); esse13.add(ind); esse13.add(fut); esse13.add(second); esse13.add(sing);
		Esse.add(new Word("eris", verb, null, esse, esse13));

		Vector<String> esse14 = new Vector();
		esse14.add("act"); esse14.add(ind); esse14.add(fut); esse14.add(third); esse14.add(sing);
		Esse.add(new Word("erit", verb, null, esse, esse14));

		Vector<String> esse15 = new Vector();
		esse15.add("act"); esse15.add(ind); esse15.add(fut); esse15.add(first); esse15.add(plur);
		Esse.add(new Word("erimus", verb, null, esse, esse15));

		Vector<String> esse16 = new Vector();
		esse16.add("act"); esse16.add(ind); esse16.add(fut); esse16.add(second); esse16.add(plur);
		Esse.add(new Word("eritis", verb, null, esse, esse16));
		
		Vector<String> esse17 = new Vector();
		esse17.add("act"); esse17.add(ind); esse17.add(fut); esse17.add(third); esse17.add(plur);
		Esse.add(new Word("erint", verb, null, esse, esse17));
		
		
		///actIndPerf
		Vector<String> esse18 = new Vector();
		esse18.add(act); esse18.add(ind); esse18.add(perf); esse18.add(first); esse18.add(sing);
		Esse.add(new Word("fui", verb, null, esse, esse18));

		Vector<String> esse19 = new Vector();
		esse19.add(act); esse19.add(ind); esse19.add(perf); esse19.add(second); esse19.add(sing);
		Esse.add(new Word("fuisti", verb, null, esse, esse19));

		Vector<String> esse20 = new Vector();
		esse20.add(act); esse20.add(ind); esse20.add(perf); esse20.add(third); esse20.add(sing);
		Esse.add(new Word("fuit", verb, null, esse, esse20));

		Vector<String> esse21 = new Vector();
		esse21.add(act); esse21.add(ind); esse21.add(perf); esse21.add(first); esse21.add(plur);
		Esse.add(new Word("fuimus", verb, null, esse, esse21));

		Vector<String> esse22 = new Vector();
		esse22.add(act); esse22.add(ind); esse22.add(perf); esse22.add(second); esse22.add(plur);
		Esse.add(new Word("fuistis", verb, null, esse, esse22));
		
		Vector<String> esse23 = new Vector();
		esse23.add(act); esse23.add(ind); esse23.add(perf); esse23.add(third); esse23.add(plur);
		Esse.add(new Word("fuerunt", verb, null, esse, esse23));
		
		
		
		///actIndPerfFut
		
		Vector<String> esse24 = new Vector();
		esse24.add(act); esse24.add(ind); esse24.add(perfFut); esse24.add(first); esse24.add(sing);
		Esse.add(new Word("fuero", verb, null, esse, esse24));

		Vector<String> esse25 = new Vector();
		esse25.add(act); esse25.add(ind); esse25.add(perfFut); esse25.add(second); esse25.add(sing);
		Esse.add(new Word("fueris", verb, null, esse, esse25));

		Vector<String> esse26 = new Vector();
		esse26.add(act); esse26.add(ind); esse26.add(perfFut); esse26.add(third); esse26.add(sing);
		Esse.add(new Word("fuerit", verb, null, esse, esse26));

		Vector<String> esse27 = new Vector();
		esse27.add(act); esse27.add(ind); esse27.add(perfFut); esse27.add(first); esse27.add(plur);
		Esse.add(new Word("fuerimus", verb, null, esse, esse27));

		Vector<String> esse28 = new Vector();
		esse28.add(act); esse28.add(ind); esse28.add(perfFut); esse28.add(second); esse28.add(plur);
		Esse.add(new Word("fueritis", verb, null, esse, esse28));
		
		Vector<String> esse29 = new Vector();
		esse29.add(act); esse29.add(ind); esse29.add(perfFut); esse29.add(third); esse29.add(plur);
		Esse.add(new Word("fuerint", verb, null, esse, esse29));
		
		
		///actIndPluperf
		
		Vector<String> esse30 = new Vector();
		esse30.add(act); esse30.add(ind); esse30.add(pluperf); esse30.add(first); esse30.add(sing);
		Esse.add(new Word("fueram", verb, null, esse, esse30));

		Vector<String> esse31 = new Vector();
		esse31.add(act); esse31.add(ind); esse31.add(pluperf); esse31.add(second); esse31.add(sing);
		Esse.add(new Word("fueras", verb, null, esse, esse31));

		Vector<String> esse32 = new Vector();
		esse32.add(act); esse32.add(ind); esse32.add(pluperf); esse32.add(third); esse32.add(sing);
		Esse.add(new Word("fuerat", verb, null, esse, esse32));

		Vector<String> esse33 = new Vector();
		esse33.add(act); esse33.add(ind); esse33.add(pluperf); esse33.add(first); esse33.add(plur);
		Esse.add(new Word("fueramus", verb, null, esse, esse33));

		Vector<String> esse34 = new Vector();
		esse34.add(act); esse34.add(ind); esse34.add(pluperf); esse34.add(second); esse34.add(plur);
		Esse.add(new Word("fueratis", verb, null, esse, esse34));
		
		Vector<String> esse35 = new Vector();
		esse35.add(act); esse35.add(ind); esse35.add(pluperf); esse35.add(third); esse35.add(plur);
		Esse.add(new Word("fuerant", verb, null, esse, esse35));
		
		
		///ActSubjImperf
		
		Vector<String> esse36 = new Vector();
		esse36.add(act); esse36.add(subj); esse36.add(imperf); esse36.add(first); esse36.add(sing);
		Esse.add(new Word("essem", verb, null, esse, esse36));

		Vector<String> esse37 = new Vector();
		esse37.add(act); esse37.add(subj); esse37.add(imperf); esse37.add(second); esse37.add(sing);
		Esse.add(new Word("esses", verb, null, esse, esse37));

		Vector<String> esse38 = new Vector();
		esse38.add(act); esse38.add(subj); esse38.add(imperf); esse38.add(third); esse38.add(sing);
		Esse.add(new Word("esset", verb, null, esse, esse38));

		Vector<String> esse39 = new Vector();
		esse39.add(act); esse39.add(subj); esse39.add(imperf); esse39.add(first); esse39.add(plur);
		Esse.add(new Word("essemus", verb, null, esse, esse39));

		Vector<String> esse40 = new Vector();
		esse40.add(act); esse40.add(subj); esse40.add(imperf); esse40.add(second); esse40.add(plur);
		Esse.add(new Word("essetis", verb, null, esse, esse40));
		
		Vector<String> esse41 = new Vector();
		esse41.add(act); esse41.add(subj); esse41.add(imperf); esse41.add(third); esse41.add(plur);
		Esse.add(new Word("essent", verb, null, esse, esse41));
		
		
		///ActSubjPerf
		Vector<String> esse42 = new Vector();
		esse42.add(act); esse42.add(subj); esse42.add(perf); esse42.add(first); esse42.add(sing);
		Esse.add(new Word("fuerim", verb, null, esse, esse42));

		Vector<String> esse43 = new Vector();
		esse43.add(act); esse43.add(subj); esse43.add(perf); esse43.add(second); esse43.add(sing);
		Esse.add(new Word("fueris", verb, null, esse, esse43));

		Vector<String> esse44 = new Vector();
		esse44.add(act); esse44.add(subj); esse44.add(perf); esse44.add(third); esse44.add(sing);
		Esse.add(new Word("fuerit", verb, null, esse, esse44));

		Vector<String> esse45 = new Vector();
		esse45.add(act); esse45.add(subj); esse45.add(perf); esse45.add(first); esse45.add(plur);
		Esse.add(new Word("fuerimus", verb, null, esse, esse45));

		Vector<String> esse46 = new Vector();
		esse46.add(act); esse46.add(subj); esse46.add(perf); esse46.add(second); esse46.add(plur);
		Esse.add(new Word("fueritis", verb, null, esse, esse46));
		
		Vector<String> esse47 = new Vector();
		esse47.add(act); esse47.add(subj); esse47.add(perf); esse47.add(third); esse47.add(plur); 
		Esse.add(new Word("fuerint", verb, null, esse, esse47));
		
		///ActIndSubjPluperf
		Vector<String> esse48 = new Vector();
		esse48.add(act); esse48.add(subj); esse48.add(pluperf); esse48.add(first); esse48.add(sing);
		Esse.add(new Word("fuissem", verb, null, esse, esse48));

		Vector<String> esse49 = new Vector();
		esse49.add(act); esse49.add(subj); esse49.add(pluperf); esse49.add(second); esse49.add(sing);
		Esse.add(new Word("fuisses", verb, null, esse, esse49));

		Vector<String> esse50 = new Vector();
		esse50.add(act); esse50.add(subj); esse50.add(pluperf); esse50.add(third); esse50.add(sing);
		Esse.add(new Word("fuisset", verb, null, esse, esse50));

		Vector<String> esse51 = new Vector();
		esse51.add(act); esse51.add(subj); esse51.add(pluperf); esse51.add(first); esse51.add(plur);
		Esse.add(new Word("fuissemus", verb, null, esse, esse51));

		Vector<String> esse52 = new Vector();
		esse52.add(act); esse52.add(subj); esse52.add(pluperf); esse52.add(second); esse52.add(plur);
		Esse.add(new Word("fuissetis", verb, null, esse, esse52));
		
		Vector<String> esse53 = new Vector();
		esse53.add(act); esse53.add(subj); esse53.add(pluperf); esse53.add(third); esse53.add(plur);
		Esse.add(new Word("fuissent", verb, null, esse, esse53));
		
		
		
		///ActIndSubjPres
		Vector<String> esse54 = new Vector();
		esse54.add(act); esse54.add(subj); esse54.add(pres); esse54.add(first); esse54.add(sing);
		Esse.add(new Word("sim", verb, null, esse, esse54));

		Vector<String> esse55 = new Vector();
		esse55.add(act); esse55.add(subj); esse55.add(pres); esse55.add(second); esse55.add(sing);
		Esse.add(new Word("sis", verb, null, esse, esse55));

		Vector<String> esse56 = new Vector();
		esse56.add(act); esse56.add(subj); esse56.add(pres); esse56.add(third); esse56.add(sing);
		Esse.add(new Word("sit", verb, null, esse, esse56));

		Vector<String> esse57 = new Vector();
		esse57.add(act); esse57.add(subj); esse57.add(pres); esse57.add(first); esse57.add(plur);
		Esse.add(new Word("simus", verb, null, esse, esse57));

		Vector<String> esse58 = new Vector();
		esse58.add(act); esse58.add(subj); esse58.add(pres); esse58.add(second); esse58.add(plur);
		Esse.add(new Word("sitis", verb, null, esse, esse58));
		
		Vector<String> esse59 = new Vector();
		esse59.add(act); esse59.add(subj); esse59.add(pres); esse59.add(third); esse59.add(plur);
		Esse.add(new Word("sint", verb, null, esse, esse59));
		
		
		///ActImpFut
		Vector<String> esse60 = new Vector();
		esse60.add(act); esse60.add(imp); esse60.add(fut); esse60.add(second); esse60.add(sing);
		Esse.add(new Word("esto", verb, null, esse, esse60));

		Vector<String> esse61 = new Vector();
		esse61.add(act); esse61.add(imp); esse61.add(fut); esse61.add(third); esse61.add(sing);
		Esse.add(new Word("esto", verb, null, esse, esse61));

		Vector<String> esse62 = new Vector();
		esse62.add(act); esse62.add(imp); esse62.add(fut); esse62.add(second); esse62.add(plur);
		Esse.add(new Word("estote", verb, null, esse, esse62));
		
		Vector<String> esse63 = new Vector();
		esse63.add(act); esse63.add(imp); esse63.add(fut); esse63.add(third); esse63.add(plur);
		Esse.add(new Word("sunto", verb, null, esse, esse63));
		
		///ActImpPres
		Vector<String> esse64 = new Vector();
		esse64.add(act); esse64.add(imp); esse64.add(pres); esse64.add(second); esse64.add(sing);
		Esse.add(new Word("es", verb, null, esse, esse64));

		Vector<String> esse65 = new Vector();
		esse65.add(act); esse65.add(imp); esse65.add(pres); esse65.add(second); esse65.add(sing);
		Esse.add(new Word("este", verb, null, esse, esse65));
		
		
		///ActInfPerf
		Vector<String> esse66 = new Vector();
		esse66.add(act); esse66.add(inf); esse66.add(perf); 
		Esse.add(new Word("fuisse", verb, null, esse, esse66));

		
		///ActInfPres
		
		Vector<String> esse67 = new Vector();
		esse67.add(act); esse67.add(inf); esse67.add(pres); 
		Esse.add(new Word("esse", verb, null, esse, esse67));

	
	}
	public Vector<Word> getEsse(){
		return Esse;
	}
	
	private void createPosse(){
		///actIndPres
		Vector<String> posse0 = new Vector();
		posse0.add("act"); posse0.add(ind); posse0.add(pres); posse0.add(first); posse0.add(sing);
		Posse.add(new Word("possum", verb, null, "", posse0));

		Vector<String> posse1 = new Vector();
		posse1.add("act"); posse1.add(ind); posse1.add(pres); posse1.add(second); posse1.add(sing);
		Posse.add(new Word("potes", verb, null, "", posse1));

		Vector<String> posse2 = new Vector();
		posse2.add("act"); posse2.add(ind); posse2.add(pres); posse2.add(third); posse2.add(sing);
		Posse.add(new Word("potest", verb, null, "", posse2));

		Vector<String> posse3 = new Vector();
		posse3.add("act"); posse3.add(ind); posse3.add(pres); posse3.add(first); posse3.add(plur);
		Posse.add(new Word("possumus", verb, null, "", posse3));

		Vector<String> posse4 = new Vector();
		posse4.add("act"); posse4.add(ind); posse4.add(pres); posse4.add(second); posse4.add(plur);
		Posse.add(new Word("potestis", verb, null, "", posse4));
		
		Vector<String> posse5 = new Vector();
		posse5.add("act"); posse5.add(ind); posse5.add(pres); posse5.add(third); posse5.add(plur);
		Posse.add(new Word("possunt", verb, null, "", posse5));
		
		
		///actIndImperf
		Vector<String> posse6 = new Vector();
		posse6.add("act"); posse6.add(ind); posse6.add(imperf); posse6.add(first); posse6.add(sing);
		Posse.add(new Word("poteram", verb, null, "", posse6));

		Vector<String> posse7 = new Vector();
		posse7.add("act"); posse7.add(ind); posse7.add(imperf); posse7.add(second); posse7.add(sing);
		Posse.add(new Word("poteras", verb, null, "", posse7));

		Vector<String> posse8 = new Vector();
		posse8.add("act"); posse8.add(ind); posse8.add(imperf); posse8.add(third); posse8.add(sing);
		Posse.add(new Word("poterat", verb, null, "", posse8));

		Vector<String> posse9 = new Vector();
		posse9.add("act"); posse9.add(ind); posse9.add(imperf); posse9.add(first); posse9.add(plur);
		Posse.add(new Word("poteramus", verb, null, "", posse9));

		Vector<String> posse10 = new Vector();
		posse10.add("act"); posse10.add(ind); posse10.add(imperf); posse10.add(second); posse10.add(plur);
		Posse.add(new Word("poteratis", verb, null, "", posse10));
		
		Vector<String> posse11 = new Vector();
		posse11.add("act"); posse11.add(ind); posse11.add(imperf); posse11.add(third); posse11.add(plur);
		Posse.add(new Word("poterant", verb, null, "", posse11));
		
		
		
		///actIndFut
		
		Vector<String> posse12 = new Vector();
		posse12.add(act); posse12.add(ind); posse12.add(fut); posse12.add(first); posse12.add(sing);
		Posse.add(new Word("potero", verb, null, "", posse12));

		Vector<String> posse13 = new Vector();
		posse13.add("act"); posse13.add(ind); posse13.add(fut); posse13.add(second); posse13.add(sing);
		Posse.add(new Word("poteris", verb, null, "", posse13));

		Vector<String> posse14 = new Vector();
		posse14.add("act"); posse14.add(ind); posse14.add(fut); posse14.add(third); posse14.add(sing);
		Posse.add(new Word("poterit", verb, null, "", posse14));

		Vector<String> posse15 = new Vector();
		posse15.add("act"); posse15.add(ind); posse15.add(fut); posse15.add(first); posse15.add(plur);
		Posse.add(new Word("poterimus", verb, null, "", posse15));

		Vector<String> posse16 = new Vector();
		posse16.add("act"); posse16.add(ind); posse16.add(fut); posse16.add(second); posse16.add(plur);
		Posse.add(new Word("poteritis", verb, null, "", posse16));
		
		Vector<String> posse17 = new Vector();
		posse17.add("act"); posse17.add(ind); posse17.add(fut); posse17.add(third); posse17.add(plur);
		Posse.add(new Word("poterint", verb, null, "", posse17));
		
		
		///actIndPerf
		Vector<String> posse18 = new Vector();
		posse18.add(act); posse18.add(ind); posse18.add(perf); posse18.add(first); posse18.add(sing);
		Posse.add(new Word("potui", verb, null, "", posse18));

		Vector<String> posse19 = new Vector();
		posse19.add(act); posse19.add(ind); posse19.add(perf); posse19.add(second); posse19.add(sing);
		Posse.add(new Word("potuisti", verb, null, "", posse19));

		Vector<String> posse20 = new Vector();
		posse20.add(act); posse20.add(ind); posse20.add(perf); posse20.add(third); posse20.add(sing);
		Posse.add(new Word("potuit", verb, null, "", posse20));

		Vector<String> posse21 = new Vector();
		posse21.add(act); posse21.add(ind); posse21.add(perf); posse21.add(first); posse21.add(plur);
		Posse.add(new Word("potuimus", verb, null, "", posse21));

		Vector<String> posse22 = new Vector();
		posse22.add(act); posse22.add(ind); posse22.add(perf); posse22.add(second); posse22.add(plur);
		Posse.add(new Word("potuistis", verb, null, "", posse22));
		
		Vector<String> posse23 = new Vector();
		posse23.add(act); posse23.add(ind); posse23.add(perf); posse23.add(third); posse23.add(plur);
		Posse.add(new Word("potuerunt", verb, null, "", posse23));
		
		
		
		///actIndPerfFut
		
		Vector<String> posse24 = new Vector();
		posse24.add(act); posse24.add(ind); posse24.add(perfFut); posse24.add(first); posse24.add(sing);
		Posse.add(new Word("potuero", verb, null, "", posse24));

		Vector<String> posse25 = new Vector();
		posse25.add(act); posse25.add(ind); posse25.add(perfFut); posse25.add(second); posse25.add(sing);
		Posse.add(new Word("potueris", verb, null, "", posse25));

		Vector<String> posse26 = new Vector();
		posse26.add(act); posse26.add(ind); posse26.add(perfFut); posse26.add(third); posse26.add(sing);
		Posse.add(new Word("potuerit", verb, null, "", posse26));

		Vector<String> posse27 = new Vector();
		posse27.add(act); posse27.add(ind); posse27.add(perfFut); posse27.add(first); posse27.add(plur);
		Posse.add(new Word("potuerimus", verb, null, "", posse27));

		Vector<String> posse28 = new Vector();
		posse28.add(act); posse28.add(ind); posse28.add(perfFut); posse28.add(second); posse28.add(plur);
		Posse.add(new Word("potueritis", verb, null, "", posse28));
		
		Vector<String> posse29 = new Vector();
		posse29.add(act); posse29.add(ind); posse29.add(perfFut); posse29.add(third); posse29.add(plur);
		Posse.add(new Word("potuerint", verb, null, "", posse29));
		
		
		///actIndPluperf
		
		Vector<String> posse30 = new Vector();
		posse30.add(act); posse30.add(ind); posse30.add(pluperf); posse30.add(first); posse30.add(sing);
		Posse.add(new Word("potueram", verb, null, "", posse30));

		Vector<String> posse31 = new Vector();
		posse31.add(act); posse31.add(ind); posse31.add(pluperf); posse31.add(second); posse31.add(sing);
		Posse.add(new Word("potueras", verb, null, "", posse31));

		Vector<String> posse32 = new Vector();
		posse32.add(act); posse32.add(ind); posse32.add(pluperf); posse32.add(third); posse32.add(sing);
		Posse.add(new Word("potuerat", verb, null, "", posse32));

		Vector<String> posse33 = new Vector();
		posse33.add(act); posse33.add(ind); posse33.add(pluperf); posse33.add(first); posse33.add(plur);
		Posse.add(new Word("potueramus", verb, null, "", posse33));

		Vector<String> posse34 = new Vector();
		posse34.add(act); posse34.add(ind); posse34.add(pluperf); posse34.add(second); posse34.add(plur);
		Posse.add(new Word("potueratis", verb, null, "", posse34));
		
		Vector<String> posse35 = new Vector();
		posse35.add(act); posse35.add(ind); posse35.add(pluperf); posse35.add(third); posse35.add(plur);
		Posse.add(new Word("potuerant", verb, null, "", posse35));
		
		
		///ActSubjImperf
		
		Vector<String> posse36 = new Vector();
		posse36.add(act); posse36.add(subj); posse36.add(imperf); posse36.add(first); posse36.add(sing);
		Posse.add(new Word("possem", verb, null, "", posse36));

		Vector<String> posse37 = new Vector();
		posse37.add(act); posse37.add(subj); posse37.add(imperf); posse37.add(second); posse37.add(sing);
		Posse.add(new Word("posses", verb, null, "", posse37));

		Vector<String> posse38 = new Vector();
		posse38.add(act); posse38.add(subj); posse38.add(imperf); posse38.add(third); posse38.add(sing);
		Posse.add(new Word("posset", verb, null, "", posse38));

		Vector<String> posse39 = new Vector();
		posse39.add(act); posse39.add(subj); posse39.add(imperf); posse39.add(first); posse39.add(plur);
		Posse.add(new Word("possemus", verb, null, "", posse39));

		Vector<String> posse40 = new Vector();
		posse40.add(act); posse40.add(subj); posse40.add(imperf); posse40.add(second); posse40.add(plur);
		Posse.add(new Word("possetis", verb, null, "", posse40));
		
		Vector<String> posse41 = new Vector();
		posse41.add(act); posse41.add(subj); posse41.add(imperf); posse41.add(third); posse41.add(plur);
		Posse.add(new Word("possent", verb, null, "", posse41));
		
		
		///ActSubjPerf
		Vector<String> posse42 = new Vector();
		posse42.add(act); posse42.add(subj); posse42.add(perf); posse42.add(first); posse42.add(sing);
		Posse.add(new Word("potuerim", verb, null, "", posse42));

		Vector<String> posse43 = new Vector();
		posse43.add(act); posse43.add(subj); posse43.add(perf); posse43.add(second); posse43.add(sing);
		Posse.add(new Word("potueris", verb, null, "", posse43));

		Vector<String> posse44 = new Vector();
		posse44.add(act); posse44.add(subj); posse44.add(perf); posse44.add(third); posse44.add(sing);
		Posse.add(new Word("potuerit", verb, null, "", posse44));

		Vector<String> posse45 = new Vector();
		posse45.add(act); posse45.add(subj); posse45.add(perf); posse45.add(first); posse45.add(plur);
		Posse.add(new Word("potuerimus", verb, null, "", posse45));

		Vector<String> posse46 = new Vector();
		posse46.add(act); posse46.add(subj); posse46.add(perf); posse46.add(second); posse46.add(plur);
		Posse.add(new Word("potueritis", verb, null, "", posse46));
		
		Vector<String> posse47 = new Vector();
		posse47.add(act); posse47.add(subj); posse47.add(perf); posse47.add(third); posse47.add(plur); 
		Posse.add(new Word("potuerint", verb, null, "", posse47));
		
		///ActIndSubjPluperf
		Vector<String> posse48 = new Vector();
		posse48.add(act); posse48.add(subj); posse48.add(pluperf); posse48.add(first); posse48.add(sing);
		Posse.add(new Word("potuissem", verb, null, "", posse48));

		Vector<String> posse49 = new Vector();
		posse49.add(act); posse49.add(subj); posse49.add(pluperf); posse49.add(second); posse49.add(sing);
		Posse.add(new Word("potuisses", verb, null, "", posse49));

		Vector<String> posse50 = new Vector();
		posse50.add(act); posse50.add(subj); posse50.add(pluperf); posse50.add(third); posse50.add(sing);
		Posse.add(new Word("potuisset", verb, null, "", posse50));

		Vector<String> posse51 = new Vector();
		posse51.add(act); posse51.add(subj); posse51.add(pluperf); posse51.add(first); posse51.add(plur);
		Posse.add(new Word("potuissemus", verb, null, "", posse51));

		Vector<String> posse52 = new Vector();
		posse52.add(act); posse52.add(subj); posse52.add(pluperf); posse52.add(second); posse52.add(plur);
		Posse.add(new Word("potuissetis", verb, null, "", posse52));
		
		Vector<String> posse53 = new Vector();
		posse53.add(act); posse53.add(subj); posse53.add(pluperf); posse53.add(third); posse53.add(plur);
		Posse.add(new Word("potuissent", verb, null, "", posse53));
		
		
		
		///ActIndSubjPres
		Vector<String> posse54 = new Vector();
		posse54.add(act); posse54.add(subj); posse54.add(pres); posse54.add(first); posse54.add(sing);
		Posse.add(new Word("possim", verb, null, "", posse54));

		Vector<String> posse55 = new Vector();
		posse55.add(act); posse55.add(subj); posse55.add(pres); posse55.add(second); posse55.add(sing);
		Posse.add(new Word("possis", verb, null, "", posse55));

		Vector<String> posse56 = new Vector();
		posse56.add(act); posse56.add(subj); posse56.add(pres); posse56.add(third); posse56.add(sing);
		Posse.add(new Word("possit", verb, null, "", posse56));

		Vector<String> posse57 = new Vector();
		posse57.add(act); posse57.add(subj); posse57.add(pres); posse57.add(first); posse57.add(plur);
		Posse.add(new Word("possimus", verb, null, "", posse57));

		Vector<String> posse58 = new Vector();
		posse58.add(act); posse58.add(subj); posse58.add(pres); posse58.add(second); posse58.add(plur);
		Posse.add(new Word("possitis", verb, null, "", posse58));
		
		Vector<String> posse59 = new Vector();
		posse59.add(act); posse59.add(subj); posse59.add(pres); posse59.add(third); posse59.add(plur);
		Posse.add(new Word("possint", verb, null, "", posse59));
		
		
		///ActImpFut///ActImpPres
			//NO IMPERATIVES?
		
		
		///ActInfPerf
		Vector<String> posse66 = new Vector();
		posse66.add(act); posse66.add(inf); posse66.add(perf); 
		Posse.add(new Word("potuisse", verb, null, "", posse66));

		
		///ActInfPres
		
		Vector<String> posse67 = new Vector();
		posse67.add(act); posse67.add(inf); posse67.add(pres); 
		Posse.add(new Word("posse", verb, null, "", posse67));
	}
	
	public Vector<Word> getPosse(){
		return Posse;
	}
}
