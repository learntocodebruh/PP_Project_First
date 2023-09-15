package org.example;

public class Word {

    private int number;
    private int difficulty;
    private String term;
    private String definition;

    Word(){}

    Word(int number, int difficulty, String term, String definition) {

        this.number = number;
        this.difficulty = difficulty;
        this.term = term;
        this.definition = definition;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String toString() {

        String sdifficulty = "";

        for (int i = 0; i < difficulty; i++) sdifficulty += "*";

        String str = String.format("%-3s", sdifficulty) + String.format("%15s", term) + " " + definition;

        return str;
    }

    public String toFileString() {

        return this.difficulty + "|" + this.term + "|" + this.definition;
    }

}
