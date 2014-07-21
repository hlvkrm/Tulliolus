package tulliolus.process;

import java.util.Vector;

public class ConstructionCheck {
	Processor process;
	String input;
	Vector ConstructionList, parseVector;
	
	public ConstructionCheck(Processor process){
		this.process = process;
		input = process.getInput();
		parseVector = process.getParseVector(); 
		ConstructionList = new Vector();
	}
	
	public Vector check(){
		
		boolean complete = false;
		while(!complete){
		ablativeAbsolute();//verbPhrase
		gerund();//nounPhrase
		gerundive();//nounPhrase
		indirectStatement();//verbPhrase
		indirectQuestion();//verbPhrase
		cumClause();//verbPhrase
		relativeClause();//nounPhrase
		purposeClause();//verbPhrase
		resultClause();//verbPhrase
		preposition();//verbPhrase
		
		complete = true;
		
		}
		
		return ConstructionList;
	}
	
	
	public void preposition(){
		
		
	} 
	
	public void ablativeAbsolute(){
		
	//	1) noun/adjective/pronoun + perfect passive participle (flumine transito);
	//	2) noun/adjective/pronoun + present active participle (Deo volente);
	//	3) noun/adjective/pronoun + noun (Caesare duce). 

		String last = "";
		boolean stop = false;
		int start = -1, end = -1;
		for (int i = 0; i<parseVector.size() && !stop;i++){
			int skip=0;
			int found = search("abl",skip, parseVector);
			if (found!=-1){
				if (start == -1){
					start = found;
				}
				skip++;
			}
			else{
				end = found;
				stop = true;
			}
		}
		
		if ((start>-1)&&(start-end>0)){//if ablatives were found and there is more than one consecutive ablative
			
			Vector ablAbsolute= new Vector();
			
			int start0=start;
			String check = "";
			while(start<end){
				ablAbsolute.add(parseVector.get(start));
				check+=((Vector)parseVector.get(start)).get(0)+" ";
				start++;
			} 
			
			String type = "";
			if (search("perf",0,ablAbsolute) != -1)
				{type="+passPerfPart";}
			if (search("pres",0,ablAbsolute) != -1)
				{type="+actPresPart";}
			else{type="+noun";}
			
			ablAbsolute.add(0,"verbPhrase");
			ablAbsolute.add(1,"ablAbsolute");
			ablAbsolute.add(2,type);
			ConstructionList.addAll((Vector)ablAbsolute);
			
			crossOff(check);
			
			//CALL RECURSION TO CHECK FOR SUCCESSIVE ABLABSOLUTES
	
	}
		
	}
	public void indirectStatement(){
		
		
		
	}
	public void indirectQuestion(){
		
		
		
	}
	public void gerund(){
		
		
		
	}
	public void gerundive(){
		
		
		
	}
	public void cumClause(){
		
		
		
	}
	public void relativeClause(){
		
		
	}
	public void purposeClause(){
		
		
	}
	public void resultClause(){
		
		
	}
	
	public Vector getParseVector(){
		return parseVector;
	}
	public int search(String query, int skip, Vector pV){
		int location = -1;
		boolean found = false;
		for(int i =0; i<pV.size() && !found;i++)
		{
			
			for(int i0=0; i0<((Vector) pV.get(i)).size(); i0++){
				
				String compare = (String)((Vector)pV.get(i)).get(i0);
				if (compare.equals(query)){
					if (skip>0){
						skip--;
					}
					else{
						location = i;
						found = true;
					}
				}
				
			}
		}
		
		return location;
		
	}
	public void crossOff(String words){
		String[] Words = words.split(" ");
		
		for(int i =0; i<Words.length;i++)
		{
			for(int i0 =0; i0<parseVector.size();i0++)
			{
				
				if(((Vector) parseVector.get(i0)).get(0)==Words[i]){
					parseVector.remove(i0);
				}
			}
			
		}
	}
}
