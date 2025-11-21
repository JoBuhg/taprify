package com.taprify.musicservice.interfaces.rest;

import com.taprify.musicservice.domain.vo.albumdto.Album;
import com.taprify.musicservice.domain.vo.albumdto.AlbumTracks;
import com.taprify.musicservice.domain.vo.albumdto.Albums;
import com.taprify.musicservice.domain.vo.musicdto.Tracks;
import com.taprify.musicservice.infraestructure.album.AlbumSpotifyClient;
import com.taprify.musicservice.infraestructure.authentication.AuthSpotifyClient;
import com.taprify.musicservice.infraestructure.authentication.AuthSpotifyService;
import com.taprify.musicservice.interfaces.rest.dto.login.LoginRequest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Base64;
import java.util.List;


@RestController
@RequestMapping("/spotify/api")
public class AlbumController {

    private final AuthSpotifyService spotifyProperties;
    private final AlbumSpotifyClient albumSpotifyClient;

   public AlbumController(AuthSpotifyService spotifyProperties,
                          AlbumSpotifyClient albumSpotifyClient) {
        this.spotifyProperties = spotifyProperties;
       this.albumSpotifyClient = albumSpotifyClient;
   }

    @GetMapping("/albums/releases")
    public ResponseEntity<List<Album>> helloWorld(){

        String token = "Bearer " + spotifyProperties.getValidAccessToken();
        var response = albumSpotifyClient.getReleases("Bearer " + token);
        return ResponseEntity.ok(response.getAlbums().getItems());
    }

    @GetMapping("/albums/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable String id) {
        String token = "Bearer " + spotifyProperties.getValidAccessToken();

        Album album = albumSpotifyClient.getAlbumById("Bearer " + token, id);
        return ResponseEntity.ok(album);
    }

    @GetMapping("/albums/{id}/tracks")
    public ResponseEntity<AlbumTracks> getAlbumTracks(@PathVariable String id) {
        String token = "Bearer " + spotifyProperties.getValidAccessToken();

        AlbumTracks albumTracks = albumSpotifyClient.getAlbumTracks("Bearer " + token, id);
        return ResponseEntity.ok(albumTracks);
    }

    @GetMapping("/albums/multiple/{ids}")
    public ResponseEntity<Albums> getMultipleAlbums(@PathVariable("ids") String ids) {

        String token = "Bearer " + spotifyProperties.getValidAccessToken();

        Albums albumList = albumSpotifyClient.getMultipleAlbums(
                "Bearer " + token,
                ids
        );
        return ResponseEntity.ok(albumList);
    }

}
