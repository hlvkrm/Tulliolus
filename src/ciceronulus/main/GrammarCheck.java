package ciceronulus.main;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.InputStream;

import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;

public class GrammarCheck {

    private static Prolog prolog;
    private static Context context;


    public GrammarCheck(Context context) {
        this.context = context;

        prolog = new Prolog();

        AssetManager assManager = context.getAssets();
        try {
            Log("Reading grammar00.pl from Assets");
            InputStream is0 = assManager.open("grammar00.pl");

            Log("Loading grammar to Prolog");
            Theory grammar = new Theory(new BufferedInputStream(is0));
            prolog.setTheory(grammar);
        } catch (Exception e) {
            Log("Error reading grammar00.pl from Assets");
            e.printStackTrace();
        }
        Log("Prolog ready");
    }

    private void Log(String message) {
        Log.d(GrammarCheck.class.getCanonicalName(), message);
    }


    public void correct(final String orderedParsedValues) throws MalformedGoalException{

        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = false;
                try {
                    SolveInfo answer = prolog.solve(orderedParsedValues);
                    result = answer.isSuccess();

                } catch (Exception e) {
                    Log("Error occurred during Prolog stuff. Check log");
                    e.printStackTrace();
                    MainActivity.displayResult(result+ "Exception occurred during Prolog stuff. Check log for error trace.");
                }
                MainActivity.displayResult(result+ "");
            }
        }).start();
    }
}
