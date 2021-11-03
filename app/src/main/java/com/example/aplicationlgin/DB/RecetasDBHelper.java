package com.example.aplicationlgin.DB;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.aplicationlgin.Model.Receta;

import java.util.ArrayList;

public class RecetasDBHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "recetas.db";


    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + tableRecetas.ContactsEntry.TABLE_NAME + "(" + tableRecetas.ContactsEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + tableRecetas.ContactsEntry.COLUMN_NAME_TITLE + " TEXT)";


    public RecetasDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase AplicationLginDatabase, int i, int i1) {

    }


    public void insertContact(SQLiteDatabase db, Receta c){
        //Check the bd is open
        if (db.isOpen()){
            //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the contacts getting all values
            values.put(tableRecetas.ContactsEntry.COLUMN_NAME_TITLE, c.getReceta());

            db.insert(tableRecetas.ContactsEntry.TABLE_NAME, null, values);
        }else{
            Log.i("sql","Database is closed");
        }
    }
   //The inserts are made in the table
   @SuppressLint("Range")
   public ArrayList<Receta> getAllData(SQLiteDatabase db){

            db=this.getWritableDatabase();
            Cursor cursor=db.rawQuery("SELECT * FROM recetas", null);
            ArrayList<Receta> rec= new ArrayList<>();
               if(cursor.moveToFirst()){
                   do{
                       rec.add(new Receta(cursor.getString(cursor.getColumnIndex("name"))));
                   }while (cursor.moveToNext());
               }

            return  rec;
    }

}
