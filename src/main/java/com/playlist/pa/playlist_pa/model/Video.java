package com.playlist.pa.playlist_pa.model;

import jakarta.persistence.*;

@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String url;
    private int likes;
    private boolean fav;

    public Video() {}

    public Video(String titulo, String url) {
        this.title = titulo;
        this.url = url;
        this.likes = 0;
        this.fav = false;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public int getLikes() { return likes; }
    public void setLikes(int likes) { this.likes = likes; }

    public boolean isFav() { return fav; }
    public void setFav(boolean fav) { this.fav = fav; }
}
