package com.cs544.model;


import java.io.Serializable;


public class Email implements Serializable {
    private String email;
    private String body;
    private String title;

    @Override
    public String toString() {
        return "Email{" +
                "email='" + email + '\'' +
                ", body='" + body + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
