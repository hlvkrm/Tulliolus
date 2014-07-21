package tulliolus.words;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Dictionary {
	SQLiteDatabase Words;
	
	public Dictionary(SQLiteDatabase Words){
		
		this.Words = Words;
	}
	public String define(Word word){
		String definition;
		String instance = word.getInstance();
		
		Cursor cursor = Words.rawQuery("SELECT definition FROM Word WHERE Instance = \'"+instance+"\'", null);
		cursor.moveToFirst();
		definition = cursor.getString(0);
		cursor.close();

		return definition;
		
	}

		
}
