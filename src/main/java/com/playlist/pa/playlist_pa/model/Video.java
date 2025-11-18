package com.playlist.pa.playlist_pa.model;

import jakarta.persistence.*;

@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String url;
    private boolean liked;
    private boolean fav;

    public Video() {}

    public Video(String titulo, String url) {
        this.title = titulo;
        this.url = url;
        this.liked = false;
        this.fav = false;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public boolean isLiked() { return liked; }
    public void setLiked(boolean b) { this.liked = b; }

    public boolean isFav() { return fav; }
    public void setFav(boolean fav) { this.fav = fav; }
}
