package com.example.demo7.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    private String ISBN;
    private String title;
    private String subeject;
    private String publisher;
    private String language;
    private String numberOfPage;
    // getters and setters goes here...


    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(String numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubeject() {
        return subeject;
    }

    public void setSubeject(String subeject) {
        this.subeject = subeject;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}