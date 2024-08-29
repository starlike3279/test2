package org.example.article;

public class Article {
    private int id;
    private String title = "";
    private String content = "";

    public Article(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return this.id;
    }

    public String getSubject() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public void setSubject(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}