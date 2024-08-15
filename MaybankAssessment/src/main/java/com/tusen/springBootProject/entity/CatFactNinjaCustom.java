package com.tusen.springBootProject.entity;

public class CatFactNinjaCustom {

    private String message;

    private String currentDateTime;

    public CatFactNinjaCustom() {
    }

    public CatFactNinjaCustom(String message, String currentDateTime) {
        this.message = message;
        this.currentDateTime = currentDateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(String currentDateTime) {
        this.currentDateTime = currentDateTime;
    }
}
