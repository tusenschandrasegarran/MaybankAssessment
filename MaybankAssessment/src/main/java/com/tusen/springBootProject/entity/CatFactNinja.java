package com.tusen.springBootProject.entity;

public class CatFactNinja {

    private String fact;
    private int length;

    public CatFactNinja() {
    }

    public CatFactNinja(String fact, int length) {
        this.fact = fact;
        this.length = length;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
