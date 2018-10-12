package br.com.digitalhouse.expandablecard.model;

import java.util.List;

public class ColearningDay {
    private String title;
    private List<Teacher> teachers;

    public ColearningDay() {
    }

    public ColearningDay(String title, List<Teacher> teachers) {
        this.title = title;
        this.teachers = teachers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
