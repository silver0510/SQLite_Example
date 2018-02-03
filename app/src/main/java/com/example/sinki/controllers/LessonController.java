package com.example.sinki.controllers;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sinki.database_connect.DatabaseHelper;
import com.example.sinki.model.Lesson;

import java.util.ArrayList;

/**
 * Created by Sinki on 9/18/2017.
 */

public class LessonController {
    private DatabaseHelper databaseHelper;
    public LessonController(DatabaseHelper databaseHelper)
    {
        super();
        this.databaseHelper = databaseHelper;
    }
    public ArrayList<Lesson> getListLesson() {
        Lesson lesson = new Lesson();
        ArrayList<Lesson> lessonList = new ArrayList<>();
        databaseHelper.openDatabase();
        Cursor cursor = databaseHelper.getDatabase().query("Lesson",null,null,null,null,null,null);
        lessonList.clear();
        while (cursor.moveToNext())
        {
            Lesson mlesson = new Lesson();
            mlesson.setID(cursor.getInt(0));
            mlesson.setLessonName(cursor.getString(1));
            mlesson.setContain(cursor.getString(2));
            lessonList.add(mlesson);
        }
        cursor.close();
        databaseHelper.closeDataBase();
        return lessonList;
    }
}
