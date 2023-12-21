package com.example.demo;

public class Links{
    public String self;
    public String git;
    public String html;

    @Override
    public String toString() {
        return "Links{" +
                "self='" + self + '\'' +
                ", git='" + git + '\'' +
                ", html='" + html + '\'' +
                '}';
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}