package br.com.digitalhouse.searchview.model;

public class Person {
    private String image;
    private String name;
    private String profession;

    public Person() {
    }

    public Person(String image, String name, String profession) {
        this.image = image;
        this.name = name;
        this.profession = profession;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
