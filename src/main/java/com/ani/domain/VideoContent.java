package com.ani.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class VideoContent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private long number;

    private String title;

    private String about;

    private String author;

    private String source;


    public VideoContent() {
    }

    public VideoContent(String title, String about, String author, String source) {
        this.title = title;
        this.about = about;
        this.author = author;
        this.source = source;
    }

    public VideoContent(long number, String title, String about, String author, String source) {
        this.number = number;
        this.title = title;
        this.about = about;
        this.author = author;
        this.source = source;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
