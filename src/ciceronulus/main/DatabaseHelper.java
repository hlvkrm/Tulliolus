package ciceronulus.main;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;

	String TAG = DatabaseHelper.class.getCanonicalName();
	private static String DATABASEpath = "";

	public DatabaseHelper(Context context, String DATABASE_NAME) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);

		if (android.os.Build.VERSION.SDK_INT >= 4.2) {
			this.DATABASEpath = context.getApplicationInfo().dataDir
					+ "/databases/";
		} else {
			this.DATABASEpath = "/data/data/" + context.getPackageName()
					+ "/databases/";
		}
	}
	public String getDBpath() {
		return DATABASEpath;
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(CREATETBnoun);
		database.execSQL(CREATETBnoundeclension1);
		database.execSQL(CREATETBnoundeclension2);
		database.execSQL(CREATETBnoundeclension3);
		database.execSQL(CREATETBnoundeclension4);
		database.execSQL(CREATETBnoundeclension5);

		database.execSQL(CREATETBverb);
		database.execSQL(CREATETBverbendactimpfut);
		database.execSQL(CREATETBverbendactimppres);
		database.execSQL(CREATETBverbendactindfut);
		database.execSQL(CREATETBverbendactindimperf);
		database.execSQL(CREATETBverbendactindpres);
		database.execSQL(CREATETBverbendactinfperf);
		database.execSQL(CREATETBverbendactinfpres);
		database.execSQL(CREATETBverbendactsubjimperf);
		database.execSQL(CREATETBverbendactsubjpres);

	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.d(DatabaseHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TBnoun);
		db.execSQL("DROP TABLE IF EXISTS " + TBnoundeclension1);
		db.execSQL("DROP TABLE IF EXISTS " + TBnoundeclension2);
		db.execSQL("DROP TABLE IF EXISTS " + TBnoundeclension3);
		db.execSQL("DROP TABLE IF EXISTS " + TBnoundeclension4);
		db.execSQL("DROP TABLE IF EXISTS " + TBnoundeclension5);
		db.execSQL("DROP TABLE IF EXISTS " + TBverb);
		db.execSQL("DROP TABLE IF EXISTS " + TBverbendactimpfut);
		db.execSQL("DROP TABLE IF EXISTS " + TBverbendactimppres);
		db.execSQL("DROP TABLE IF EXISTS " + TBverbendactindfut);
		db.execSQL("DROP TABLE IF EXISTS " + TBverbendactindimperf);
		db.execSQL("DROP TABLE IF EXISTS " + TBverbendactindpres);
		db.execSQL("DROP TABLE IF EXISTS " + TBverbendactinfperf);
		db.execSQL("DROP TABLE IF EXISTS " + TBverbendactinfpres);
		onCreate(db);
	}

	public void openDatabase(Context c, String DATABASE_NAME) throws IOException {

		try {
			//File db = c.getDatabasePath(DATABASE_NAME);
			
			File db = new File(DATABASEpath+DATABASE_NAME);
			
			db.getParentFile().mkdirs();
			//db.createNewFile();

			// TODO you shouldn't do this everytime
			copyDatabase(c.getAssets().open(DATABASE_NAME),
					new FileOutputStream(db));

			// you need to open the database after copying it
			
			Log.d(TAG, "copied database from "+c.getAssets().open(DATABASE_NAME)+ "to "+db.getAbsolutePath());

		} catch (Exception e) {
			Log.d(TAG, "Error opening database at "+ DATABASEpath);
			e.printStackTrace();
		} 
	}

	public void copyDatabase(InputStream is, OutputStream os)
			throws IOException {
		byte[] mBuffer = new byte[1024];
		int mLength;
		while ((mLength = is.read(mBuffer)) > 0) {
			os.write(mBuffer, 0, mLength);
		}

		is.close();
		os.flush();
		os.close();

	}
	
	

	// ////////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////////
	// //DATABASE CREATE STRINGS
	/*
	 * create table Noun(_id integer primary key autoincrement, Lemma, Gender,
	 * Stem, Declension, Note); create table NounDeclension1(_id integer primary
	 * key autoincrement, Type, NomS, AccS, GenS, DatS, AblS, VocS, NomP, AccP,
	 * GenP, DatP, AblP, VocP); create table NounDeclension2(_id integer primary
	 * key autoincrement, Type, NomS, AccS, GenS, DatS, AblS, VocS, NomP, AccP,
	 * GenP, DatP, AblP, VocP); create table NounDeclension3(_id integer primary
	 * key autoincrement, Type, NomS, AccS, GenS, DatS, AblS, VocS, NomP, AccP,
	 * GenP, DatP, AblP, VocP); create table NounDeclension4(_id integer primary
	 * key autoincrement, Type, NomS, AccS, GenS, DatS, AblS, VocS, NomP, AccP,
	 * GenP, DatP, AblP, VocP); create table NounDeclension5(_id integer primary
	 * key autoincrement, Type, NomS, AccS, GenS, DatS, AblS, VocS, NomP, AccP,
	 * GenP, DatP, AblP, VocP); create table Verb(_id integer primary key
	 * autoincrement, PP1, PP2, PP3, PP4, StemPresent, StemPerfect, StemSupine,
	 * Conjugation, Note); create table VerbEndActImpFut(_id integer primary key
	 * autoincrement, End, Voice, Mood, Tense, Person, Number); create table
	 * VerbEndActImpPres(_id integer primary key autoincrement, End, Voice,
	 * Mood, Tense, Person, Number); create table VerbEndActIndFut(_id integer
	 * primary key autoincrement, End, Voice, Mood, Tense, Person, Number);
	 * create table VerbEndActIndImperf(_id integer primary key autoincrement,
	 * End, Voice, Mood, Tense, Person, Number); create table
	 * VerbEndActIndPres(_id integer primary key autoincrement, End, Voice,
	 * Mood, Tense, Person, Number); create table VerbEndActInfPerf(_id integer
	 * primary key autoincrement, End, Voice, Mood, Tense, Person, Number);
	 * create table VerbEndActInfPres(_id integer primary key autoincrement,
	 * End, Voice, Mood, Tense, Person, Number); create table
	 * VerbEndActSubjImperf(_id integer primary key autoincrement, End, Voice,
	 * Mood, Tense, Person, Number); create table VerbEndActSubjPres(_id integer
	 * primary key autoincrement, End, Voice, Mood, Tense, Person, Number);
	 */

	// /NOUN
	public static final String TBnoun = "Noun";
	public static final String CLMid = "_id";// ****
	public static final String CLMlemma = "Lemma";
	public static final String CLMgender = "Gender";
	public static final String CLMstem = "Stem";
	public static final String CLMdeclension = "Declension";
	public static final String CLMnote = "Note";// ****

	private static final String CREATETBnoun = "create table " + TBnoun + "("
			+ CLMid + " integer primary key autoincrement, " + CLMlemma + ", "
			+ CLMgender + ", " + CLMstem + ", " + CLMdeclension + ", "
			+ CLMnote + ");";
	// //

	// /NOUN DECLENSIONS
	public static final String TBnoundeclension1 = "NounDeclension1";
	public static final String TBnoundeclension2 = "NounDeclension2";
	public static final String TBnoundeclension3 = "NounDeclension3";
	public static final String TBnoundeclension4 = "NounDeclension4";
	public static final String TBnoundeclension5 = "NounDeclension5";
	public static final String CLMtype = "Type";
	public static final String CLMnoms = "NomS";
	public static final String CLMaccs = "AccS";
	public static final String CLMgens = "GenS";
	public static final String CLMdats = "DatS";
	public static final String CLMabls = "AblS";
	public static final String CLMvocs = "VocS";
	public static final String CLMnomp = "NomP";
	public static final String CLMaccp = "AccP";
	public static final String CLMgenp = "GenP";
	public static final String CLMdatp = "DatP";
	public static final String CLMablp = "AblP";
	public static final String CLMvocp = "VocP";

	private static final String CREATETBnoundeclension1 = "create table "
			+ TBnoundeclension1 + "(" + CLMid
			+ " integer primary key autoincrement, " + CLMtype + ", " + CLMnoms
			+ ", " + CLMaccs + ", " + CLMgens + ", " + CLMdats + ", " + CLMabls
			+ ", " + CLMvocs + ", " + CLMnomp + ", " + CLMaccp + ", " + CLMgenp
			+ ", " + CLMdatp + ", " + CLMablp + ", " + CLMvocp + "); ";
	private static final String CREATETBnoundeclension2 = "create table "
			+ TBnoundeclension2 + "(" + CLMid
			+ " integer primary key autoincrement, " + CLMtype + ", " + CLMnoms
			+ ", " + CLMaccs + ", " + CLMgens + ", " + CLMdats + ", " + CLMabls
			+ ", " + CLMvocs + ", " + CLMnomp + ", " + CLMaccp + ", " + CLMgenp
			+ ", " + CLMdatp + ", " + CLMablp + ", " + CLMvocp + "); ";
	private static final String CREATETBnoundeclension3 = "create table "
			+ TBnoundeclension3 + "(" + CLMid
			+ " integer primary key autoincrement, " + CLMtype + ", " + CLMnoms
			+ ", " + CLMaccs + ", " + CLMgens + ", " + CLMdats + ", " + CLMabls
			+ ", " + CLMvocs + ", " + CLMnomp + ", " + CLMaccp + ", " + CLMgenp
			+ ", " + CLMdatp + ", " + CLMablp + ", " + CLMvocp + "); ";
	private static final String CREATETBnoundeclension4 = "create table "
			+ TBnoundeclension4 + "(" + CLMid
			+ " integer primary key autoincrement, " + CLMtype + ", " + CLMnoms
			+ ", " + CLMaccs + ", " + CLMgens + ", " + CLMdats + ", " + CLMabls
			+ ", " + CLMvocs + ", " + CLMnomp + ", " + CLMaccp + ", " + CLMgenp
			+ ", " + CLMdatp + ", " + CLMablp + ", " + CLMvocp + "); ";
	private static final String CREATETBnoundeclension5 = "create table "
			+ TBnoundeclension5 + "(" + CLMid
			+ " integer primary key autoincrement, " + CLMtype + ", " + CLMnoms
			+ ", " + CLMaccs + ", " + CLMgens + ", " + CLMdats + ", " + CLMabls
			+ ", " + CLMvocs + ", " + CLMnomp + ", " + CLMaccp + ", " + CLMgenp
			+ ", " + CLMdatp + ", " + CLMablp + ", " + CLMvocp + "); ";
	// /////////
	// /VERB

	public static final String TBverb = "Verb";
	public static final String CLMpp1 = "PP1";
	public static final String CLMpp2 = "PP2";
	public static final String CLMpp3 = "PP3";
	public static final String CLMpp4 = "PP4";
	public static final String CLMstempresent = "StemPresent";
	public static final String CLMstemperfect = "StemPerfect";
	public static final String CLMstemsupine = "StemSupine";
	public static final String CLMconjugation = "Conjugation";

	private static final String CREATETBverb = "create table " + TBverb + "("
			+ CLMid + " integer primary key autoincrement, " + CLMpp1 + ", "
			+ CLMpp2 + ", " + CLMpp3 + ", " + CLMpp4 + ", " + CLMstempresent
			+ ", " + CLMstemperfect + ", " + CLMstemsupine + ", "
			+ CLMconjugation + ", " + CLMnote + "); ";

	// ///////
	// /VERB ENDINGS
	public static final String TBverbendactimpfut = "VerbEndActImpFut";
	public static final String TBverbendactimppres = "VerbEndActImpPres";
	public static final String TBverbendactindfut = "VerbEndActIndFut";
	public static final String TBverbendactindimperf = "VerbEndActIndImperf";
	public static final String TBverbendactindpres = "VerbEndActIndPres";
	public static final String TBverbendactinfperf = "VerbEndActInfPerf";
	public static final String TBverbendactinfpres = "VerbEndActInfPres";
	public static final String TBverbendactsubjimperf = "VerbEndActSubjImperf";
	public static final String TBverbendactsubjpres = "VerbEndActSubjPres";
	public static final String CLMend = "End";
	public static final String CLMvoice = "Voice";
	public static final String CLMmood = "Mood";
	public static final String CLMtense = "Tense";
	public static final String CLMperson = "Person";
	public static final String CLMnumber = "Number";

	private static final String CREATETBverbendactimpfut = "create table "
			+ TBverbendactimpfut + "(" + CLMid
			+ " integer primary key autoincrement, " + CLMend + ", " + CLMvoice
			+ ", " + CLMmood + ", " + CLMtense + ", " + CLMperson + ", "
			+ CLMnumber + "); ";
	private static final String CREATETBverbendactimppres = "create table "
			+ TBverbendactimppres + "(" + CLMid
			+ " integer primary key autoincrement, " + CLMend + ", " + CLMvoice
			+ ", " + CLMmood + ", " + CLMtense + ", " + CLMperson + ", "
			+ CLMnumber + "); ";
	private static final String CREATETBverbendactindfut = "create table "
			+ TBverbendactindfut + "(" + CLMid
			+ " integer primary key autoincrement, " + CLMend + ", " + CLMvoice
			+ ", " + CLMmood + ", " + CLMtense + ", " + CLMperson + ", "
			+ CLMnumber + "); ";
	private static final String CREATETBverbendactindimperf = "create table "
			+ TBverbendactindimperf + "(" + CLMid
			+ " integer primary key autoincrement, " + CLMend + ", " + CLMvoice
			+ ", " + CLMmood + ", " + CLMtense + ", " + CLMperson + ", "
			+ CLMnumber + "); ";
	private static final String CREATETBverbendactindpres = "create table "
			+ TBverbendactindpres + "(" + CLMid
			+ " integer primary key autoincrement, " + CLMend + ", " + CLMvoice
			+ ", " + CLMmood + ", " + CLMtense + ", " + CLMperson + ", "
			+ CLMnumber + "); ";
	private static final String CREATETBverbendactinfperf = "create table "
			+ TBverbendactinfperf + "(" + CLMid
			+ " integer primary key autoincrement, " + CLMend + ", " + CLMvoice
			+ ", " + CLMmood + ", " + CLMtense + ", " + CLMperson + ", "
			+ CLMnumber + "); ";
	private static final String CREATETBverbendactinfpres = "create table "
			+ TBverbendactinfpres + "(" + CLMid
			+ " integer primary key autoincrement, " + CLMend + ", " + CLMvoice
			+ ", " + CLMmood + ", " + CLMtense + ", " + CLMperson + ", "
			+ CLMnumber + "); ";
	private static final String CREATETBverbendactsubjimperf = "create table "
			+ TBverbendactsubjimperf + "(" + CLMid
			+ " integer primary key autoincrement, " + CLMend + ", " + CLMvoice
			+ ", " + CLMmood + ", " + CLMtense + ", " + CLMperson + ", "
			+ CLMnumber + "); ";
	private static final String CREATETBverbendactsubjpres = "create table "
			+ TBverbendactsubjpres + "(" + CLMid
			+ " integer primary key autoincrement, " + CLMend + ", " + CLMvoice
			+ ", " + CLMmood + ", " + CLMtense + ", " + CLMperson + ", "
			+ CLMnumber + "); ";

}
