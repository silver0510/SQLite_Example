package com.example.sinki.sqlite_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sinki.controllers.LessonController;
import com.example.sinki.database_connect.DatabaseHelper;
import com.example.sinki.model.Lesson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvLesson;
    private ArrayList<Lesson>dsLesson;
    private ArrayAdapter<Lesson>adapterLesson;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addcontrols();
        addEvents();
    }

    private void addEvents() {

    }

    private void addcontrols() {
        databaseHelper = new DatabaseHelper(this);
        LessonController lessonController = new LessonController(databaseHelper);

        lvLesson = (ListView) findViewById(R.id.lvLesson);
        dsLesson = lessonController.getListLesson();
        adapterLesson = new ArrayAdapter<Lesson>(MainActivity.this,android.R.layout.simple_list_item_1,dsLesson);
        lvLesson.setAdapter(adapterLesson);
    }

}
