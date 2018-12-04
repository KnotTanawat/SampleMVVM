package com.example.tanawatk.mvvmandroid.service.model;

import com.example.tanawatk.mvvmandroid.base.Model;
import com.google.gson.annotations.SerializedName;

public class News implements Model {

    @SerializedName("url")
    private String url;

    @SerializedName("title")
    private String title;

    @SerializedName("date")
    private String date;

    @SerializedName("author_name")
    private String author_name;

    @SerializedName("author_url")
    private String author_url;

    @SerializedName("forum_url")
    private String forum_url;

    @SerializedName("image_url")
    private String image_url;

    @SerializedName("comments")
    private int comments;

    @SerializedName("intro")
    private String intro;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_url() {
        return author_url;
    }

    public void setAuthor_url(String author_url) {
        this.author_url = author_url;
    }

    public String getForum_url() {
        return forum_url;
    }

    public void setForum_url(String forum_url) {
        this.forum_url = forum_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
