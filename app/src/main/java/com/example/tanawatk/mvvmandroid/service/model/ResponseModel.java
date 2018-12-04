package com.example.tanawatk.mvvmandroid.service.model;

import com.example.tanawatk.mvvmandroid.base.Model;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseModel implements Model {

    @SerializedName("request_hash")
    private String request_hash;

    @SerializedName("request_cached")
    private Boolean request_cached;

    @SerializedName("request_cache_expiry")
    private int request_cache_expiry;

    @SerializedName("character")
    private ArrayList<Character> character;

    @SerializedName("articles")
    private ArrayList<News> articles;

    public String getRequest_hash() {
        return request_hash;
    }

    public void setRequest_hash(String request_hash) {
        this.request_hash = request_hash;
    }

    public Boolean getRequest_cached() {
        return request_cached;
    }

    public void setRequest_cached(Boolean request_cached) {
        this.request_cached = request_cached;
    }

    public int getRequest_cache_expiry() {
        return request_cache_expiry;
    }

    public void setRequest_cache_expiry(int request_cache_expiry) {
        this.request_cache_expiry = request_cache_expiry;
    }

    public ArrayList<Character> getCharacter() {
        return character;
    }

    public void setCharacter(ArrayList<Character> character) {
        this.character = character;
    }

    public ArrayList<News> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<News> articles) {
        this.articles = articles;
    }
}
