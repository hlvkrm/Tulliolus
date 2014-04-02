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
import android.util.Log;

public class Helper {
	private static final int DATABASE_VERSION = 1;
	public static final String TABLE_NOUN = "Noun";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_LEMMA = "lemma";
	public static final String COLUMN_GENDER = "Gender";
	public static final String COLUMN_STEM = "Stem";
	public static final String COLUMN_DECLENSION = "Declension";
	public static final String COLUMN_NOTE = "Note";
	
	// Database creation sql statement
		private static final String TB_NOUN_CREATE = "create table "
				+ TABLE_NOUN + "(" 
				+ COLUMN_ID + " integer primary key autoincrement, " 
				+ COLUMN_LEMMA + " text, "
				+ COLUMN_GENDER + " text, "
				+ COLUMN_STEM + " text, "
				+ COLUMN_DECLENSION + " text, "
				+ COLUMN_NOTE + " text);";
		
		String TAG = "Helping?";
		
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(TB_NOUN_CREATE);
		
		
	}

	

	public void createDatabase() throws IOException 
	{ 
	  //If database not exists copy it from the assets 
//		copyDatabase(); 
	//   boolean mDatabaseExist = checkDatabase(); 
	//   if(!mDatabaseExist) 
//	   { 
	   
	  } 
	//} 
	private boolean checkDatabase(String DB_PATH, String DB_NAME) 
	{ 
		
	    File dbFile = new File(DB_PATH + DB_NAME); 
	    return dbFile.exists(); 
	} 
	
	public void openDatabase(Context c, String DB_PATH, String DB_NAME) throws IOException 
	  { 
		
		try{
			
		File f = new File(DB_PATH);
		if(!f.exists())
		{
			f.mkdirs();
			f.createNewFile();
			
			copyDatabase(c.getAssets().open(DB_NAME), new FileOutputStream(DB_PATH+"/"+DB_NAME));
		}
		}catch(FileNotFoundException e)
		{
			Log.d(TAG, e.toString());
			
		}
	  catch(IOException e)
		{
			Log.d(TAG, e.toString());
			
		}
	}
	public void copyDatabase(InputStream is, OutputStream os) throws IOException 
	  { 
		byte[] mBuffer = new byte[1024]; 
	    int mLength; 
	    while ((mLength = is.read(mBuffer))>0) 
	    { 
	    	os.write(mBuffer, 0, mLength); 
	    } 
	    
	    is.close();
	    os.close();
		
	  }
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.d(Helper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOUN);
		onCreate(db);
	}

}
