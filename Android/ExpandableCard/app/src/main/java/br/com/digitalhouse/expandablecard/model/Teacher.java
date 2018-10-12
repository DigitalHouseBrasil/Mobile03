package br.com.digitalhouse.expandablecard.model;

public class Teacher {
    private String name;
    private String time;
    private String lesson;

    public Teacher() {
    }

    public Teacher(String name, String time, String lesson) {
        this.name = name;
        this.time = time;
        this.lesson = lesson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }
}
