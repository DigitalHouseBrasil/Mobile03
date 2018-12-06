package br.com.digitalhouse.app.model;

import android.support.annotation.NonNull;

public class Person implements Comparable<Person> {
    private String name;
    private String profession;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
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

    @Override
    public int compareTo(@NonNull Person outraPessoa) {
        return this.getName().compareTo(outraPessoa.getName());
    }
}
