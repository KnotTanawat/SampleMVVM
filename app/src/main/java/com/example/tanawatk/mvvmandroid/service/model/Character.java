package com.example.tanawatk.mvvmandroid.service.model;

import com.example.tanawatk.mvvmandroid.base.Model;
import com.google.gson.annotations.SerializedName;

public class Character implements Model {

    @SerializedName("mal_id")
    private int mal_id;

    @SerializedName("url")
    private String url;

    @SerializedName("image_url")
    private String image_url;

    @SerializedName("name")
    private String name;

    @SerializedName("role")
    private String role;


    public int getMal_id() {
        return mal_id;
    }

    public void setMal_id(int mal_id) {
        this.mal_id = mal_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
