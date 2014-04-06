package ciceronulus.main;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;
import android.content.Context;
import android.content.res.AssetManager;

public class GrammarCheck {

	String orderedParsedValues;
	
	public GrammarCheck(String orderedParsedValues){
		this.orderedParsedValues = orderedParsedValues;
		
		
	}
	public boolean correct(Context context) throws IOException, InvalidTheoryException, MalformedGoalException{
		
		Prolog pl = new Prolog();
		
		
		AssetManager assManager = context.getAssets();
		InputStream is0 = null;
		try {
		        is0 = assManager.open("grammar00.pl");
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		InputStream is1 = new BufferedInputStream(is0);
		
		Theory grammar = new Theory (is1);
		pl.setTheory(grammar);
		SolveInfo answer = pl.solve(orderedParsedValues);
	
		return answer.isSuccess();
	}
}
