package com.taprify.musicservice.interfaces.rest;

import com.taprify.musicservice.domain.vo.artistdto.Artist;
import com.taprify.musicservice.domain.vo.artistdto.ArtistAlbums;
import com.taprify.musicservice.domain.vo.artistdto.Artists;
import com.taprify.musicservice.domain.vo.musicdto.Tracks;
import com.taprify.musicservice.infraestructure.artist.ArtistSpotifyClient;
import com.taprify.musicservice.infraestructure.authentication.AuthSpotifyClient;
import com.taprify.musicservice.infraestructure.authentication.AuthSpotifyService;
import com.taprify.musicservice.interfaces.rest.dto.login.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
@RequestMapping("/spotify/api")
public class ArtistController {

    private final AuthSpotifyService spotifyProperties;
    private final ArtistSpotifyClient artistSpotifyClient;

    public ArtistController(AuthSpotifyService spotifyProperties,
                            ArtistSpotifyClient artistSpotifyClient) {
        this.spotifyProperties = spotifyProperties;
        this.artistSpotifyClient = artistSpotifyClient;
    }

    @GetMapping("artist/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable String id) {
        String token = "Bearer " + spotifyProperties.getValidAccessToken();
        Artist artist = artistSpotifyClient.getArtistById("Bearer " + token, id);
        return ResponseEntity.ok(artist);
    }

    @GetMapping("artist/{id}/albums")
    public ResponseEntity<ArtistAlbums> getArtistAlbums(@PathVariable String id) {
        String token = "Bearer " + spotifyProperties.getValidAccessToken();
        ArtistAlbums artistAlbums = artistSpotifyClient.getArtistAlbums("Bearer " + token, id);
        return ResponseEntity.ok(artistAlbums);
    }

    @GetMapping("/artist/multiple/{ids}")
    public ResponseEntity<Artists> getMultipleAlbums(@PathVariable("ids") String ids) {

       String token = "Bearer " + spotifyProperties.getValidAccessToken();
        Artists artistList = artistSpotifyClient.getMultipleArtists(
                "Bearer " + token,
                ids
        );
        return ResponseEntity.ok(artistList);
    }

    @GetMapping("/artist/{id}/top-tracks")
    public ResponseEntity<Tracks> getArtistTopTracks(@PathVariable("id") String id) {
        String token = "Bearer " + spotifyProperties.getValidAccessToken();
        Tracks artistTopTracks = artistSpotifyClient.getArtistTopTracks(
                "Bearer " + token,
                id
        );
        return ResponseEntity.ok(artistTopTracks);
    }

}
