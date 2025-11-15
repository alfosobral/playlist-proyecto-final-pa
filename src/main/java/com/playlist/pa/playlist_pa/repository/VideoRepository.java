package com.playlist.pa.playlist_pa.repository;

import com.playlist.pa.playlist_pa.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}