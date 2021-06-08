package Humans;

public class Writer {
    private String name;
    private String surName;
    private String nationality;
    private String genre;
    private String[] works;
    private int birthYear;
    private int deathYear;
    private boolean isDead = false;
    private boolean isMarried = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        if (birthYear > 0)
            this.birthYear = birthYear;
        else
            System.out.println("Invalid year of birth");
    }

    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        if (birthYear >= deathYear)
            System.out.println("Invalid deathYear");
        else
            this.deathYear = deathYear;
    }

    public void getWorks() {
        for (String s : works)
            System.out.println(s + "  ");
    }

    public void setWorks(String[] works) {
        this.works = works;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public void Write() {
        if (this.works.length > 0)
            System.out.println(this.works[0]);
        else
            System.out.println(" a b c d...");
    }

    public void IntroduceYourself() {
        System.out.printf("\n I am %s %s and I am %s writer", this.name, this.surName, this.genre);
    }
}
