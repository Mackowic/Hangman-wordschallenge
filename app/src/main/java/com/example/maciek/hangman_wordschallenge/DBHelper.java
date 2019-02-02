package com.example.maciek.hangman_wordschallenge;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciek on 2017-01-23.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static String DB_PATH = "/data/data/com.example.maciek.hangman_wordschallenge/databases/";

    private static String DB_NAME = "db.db";

    private SQLiteDatabase myDataBase;

    private final Context myContext;

    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */
    public DBHelper(Context context) {

        super(context, DB_NAME, null, 1);
        this.myContext = context;
    }

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     * */
    public void createDataBase() throws IOException{

        boolean dbExist = checkDataBase();

        if(dbExist){
            //do nothing - database already exist
        }else{

            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();

            try {

                copyDataBase();

            } catch (IOException e) {

                throw new Error("Error copying database");

            }
        }

    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase(){

        SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }catch(SQLiteException e){

            //database does't exist yet.

        }

        if(checkDB != null){

            checkDB.close();

        }

        return checkDB != null ? true : false;
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     * */
    private void copyDataBase() throws IOException{

        //Open your local db as the input stream
        InputStream myInput = myContext.getAssets().open(DB_NAME);

        // Path to the just created empty db
        String outFileName = DB_PATH + DB_NAME;

        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }

        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException {

        //Open the database
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {

        if(myDataBase != null)
            myDataBase.close();

        super.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //metoda do wyswietlanaia panstwa z tabeli panstwa
    public String wyswietlpanstwo(int id){


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c;
        try {
            c = db.rawQuery("SELECT * FROM panstwa where _id="+id, null);

            if (c == null) {
                Log.i("blad bazy","");
            }
            c.moveToFirst();

                int Id = c.getInt(c.getColumnIndex("_id"));
                String panstwo= c.getString(c.getColumnIndex("panstwo"));
                String kontynent = c.getString(c.getColumnIndex("kontynent"));
                Log.i("panstwa",Id+panstwo+kontynent);


            c.close();
            db.close();
            return panstwo;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return"";

    }
//metoda do wyswietlanaia imienia z tabeli imiona
    public String wyswietlimie(int id){


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c;
        try {
            c = db.rawQuery("SELECT * FROM imiona where _id="+id, null);

            if (c == null) {
                Log.i("blad bazy","");
            }
            c.moveToFirst();

            int Id = c.getInt(c.getColumnIndex("_id"));
            String imie= c.getString(c.getColumnIndex("imie"));
            String plec = c.getString(c.getColumnIndex("plec"));



            c.close();
            db.close();
            return imie;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return"";

    }

//metoda do wyswietlania danych z statystyk
    public int[] wyswietldane(){


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c;
        try {
            c = db.rawQuery("SELECT * FROM statystyki where _id=1", null);

            if (c == null) {
                Log.i("blad bazy","");
            }
            c.moveToFirst();

            int Id = c.getInt(c.getColumnIndex("_id"));
            int wygrane= c.getInt(c.getColumnIndex("wygrane"));
            int przegrane = c.getInt(c.getColumnIndex("przegrane"));

            int[]tab={wygrane,przegrane};

            c.close();
            db.close();
            return tab;
        } catch (Exception e) {
            e.printStackTrace();
        }
int[]tab1={};
        return tab1;

    }

    //metoda do resetowania statystyk
    public void resetujdane(){


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c;
        try {
            c = db.rawQuery("UPDATE statystyki set wygrane=0 , przegrane=0 where _id=1", null);

            if (c == null) {
                Log.i("blad bazy","");
            }
            c.moveToFirst();

            c.close();
            db.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    //metoda do updatowania wygranych
    public void ustawwygrane(int wygrane){


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c;
        try {
            c = db.rawQuery("UPDATE statystyki set wygrane="+wygrane+" where _id=1", null);

            if (c == null) {
                Log.i("blad bazy","");
            }
            c.moveToFirst();

            c.close();
            db.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
//metoda do updatowania przegranych
    public void ustawprzegrane(int przegrane){


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c;
        try {
            c = db.rawQuery("UPDATE statystyki set  przegrane="+przegrane+" where _id=1", null);

            if (c == null) {
                Log.i("blad bazy","");
            }
            c.moveToFirst();

            c.close();
            db.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}

