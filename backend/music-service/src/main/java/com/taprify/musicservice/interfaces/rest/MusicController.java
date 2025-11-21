package com.taprify.musicservice.interfaces.rest;

import com.taprify.musicservice.domain.vo.musicdto.Music;
import com.taprify.musicservice.domain.vo.albumdto.AlbumTracks;
import com.taprify.musicservice.domain.vo.musicdto.Tracks;
import com.taprify.musicservice.infraestructure.authentication.AuthSpotifyClient;
import com.taprify.musicservice.infraestructure.authentication.AuthSpotifyService;
import com.taprify.musicservice.infraestructure.music.MusicSpotifyClient;
import com.taprify.musicservice.interfaces.rest.dto.login.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@RequestMapping("/spotify/api")
public class MusicController {

    private final AuthSpotifyService spotifyProperties;
    private final MusicSpotifyClient musicSpotifyClient;

    public MusicController(AuthSpotifyService spotifyProperties,
                           MusicSpotifyClient musicSpotifyClient) {
        this.spotifyProperties = spotifyProperties;
        this.musicSpotifyClient = musicSpotifyClient;
    }

    @GetMapping("/tracks/{id}")
    public ResponseEntity<Music> getTrack(@PathVariable String id) {
        String token = "Bearer " + spotifyProperties.getValidAccessToken();

        Music track = musicSpotifyClient.getTrackById("Bearer " + token, id);
        return ResponseEntity.ok(track);
    }

    @GetMapping("/tracks/multiple/{ids}")
    public ResponseEntity<Tracks> getMultipleTracks(
            @PathVariable("ids") String ids) {

        String token = "Bearer " + spotifyProperties.getValidAccessToken();

        Tracks trackList = musicSpotifyClient.getMultipleTracks(
                "Bearer " + token,
                ids
        );

        return ResponseEntity.ok(trackList);
    }
}
