package com.taprify.musicservice.interfaces.rest;

import com.taprify.musicservice.domain.vo.Music;
import com.taprify.musicservice.infraestructure.authentication.AuthSpotifyClient;
import com.taprify.musicservice.infraestructure.music.MusicSpotifyClient;
import com.taprify.musicservice.interfaces.rest.dto.login.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spotify/api")
public class MusicController {

    private final AuthSpotifyClient spotifyProperties;
    private final MusicSpotifyClient musicSpotifyClient;

    public MusicController(AuthSpotifyClient spotifyProperties,
                           MusicSpotifyClient musicSpotifyClient) {
        this.spotifyProperties = spotifyProperties;
        this.musicSpotifyClient = musicSpotifyClient;
    }

    @GetMapping("/tracks/{id}")
    public ResponseEntity<Music> getTrack(@PathVariable String id) {
        var request = new LoginRequest(
                "client_credentials",
                "d0ba58067bba45738fcc1017d212e65a",
                "5ac8bd29ddcc486198e516b54a3c493b"
        );
        var token = spotifyProperties.login(request).getAccessToken();
        Music track = musicSpotifyClient.getTrackById("Bearer " + token, id);
        return ResponseEntity.ok(track);
    }
}
