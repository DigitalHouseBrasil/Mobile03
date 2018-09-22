package br.com.digitalhouse.app.model;

public class Person {
    private String name;
    private String profession;

    public Person() {
    }

    public Person(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
