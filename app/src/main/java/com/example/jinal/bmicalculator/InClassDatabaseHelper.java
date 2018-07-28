package com.example.jinal.bmicalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jinal on 2018-07-16.
 */

public class InClassDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "inclass";
    // name of the DB
    private static final int DB_VERSION = 1;  // version of the DB
    public static final String TABLE_NAME = "PERSON";  // name of the Table
    public static final String HISTORY_TABLE_NAME = "HISTORY";  // name of the Table

    public InClassDatabaseHelper(Context context){
        super(context,DB_NAME,null, DB_VERSION); // null is for cursors
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Date today = new Date(); // we want to start with some initial data
        db.execSQL("CREATE TABLE "+TABLE_NAME+" ("
                + "ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "PASSWORD TEXT, " // Never store passwords in clear text in real apps
                + "HEALTH_CARD_NUMB TEXT, "
                + "BDATE TEXT);");

        db.execSQL("CREATE TABLE "+HISTORY_TABLE_NAME +" ("
                + "ID INTEGER, "
                + "HEIGHT TEXT, "
                + "WEIGHT TEXT, "
                + "DATE TEXT, "
                + "BMI TEXT);");


//        ContentValues personValues = new ContentValues();
//        personValues.put("NAME", "Jinal Salvi");
//        personValues.put("PASSWORD", "123");
//                personValues.put("HEALTH_CARD_NUMB", "1234 5678 9101");
//                        personValues.put("BDATE", ""+today.getTime());
//        db.insert(TABLE_NAME,null, personValues);
    }

    public void createUser(PersonProfile personProfile){
        SQLiteDatabase db = this.getWritableDatabase();
        Date today = new Date(); // we want to start with some initial data

        ContentValues personValues = new ContentValues();
        personValues.put("NAME",personProfile.getName());
        personValues.put("PASSWORD", personProfile.getPassword());
        personValues.put("HEALTH_CARD_NUMB", personProfile.getHealthcard());
        personValues.put("BDATE", personProfile.getDate());
        db.insert(TABLE_NAME,null, personValues);

    }


    public void createHistory(PersonHistory personHistory){
        SQLiteDatabase db = this.getWritableDatabase();
        Date today = new Date(); // we want to start with some initial data
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ContentValues personValues = new ContentValues();
        personValues.put("ID",personHistory.getUserid());
        personValues.put("HEIGHT", personHistory.getHeight());
        personValues.put("WEIGHT", personHistory.getWeight());
        personValues.put("DATE", dateFormat.format(today));
        personValues.put("BMI", personHistory.getBmi());
        db.insert(HISTORY_TABLE_NAME,null, personValues);

    }




    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
