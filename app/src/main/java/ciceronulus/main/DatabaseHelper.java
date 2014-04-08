package ciceronulus.main;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private String TAG = DatabaseHelper.class.getCanonicalName();
    private static String DATABASEpath, DATABASE_NAME,FULL_DATABASE_PATH ;
    private SQLiteDatabase database;
    private Context context;


    public DatabaseHelper(Context context, String DATABASE_NAME) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.DATABASE_NAME = DATABASE_NAME;
        this.context = context;

        if (android.os.Build.VERSION.SDK_INT >= 4.2) {
            this.DATABASEpath = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            this.DATABASEpath = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.FULL_DATABASE_PATH = DATABASEpath+DATABASE_NAME;

        setupDatabase();
    }


    /**
     * Creates a empty database on the system and rewrites it with the database in assets.
     */
    private void setupDatabase() {
        Log("Attempting to setup database");
        if (checkIfDatabaseFileExists()) {    // check if database exists, if not copy local file
            Log("Database exists. won't copy it from assets");
        } else {            // create database and repopulate (the earth)
            Log("Database doesn't exist locally. Attempting to copy database from assets");

            this.getWritableDatabase();     // creates an empty database that we will later write over
            this.close();           // close it
            try {
                copyDatabaseFromLocalFileToSystem();        // copy from local file
            } catch (Exception e) {
                Log("COULD NOT READ LOCAL DB FILE");
                e.printStackTrace();
            }
        }

        try {
            openDatabase();
        } catch (SQLException e) {
            Log("Could not open database");
        }

        if (!checkIfDatabaseHasData()) {        // check if theres data!
            Log.d(DatabaseHelper.class.getCanonicalName(), "DATABASE doesnt have data. Something is wrong. Check database file in assets");
        }
    }


    @Override
    public void onCreate(SQLiteDatabase database) {

        // Dont do anything
        Log("Database onCreate() called");
        this.database = database;

//		database.execSQL(CREATETBnoun);
//		database.execSQL(CREATETBnoundeclension1);
//		database.execSQL(CREATETBnoundeclension2);
//		database.execSQL(CREATETBnoundeclension3);
//		database.execSQL(CREATETBnoundeclension4);
//		database.execSQL(CREATETBnoundeclension5);
//		database.execSQL(CREATETBverb);
//		database.execSQL(CREATETBverbendactimpfut);
//		database.execSQL(CREATETBverbendactimppres);
//		database.execSQL(CREATETBverbendactindfut);
//		database.execSQL(CREATETBverbendactindimperf);
//		database.execSQL(CREATETBverbendactindpres);
//		database.execSQL(CREATETBverbendactinfperf);
//		database.execSQL(CREATETBverbendactinfpres);
//		database.execSQL(CREATETBverbendactsubjimperf);
//		database.execSQL(CREATETBverbendactsubjpres);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(DatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data"
        );
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


    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     */
    public boolean checkIfDatabaseFileExists() {
        Log.d(DatabaseHelper.class.getCanonicalName(), "Attempting to open database on " + FULL_DATABASE_PATH);
        File dbFile = new File(FULL_DATABASE_PATH);
        return dbFile.exists();
    }

    public boolean checkIfDatabaseHasData() {
        boolean exists = false;
        Log("checking if database has data");
        Cursor result = null;
        if (database != null) {    // if database object is null, the database doesnt exist
            try {
                result = database.rawQuery("SELECT COUNT(_id) AS countid FROM Noun", null);      // check to see if anything exists in the Term table
                exists = result.moveToFirst();
                if (exists) {
                    exists = result.getInt(0) > 0;
                    Log.d(DatabaseHelper.class.getCanonicalName(), "number of id rows in Term table returned: " + result.getInt(0));
                }
            } catch (Exception e) {
                Log.d(DatabaseHelper.class.getCanonicalName(), "data check query failed: must reset data");
                exists = false;
            } finally {
                if (result != null) {
                    result.close();
                }
            }

        }
        // dont close database
        return exists;
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     */
    private void copyDatabaseFromLocalFileToSystem() throws IOException {

        //Open your local db as the input stream
        InputStream input = context.getAssets().open(DATABASE_NAME);

        //Open the empty db as the output stream
        OutputStream output = new FileOutputStream(FULL_DATABASE_PATH);

        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = input.read(buffer)) > 0) {
            output.write(buffer, 0, length);
        }

        //Close the streams
        output.flush();
        output.close();
        input.close();
    }

    private void openDatabase() throws SQLException {
        database = SQLiteDatabase.openDatabase(FULL_DATABASE_PATH, null, SQLiteDatabase.OPEN_READWRITE);
        Log.d(DatabaseHelper.class.getCanonicalName(), "Opened Read/Write database, isOpen:" + database.isOpen());
    }


    /**
     * Just a method to make logging easier
     * @param message
     */
    private void Log(String message) {
        Log.d(DatabaseHelper.class.getCanonicalName(), message);
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
