package com.example.sinki.database_connect;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.sinki.model.Lesson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
/**
 * Created by Sinki on 9/18/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dbMimiKaraOboeruN2.sqlite";
    public static final String DBLOCATION = "/databases/";
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDatabase() {
        if(checkDataBase() == false)
        {
            getReadableDatabase();
            //copy db
            if(!copyDatabase(mContext))
            {
                return;
            }
        }
        String dbPath = mContext.getDatabasePath(DATABASE_NAME).getPath();
        if (mDatabase != null && mDatabase.isOpen()) {
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDataBase() {
        if (mDatabase != null) {
            mDatabase.close();
        }
    }

    private boolean checkDataBase(){

        File database = mContext.getApplicationContext().getDatabasePath(DatabaseHelper.DATABASE_NAME);
        return database.exists();
    }

    private boolean copyDatabase(Context context)
    {
        try
        {
            InputStream inputStream = context.getAssets().open(DatabaseHelper.DATABASE_NAME);
            String outFileName = context.getApplicationInfo().dataDir + DatabaseHelper.DBLOCATION + DatabaseHelper.DATABASE_NAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[] buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff))>0)
            {
                outputStream.write(buff,0,length);
            }
            outputStream.flush();
            outputStream.close();
            Log.v("DATABASE","DB copied");
            return true;
        }
        catch (Exception ex)
        {
            Log.e("LOI",ex.toString());
            return false;
        }
    }

    public SQLiteDatabase getDatabase() {
        return mDatabase;
    }

    //    public ArrayList<Lesson> getListLesson() {
//        Lesson lesson = new Lesson();
//        ArrayList<Lesson> lessonList = new ArrayList<>();
//        openDatabase();
//        Cursor cursor = mDatabase.query("Lesson",null,null,null,null,null,null);
//        lessonList.clear();
//        while (cursor.moveToNext())
//        {
//            Lesson mlesson = new Lesson();
//            mlesson.setID(cursor.getInt(0));
//            mlesson.setLessonName(cursor.getString(1));
//            mlesson.setContain(cursor.getString(2));
//            lessonList.add(mlesson);
//        }
//        cursor.close();
//        closeDataBase();
//        return lessonList;
//    }
}
