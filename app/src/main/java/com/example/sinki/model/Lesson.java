package com.example.sinki.model;

/**
 * Created by Sinki on 9/18/2017.
 */

public class Lesson {
    private int ID;
    private String lessonName;
    private String contain;

    public Lesson(int ID, String lessonName, String contain) {
        this.ID = ID;
        this.lessonName = lessonName;
        this.contain = contain;
    }

    public Lesson() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getContain() {
        return contain;
    }

    public void setContain(String contain) {
        this.contain = contain;
    }

    @Override
    public String toString() {
        return this.lessonName + " (" + this.contain + ")";
    }
}
