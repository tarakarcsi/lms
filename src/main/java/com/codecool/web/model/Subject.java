package com.codecool.web.model;

public class Subject {

    private int subjectId;
    private String title;
    private String content;
    private boolean isPublished;

    public Subject(String title, String content, boolean isPublished, String subjectId) {
        this.title = title;
        this.content = content;
        this.isPublished = isPublished;
        this.subjectId = 0;
    }

    public Subject(String title, String content, boolean isPublished) {
        this.title = title;
        this.content = content;
        this.isPublished = isPublished;
        this.subjectId = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public int getSubjectId() {
        return subjectId;
    }
}
