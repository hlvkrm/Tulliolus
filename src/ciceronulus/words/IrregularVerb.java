package ciceronulus.words;

import java.util.ArrayList;
import java.util.Collection;

import android.util.Log;

public class IrregularVerb {

	String TAG = "irregular verbing";
	
	String presentStem,perfectStem,supineStem;
	String pp1, pp2, pp3, pp4;
	String note;
	boolean transitive;
	static ArrayList<Word> Esse, Posse, Ire, Ferri, Fieri;
	static ArrayList<Word> all;
	
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
		Esse = new ArrayList();
		Posse =  new ArrayList();
		Ire =  new ArrayList();
		Ferri =  new ArrayList();
		Fieri =  new ArrayList();
	
	
		
		
		createEsse();
		createPosse();
	}
	
	public ArrayList getIrregularVerbs(){
		all = new ArrayList();
		all.addAll(Esse);
		all.addAll(Posse);
		
		return all;
	}
	
	private void createEsse(){
	
		///actIndPres
		ArrayList<String> esse0 = new ArrayList();
		esse0.add("act"); esse0.add(ind); esse0.add(pres); esse0.add(first); esse0.add(sing);
		Esse.add(new Word("sum", verb, esse, esse0));

		ArrayList<String> esse1 = new ArrayList();
		esse1.add("act"); esse1.add(ind); esse1.add(pres); esse1.add(second); esse1.add(sing);
		Esse.add(new Word("es", verb, esse, esse1));

		ArrayList<String> esse2 = new ArrayList();
		esse2.add("act"); esse2.add(ind); esse2.add(pres); esse2.add(third); esse2.add(sing);
		Esse.add(new Word("est", verb, esse, esse2));

		ArrayList<String> esse3 = new ArrayList();
		esse3.add("act"); esse3.add(ind); esse3.add(pres); esse3.add(first); esse3.add(plur);
		Esse.add(new Word("sumus", verb, esse, esse3));

		ArrayList<String> esse4 = new ArrayList();
		esse4.add("act"); esse4.add(ind); esse4.add(pres); esse4.add(second); esse4.add(plur);
		Esse.add(new Word("estis", verb, esse, esse4));
		
		ArrayList<String> esse5 = new ArrayList();
		esse5.add("act"); esse5.add(ind); esse5.add(pres); esse5.add(third); esse5.add(plur);
		Esse.add(new Word("sunt", verb, esse, esse5));
		
		
		///actIndImperf
		ArrayList<String> esse6 = new ArrayList();
		esse6.add("act"); esse6.add(ind); esse6.add(imperf); esse6.add(first); esse6.add(sing);
		Esse.add(new Word("eram", verb, esse, esse6));

		ArrayList<String> esse7 = new ArrayList();
		esse7.add("act"); esse7.add(ind); esse7.add(imperf); esse7.add(second); esse7.add(sing);
		Esse.add(new Word("eras", verb, esse, esse7));

		ArrayList<String> esse8 = new ArrayList();
		esse8.add("act"); esse8.add(ind); esse8.add(imperf); esse8.add(third); esse8.add(sing);
		Esse.add(new Word("erat", verb, esse, esse8));

		ArrayList<String> esse9 = new ArrayList();
		esse9.add("act"); esse9.add(ind); esse9.add(imperf); esse9.add(first); esse9.add(plur);
		Esse.add(new Word("eramus", verb, esse, esse9));

		ArrayList<String> esse10 = new ArrayList();
		esse10.add("act"); esse10.add(ind); esse10.add(imperf); esse10.add(second); esse10.add(plur);
		Esse.add(new Word("eratis", verb, esse, esse10));
		
		ArrayList<String> esse11 = new ArrayList();
		esse11.add("act"); esse11.add(ind); esse11.add(imperf); esse11.add(third); esse11.add(plur);
		Esse.add(new Word("erant", verb, esse, esse11));
		
		
		
		///actIndFut
		
		ArrayList<String> esse12 = new ArrayList();
		esse12.add(act); esse12.add(ind); esse12.add(fut); esse12.add(first); esse12.add(sing);
		Esse.add(new Word("ero", verb, esse, esse12));

		ArrayList<String> esse13 = new ArrayList();
		esse13.add("act"); esse13.add(ind); esse13.add(fut); esse13.add(second); esse13.add(sing);
		Esse.add(new Word("eris", verb, esse, esse13));

		ArrayList<String> esse14 = new ArrayList();
		esse14.add("act"); esse14.add(ind); esse14.add(fut); esse14.add(third); esse14.add(sing);
		Esse.add(new Word("erit", verb, esse, esse14));

		ArrayList<String> esse15 = new ArrayList();
		esse15.add("act"); esse15.add(ind); esse15.add(fut); esse15.add(first); esse15.add(plur);
		Esse.add(new Word("erimus", verb, esse, esse15));

		ArrayList<String> esse16 = new ArrayList();
		esse16.add("act"); esse16.add(ind); esse16.add(fut); esse16.add(second); esse16.add(plur);
		Esse.add(new Word("eritis", verb, esse, esse16));
		
		ArrayList<String> esse17 = new ArrayList();
		esse17.add("act"); esse17.add(ind); esse17.add(fut); esse17.add(third); esse17.add(plur);
		Esse.add(new Word("erint", verb, esse, esse17));
		
		
		///actIndPerf
		ArrayList<String> esse18 = new ArrayList();
		esse18.add(act); esse18.add(ind); esse18.add(perf); esse18.add(first); esse18.add(sing);
		Esse.add(new Word("fui", verb, esse, esse18));

		ArrayList<String> esse19 = new ArrayList();
		esse19.add(act); esse19.add(ind); esse19.add(perf); esse19.add(second); esse19.add(sing);
		Esse.add(new Word("fuisti", verb, esse, esse19));

		ArrayList<String> esse20 = new ArrayList();
		esse20.add(act); esse20.add(ind); esse20.add(perf); esse20.add(third); esse20.add(sing);
		Esse.add(new Word("fuit", verb, esse, esse20));

		ArrayList<String> esse21 = new ArrayList();
		esse21.add(act); esse21.add(ind); esse21.add(perf); esse21.add(first); esse21.add(plur);
		Esse.add(new Word("fuimus", verb, esse, esse21));

		ArrayList<String> esse22 = new ArrayList();
		esse22.add(act); esse22.add(ind); esse22.add(perf); esse22.add(second); esse22.add(plur);
		Esse.add(new Word("fuistis", verb, esse, esse22));
		
		ArrayList<String> esse23 = new ArrayList();
		esse23.add(act); esse23.add(ind); esse23.add(perf); esse23.add(third); esse23.add(plur);
		Esse.add(new Word("fuerunt", verb, esse, esse23));
		
		
		
		///actIndPerfFut
		
		ArrayList<String> esse24 = new ArrayList();
		esse24.add(act); esse24.add(ind); esse24.add(perfFut); esse24.add(first); esse24.add(sing);
		Esse.add(new Word("fuero", verb, esse, esse24));

		ArrayList<String> esse25 = new ArrayList();
		esse25.add(act); esse25.add(ind); esse25.add(perfFut); esse25.add(second); esse25.add(sing);
		Esse.add(new Word("fueris", verb, esse, esse25));

		ArrayList<String> esse26 = new ArrayList();
		esse26.add(act); esse26.add(ind); esse26.add(perfFut); esse26.add(third); esse26.add(sing);
		Esse.add(new Word("fuerit", verb, esse, esse26));

		ArrayList<String> esse27 = new ArrayList();
		esse27.add(act); esse27.add(ind); esse27.add(perfFut); esse27.add(first); esse27.add(plur);
		Esse.add(new Word("fuerimus", verb, esse, esse27));

		ArrayList<String> esse28 = new ArrayList();
		esse28.add(act); esse28.add(ind); esse28.add(perfFut); esse28.add(second); esse28.add(plur);
		Esse.add(new Word("fueritis", verb, esse, esse28));
		
		ArrayList<String> esse29 = new ArrayList();
		esse29.add(act); esse29.add(ind); esse29.add(perfFut); esse29.add(third); esse29.add(plur);
		Esse.add(new Word("fuerint", verb, esse, esse29));
		
		
		///actIndPluperf
		
		ArrayList<String> esse30 = new ArrayList();
		esse30.add(act); esse30.add(ind); esse30.add(pluperf); esse30.add(first); esse30.add(sing);
		Esse.add(new Word("fueram", verb, esse, esse30));

		ArrayList<String> esse31 = new ArrayList();
		esse31.add(act); esse31.add(ind); esse31.add(pluperf); esse31.add(second); esse31.add(sing);
		Esse.add(new Word("fueras", verb, esse, esse31));

		ArrayList<String> esse32 = new ArrayList();
		esse32.add(act); esse32.add(ind); esse32.add(pluperf); esse32.add(third); esse32.add(sing);
		Esse.add(new Word("fuerat", verb, esse, esse32));

		ArrayList<String> esse33 = new ArrayList();
		esse33.add(act); esse33.add(ind); esse33.add(pluperf); esse33.add(first); esse33.add(plur);
		Esse.add(new Word("fueramus", verb, esse, esse33));

		ArrayList<String> esse34 = new ArrayList();
		esse34.add(act); esse34.add(ind); esse34.add(pluperf); esse34.add(second); esse34.add(plur);
		Esse.add(new Word("fueratis", verb, esse, esse34));
		
		ArrayList<String> esse35 = new ArrayList();
		esse35.add(act); esse35.add(ind); esse35.add(pluperf); esse35.add(third); esse35.add(plur);
		Esse.add(new Word("fuerant", verb, esse, esse35));
		
		
		///ActSubjImperf
		
		ArrayList<String> esse36 = new ArrayList();
		esse36.add(act); esse36.add(subj); esse36.add(imperf); esse36.add(first); esse36.add(sing);
		Esse.add(new Word("essem", verb, esse, esse36));

		ArrayList<String> esse37 = new ArrayList();
		esse37.add(act); esse37.add(subj); esse37.add(imperf); esse37.add(second); esse37.add(sing);
		Esse.add(new Word("esses", verb, esse, esse37));

		ArrayList<String> esse38 = new ArrayList();
		esse38.add(act); esse38.add(subj); esse38.add(imperf); esse38.add(third); esse38.add(sing);
		Esse.add(new Word("esset", verb, esse, esse38));

		ArrayList<String> esse39 = new ArrayList();
		esse39.add(act); esse39.add(subj); esse39.add(imperf); esse39.add(first); esse39.add(plur);
		Esse.add(new Word("essemus", verb, esse, esse39));

		ArrayList<String> esse40 = new ArrayList();
		esse40.add(act); esse40.add(subj); esse40.add(imperf); esse40.add(second); esse40.add(plur);
		Esse.add(new Word("essetis", verb, esse, esse40));
		
		ArrayList<String> esse41 = new ArrayList();
		esse41.add(act); esse41.add(subj); esse41.add(imperf); esse41.add(third); esse41.add(plur);
		Esse.add(new Word("essent", verb, esse, esse41));
		
		
		///ActSubjPerf
		ArrayList<String> esse42 = new ArrayList();
		esse42.add(act); esse42.add(subj); esse42.add(perf); esse42.add(first); esse42.add(sing);
		Esse.add(new Word("fuerim", verb, esse, esse42));

		ArrayList<String> esse43 = new ArrayList();
		esse43.add(act); esse43.add(subj); esse43.add(perf); esse43.add(second); esse43.add(sing);
		Esse.add(new Word("fueris", verb, esse, esse43));

		ArrayList<String> esse44 = new ArrayList();
		esse44.add(act); esse44.add(subj); esse44.add(perf); esse44.add(third); esse44.add(sing);
		Esse.add(new Word("fuerit", verb, esse, esse44));

		ArrayList<String> esse45 = new ArrayList();
		esse45.add(act); esse45.add(subj); esse45.add(perf); esse45.add(first); esse45.add(plur);
		Esse.add(new Word("fuerimus", verb, esse, esse45));

		ArrayList<String> esse46 = new ArrayList();
		esse46.add(act); esse46.add(subj); esse46.add(perf); esse46.add(second); esse46.add(plur);
		Esse.add(new Word("fueritis", verb, esse, esse46));
		
		ArrayList<String> esse47 = new ArrayList();
		esse47.add(act); esse47.add(subj); esse47.add(perf); esse47.add(third); esse47.add(plur); 
		Esse.add(new Word("fuerint", verb, esse, esse47));
		
		///ActIndSubjPluperf
		ArrayList<String> esse48 = new ArrayList();
		esse48.add(act); esse48.add(subj); esse48.add(pluperf); esse48.add(first); esse48.add(sing);
		Esse.add(new Word("fuissem", verb, esse, esse48));

		ArrayList<String> esse49 = new ArrayList();
		esse49.add(act); esse49.add(subj); esse49.add(pluperf); esse49.add(second); esse49.add(sing);
		Esse.add(new Word("fuisses", verb, esse, esse49));

		ArrayList<String> esse50 = new ArrayList();
		esse50.add(act); esse50.add(subj); esse50.add(pluperf); esse50.add(third); esse50.add(sing);
		Esse.add(new Word("fuisset", verb, esse, esse50));

		ArrayList<String> esse51 = new ArrayList();
		esse51.add(act); esse51.add(subj); esse51.add(pluperf); esse51.add(first); esse51.add(plur);
		Esse.add(new Word("fuissemus", verb, esse, esse51));

		ArrayList<String> esse52 = new ArrayList();
		esse52.add(act); esse52.add(subj); esse52.add(pluperf); esse52.add(second); esse52.add(plur);
		Esse.add(new Word("fuissetis", verb, esse, esse52));
		
		ArrayList<String> esse53 = new ArrayList();
		esse53.add(act); esse53.add(subj); esse53.add(pluperf); esse53.add(third); esse53.add(plur);
		Esse.add(new Word("fuissent", verb, esse, esse53));
		
		
		
		///ActIndSubjPres
		ArrayList<String> esse54 = new ArrayList();
		esse54.add(act); esse54.add(subj); esse54.add(pres); esse54.add(first); esse54.add(sing);
		Esse.add(new Word("sim", verb, esse, esse54));

		ArrayList<String> esse55 = new ArrayList();
		esse55.add(act); esse55.add(subj); esse55.add(pres); esse55.add(second); esse55.add(sing);
		Esse.add(new Word("sis", verb, esse, esse55));

		ArrayList<String> esse56 = new ArrayList();
		esse56.add(act); esse56.add(subj); esse56.add(pres); esse56.add(third); esse56.add(sing);
		Esse.add(new Word("sit", verb, esse, esse56));

		ArrayList<String> esse57 = new ArrayList();
		esse57.add(act); esse57.add(subj); esse57.add(pres); esse57.add(first); esse57.add(plur);
		Esse.add(new Word("simus", verb, esse, esse57));

		ArrayList<String> esse58 = new ArrayList();
		esse58.add(act); esse58.add(subj); esse58.add(pres); esse58.add(second); esse58.add(plur);
		Esse.add(new Word("sitis", verb, esse, esse58));
		
		ArrayList<String> esse59 = new ArrayList();
		esse59.add(act); esse59.add(subj); esse59.add(pres); esse59.add(third); esse59.add(plur);
		Esse.add(new Word("sint", verb, esse, esse59));
		
		
		///ActImpFut
		ArrayList<String> esse60 = new ArrayList();
		esse60.add(act); esse60.add(imp); esse60.add(fut); esse60.add(second); esse60.add(sing);
		Esse.add(new Word("esto", verb, esse, esse60));

		ArrayList<String> esse61 = new ArrayList();
		esse61.add(act); esse61.add(imp); esse61.add(fut); esse61.add(third); esse61.add(sing);
		Esse.add(new Word("esto", verb, esse, esse61));

		ArrayList<String> esse62 = new ArrayList();
		esse62.add(act); esse62.add(imp); esse62.add(fut); esse62.add(second); esse62.add(plur);
		Esse.add(new Word("estote", verb, esse, esse62));
		
		ArrayList<String> esse63 = new ArrayList();
		esse63.add(act); esse63.add(imp); esse63.add(fut); esse63.add(third); esse63.add(plur);
		Esse.add(new Word("sunto", verb, esse, esse63));
		
		///ActImpPres
		ArrayList<String> esse64 = new ArrayList();
		esse64.add(act); esse64.add(imp); esse64.add(pres); esse64.add(second); esse64.add(sing);
		Esse.add(new Word("es", verb, esse, esse64));

		ArrayList<String> esse65 = new ArrayList();
		esse65.add(act); esse65.add(imp); esse65.add(pres); esse65.add(second); esse65.add(sing);
		Esse.add(new Word("este", verb, esse, esse65));
		
		
		///ActInfPerf
		ArrayList<String> esse66 = new ArrayList();
		esse66.add(act); esse66.add(inf); esse66.add(perf); 
		Esse.add(new Word("fuisse", verb, esse, esse66));

		
		///ActInfPres
		
		ArrayList<String> esse67 = new ArrayList();
		esse67.add(act); esse67.add(inf); esse67.add(pres); 
		Esse.add(new Word("esse", verb, esse, esse67));

	
	}
	public ArrayList<Word> getEsse(){
		return Esse;
	}
	
	private void createPosse(){
		ArrayList<String> Parse = new ArrayList();
		ArrayList<String> empty = new ArrayList();
		///actIndPres
				Parse.add(act); Parse.add(ind); Parse.add(pres); Parse.add(first); Parse.add(sing);
				Posse.add(new Word("possum", verb, "", Parse));

				Parse.set(3,second); 
				Posse.add(new Word("poses", verb, "", Parse));

				Parse.set(3,third); 
				Posse.add(new Word("posest", verb, "", Parse));

				Parse.set(3, first); Parse.set(4, plur);
				Posse.add(new Word("possumus", verb, "", Parse));

				Parse.set(3, second); 
				Posse.add(new Word("posestis", verb, "", Parse));
				
				Parse.set(3, third); 
				Posse.add(new Word("possunt", verb, "", Parse));
				
				Parse.clear();
				
				///actIndImperf
				
				Parse.add(act); Parse.add(ind); Parse.add(imperf); Parse.add(first); Parse.add(sing);
				Posse.add(new Word("poteram", verb, "", Parse));

				Parse.set(3,second); 
				Posse.add(new Word("poteras", verb, "", Parse));

				Parse.set(3,third);
				Posse.add(new Word("poterat", verb, "", Parse));

				Parse.set(3, first); Parse.set(4, plur);
				Posse.add(new Word("poteramus", verb, "", Parse));

				Parse.set(3, second); 
				Posse.add(new Word("poteratis", verb, "", Parse));
				
				Parse.set(3, third);
				Posse.add(new Word("poterant", verb, "", Parse));
				
				Parse.clear();
				
				
				///actIndFut
				
				Parse.add(act); Parse.add(ind); Parse.add(fut); Parse.add(first); Parse.add(sing);
				Posse.add(new Word("potero", verb, "", Parse));

				Parse.set(3,second);
				Posse.add(new Word("poteris", verb, "", Parse));

				Parse.set(3,third);
				Posse.add(new Word("poterit", verb, "", Parse));

				Parse.set(3, first); Parse.set(4, plur);
				Posse.add(new Word("poterimus", verb, "", Parse));

				Parse.set(3, second); 
				Posse.add(new Word("poteritis", verb, "", Parse));
				
				Parse.set(3, third); 
				Posse.add(new Word("poterint", verb, "", Parse));
				
				Parse.clear();
				
				///actIndPerf
				Parse.add(act); Parse.add(ind); Parse.add(perf); Parse.add(first); Parse.add(sing);
				Posse.add(new Word("potui", verb, "", Parse));

				Parse.set(3,second); 
				Posse.add(new Word("potuisti", verb, "", Parse));

				Parse.set(3,third); 
				Posse.add(new Word("potuit", verb, "", Parse));

				Parse.set(3, first); Parse.set(4, plur);
				Posse.add(new Word("potuimus", verb, "", Parse));

				Parse.set(3, second); 
				Posse.add(new Word("potuistis", verb, "", Parse));
				
				Parse.set(3, third); 
				Posse.add(new Word("potuerunt", verb, "", Parse));
				
				Parse.clear();
				
				///actIndPerfFut
				
				Parse.add(act); Parse.add(ind); Parse.add(perfFut); Parse.add(first); Parse.add(sing);
				Posse.add(new Word("potuero", verb, "", Parse));

				Parse.set(3,second); 
				Posse.add(new Word("potueris", verb, "", Parse));

				Parse.set(3,third);
				Posse.add(new Word("potuerit", verb, "", Parse));

				Parse.set(3, first); Parse.set(4, plur);
				Posse.add(new Word("potuerimus", verb, "", Parse));

				Parse.set(3, second);
				Posse.add(new Word("potueritis", verb, "", Parse));
				
				Parse.set(3, third); 
				Posse.add(new Word("potuerint", verb, "", Parse));
				
				Parse.clear();
				
				///actIndPluperf
				
				Parse.add(act); Parse.add(ind); Parse.add(pluperf); Parse.add(first); Parse.add(sing);
				Posse.add(new Word("potueram", verb, "", Parse));

				Parse.set(3,second);
				Posse.add(new Word("potueras", verb, "", Parse));

				Parse.set(3,third);
				Posse.add(new Word("potuerat", verb, "", Parse));

				Parse.set(3, first); Parse.set(4, plur);
				Posse.add(new Word("potueramus", verb, "", Parse));

				Parse.set(3, second); 
				Posse.add(new Word("potueratis", verb, "", Parse));
				
				Parse.set(3, third); 
				Posse.add(new Word("potuerant", verb, "", Parse));
				
				Parse.clear();
				
				///ActSubjImperf
				
				Parse.add(act); Parse.add(subj); Parse.add(imperf); Parse.add(first); Parse.add(sing);
				Posse.add(new Word("possem", verb, "", Parse));

				Parse.set(3,second); 
				Posse.add(new Word("posses", verb, "", Parse));

				Parse.set(3,third);
				Posse.add(new Word("posset", verb, "", Parse));

				Parse.set(3, first); Parse.set(4, plur);
				Posse.add(new Word("possemus", verb, "", Parse));

				Parse.set(3, second); 
				Posse.add(new Word("possetis", verb, "", Parse));
				
				Parse.set(3, third);
				Posse.add(new Word("possent", verb, "", Parse));
				
				Parse.clear();
				
				///ActSubjPerf
				Parse.add(act); Parse.add(subj); Parse.add(perf); Parse.add(first); Parse.add(sing);
				Posse.add(new Word("potuerim", verb, "", Parse));

				Parse.set(3,second); 
				Posse.add(new Word("potueris", verb, "", Parse));

				Parse.set(3,third); 
				Posse.add(new Word("potuerit", verb, "", Parse));

				Parse.set(3, first); Parse.set(4, plur);
				Posse.add(new Word("potuerimus", verb, "", Parse));

				Parse.set(3, second); 
				Posse.add(new Word("potueritis", verb, "", Parse));
				
				Parse.set(3, third); 
				Posse.add(new Word("potuerint", verb, "", Parse));
				
				Parse.clear();
				
				///ActIndSubjPluperf
				Parse.add(act); Parse.add(subj); Parse.add(pluperf); Parse.add(first); Parse.add(sing);
				Posse.add(new Word("potuissem", verb, "", Parse));

				Parse.set(3,second); 
				Posse.add(new Word("potuisses", verb, "", Parse));

				Parse.set(3,third);
				Posse.add(new Word("potuisset", verb, "", Parse));

				Parse.set(3, first); Parse.set(4, plur);
				Posse.add(new Word("potuissemus", verb, "", Parse));

				Parse.set(3, second);
				Posse.add(new Word("potuissetis", verb, "", Parse));
				
				Parse.set(3, third); 
				Posse.add(new Word("potuissent", verb, "", Parse));
				
				Parse.clear();
				
				
				///ActIndSubjPres
				Parse.add(act); Parse.add(subj); Parse.add(pres); Parse.add(first); Parse.add(sing);
				Posse.add(new Word("possim", verb, "", Parse));

				Parse.set(3,second); 
				Posse.add(new Word("possis", verb, "", Parse));

				Parse.set(3,third); 
				Posse.add(new Word("possit", verb, "", Parse));

				Parse.set(3, first); Parse.set(4, plur);
				Posse.add(new Word("possimus", verb, "", Parse));

				Parse.set(3, second); 
				Posse.add(new Word("possitis", verb, "", Parse));
				
				Parse.set(3, third); 
				Posse.add(new Word("possint", verb, "", Parse));
				
				Parse.clear();
				
				///ActImpFut///ActImpPres
			//NO IMPERATIVES?
				
				///ActInfPerf
				Parse.add(act); Parse.add(inf); Parse.add(perf); 
				Posse.add(new Word("potuisse", verb, "", Parse));

				Parse.clear();
				
				///ActInfPres
				Parse.add(act); Parse.add(inf); Parse.add(pres); 
				Posse.add(new Word("posse", verb, "", Parse));
				Log.d(TAG, Posse.get(Posse.size()-1).parseString());
				Parse.clear();
	}
	
	public ArrayList<Word> getPosse(){
		return Posse;
	}
}
