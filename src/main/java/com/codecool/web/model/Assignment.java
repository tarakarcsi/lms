package com.codecool.web.model;

public class Assignment {
    private String id;
    private String title;
    private String content;
    private int maxScore;
    private boolean isPublished;

    public Assignment(String id, String title, String content, int maxScore, boolean isPublished) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.maxScore = maxScore;
        this.isPublished = isPublished;
    }

    public Assignment(String title, String content, int maxScore, boolean isPublished) {
        this.title = title;
        this.content = content;
        this.maxScore = maxScore;
        this.isPublished = isPublished;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public boolean isPublished() {
        return isPublished;
    }
}
