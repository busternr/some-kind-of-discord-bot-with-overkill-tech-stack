package com.nikolayromanov.backend.models;

import java.util.ArrayList;

public class ResponseErrors<T> {
    public static final String INVALID = "invalid";

    ArrayList<T> errors = new ArrayList<>();

    public ArrayList<T> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<T> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ResponseErrors{" +
                "errors=" + errors +
                '}';
    }
}
