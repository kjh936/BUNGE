package com.bunge.memo.domain;

public class ReadState {

    private String isbn13;
    private String id;
    private String state;

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ReadState{" +
                "isbn13='" + isbn13 + '\'' +
                ", id='" + id + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}