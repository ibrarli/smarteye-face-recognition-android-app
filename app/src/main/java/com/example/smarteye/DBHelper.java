package com.example.smarteye;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {
    // database details
    private static final String DATABASE_NAME = "SEDatabase";
    private static final int DATABASE_VERSION = 1;
    private static final String FORM_TABLE = "formTable";
    private static final String FORM_ID = "formID";
    private static final String FORM_NAME = "name";
    private static final String FORM_RELATIONSHIP = "relationship";
    private static final String FORM_ADD_INFO = "additionalInfo";



    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT )", FORM_TABLE, FORM_ID, FORM_NAME, FORM_RELATIONSHIP, FORM_ADD_INFO);
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ FORM_TABLE);
        onCreate(db);
    }

    public Boolean insertFormData(String name, String relationship, String addInfo){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValuesForm = new ContentValues();
        contentValuesForm.put(FORM_NAME,name);
        contentValuesForm.put(FORM_RELATIONSHIP,relationship);
        contentValuesForm.put(FORM_ADD_INFO, addInfo);
        long result = sqLiteDatabase.insert(FORM_TABLE,null,contentValuesForm);
        return result != -1;
    }

    @SuppressLint("Range")
    public ArrayList<HashMap<String,Object>> getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<HashMap<String,Object>> data = new ArrayList<>();
        String query = "SELECT * FROM " + FORM_TABLE;
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()){
            HashMap<String, Object> row = new HashMap<>();
            row.put("name",cursor.getString(cursor.getColumnIndex(FORM_NAME)));
            row.put("relationship",cursor.getBlob(cursor.getColumnIndex(FORM_RELATIONSHIP)));
            row.put("addInfo",cursor.getInt(cursor.getColumnIndex(FORM_ADD_INFO)));
            row.put("id",cursor.getInt(cursor.getColumnIndex(FORM_ID)));
            data.add(row);
        }
        db.close();
        return data;
    }

}
