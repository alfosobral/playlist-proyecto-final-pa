package com.playlist.pa.playlist_pa.controller;

import com.playlist.pa.playlist_pa.model.Video;
import com.playlist.pa.playlist_pa.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("videos", videoRepository.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addVideo(@RequestParam String title, @RequestParam String url) {// Convertir URL de YouTube a formato embed
        String embedUrl = normalizarUrl(url);

        Video newVideo = new Video();
        newVideo.setTitle(title);
        newVideo.setUrl(embedUrl);
        newVideo.setLikes(0);
        newVideo.setFav(false);

        videoRepository.save(newVideo);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteVideo(@PathVariable Long id) {
        videoRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/like/{id}")
    @ResponseBody
    public int likeVideo(@PathVariable Long id) {
        System.out.println("LIKE recibido para ID = " + id);
        var video = videoRepository.findById(id).orElse(null);
        if (video == null) {
            System.out.println("No se encontró el video");
            return -1;
        }

        int nuevosLikes = video.getLikes() + 1;
        video.setLikes(nuevosLikes);
        videoRepository.save(video);
        System.out.println("Likes actualizados a " + nuevosLikes);
        return nuevosLikes;
    }


    @GetMapping("/fav/{id}")
    public String toggleFav(@PathVariable Long id) {
        Video video = videoRepository.findById(id).orElse(null);
        if (video != null) {
            video.setFav(!video.isFav());
            videoRepository.save(video);
        }
        return "redirect:/";
    }

    private String normalizarUrl(String url) {
        String embedUrl = url;

        if (url.contains("watch?v=")) {
            embedUrl = url.replace("watch?v=", "embed/");
        } else if (url.contains("youtu.be/")) {
            embedUrl = url.replace("youtu.be/", "www.youtube.com/embed/");
        }

        int paramIndex = embedUrl.indexOf("&");
        if (paramIndex != -1) {
            embedUrl = embedUrl.substring(0, paramIndex);
        }

        return embedUrl;
    }
}
