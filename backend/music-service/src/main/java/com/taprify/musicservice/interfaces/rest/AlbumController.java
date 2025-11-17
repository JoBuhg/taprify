package com.taprify.musicservice.interfaces.rest;

import com.taprify.musicservice.domain.vo.albumdto.Album;
import com.taprify.musicservice.infraestructure.album.AlbumSpotifyClient;
import com.taprify.musicservice.infraestructure.authentication.AuthSpotifyClient;
import com.taprify.musicservice.interfaces.rest.dto.login.LoginRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@RestController
@RequestMapping("/spotify/api")
public class AlbumController {

    private final AuthSpotifyClient spotifyProperties;
    private final AlbumSpotifyClient albumSpotifyClient;

   public AlbumController(AuthSpotifyClient spotifyProperties,
                          AlbumSpotifyClient albumSpotifyClient) {
        this.spotifyProperties = spotifyProperties;
       this.albumSpotifyClient = albumSpotifyClient;
   }

    @GetMapping("/albums/releases")
    public ResponseEntity<List<Album>> helloWorld(){
        var request = new LoginRequest(
               "client_credentials",
               "d0ba58067bba45738fcc1017d212e65a",
               "5ac8bd29ddcc486198e516b54a3c493b"
        );
        var token = spotifyProperties.login(request).getAccessToken();
        var response = albumSpotifyClient.getReleases("Bearer " + token);
        return ResponseEntity.ok(response.getAlbums().getItems());
    }

    @GetMapping("/albums/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable String id) {
        var request = new LoginRequest(
                "client_credentials",
                "d0ba58067bba45738fcc1017d212e65a",
                "5ac8bd29ddcc486198e516b54a3c493b"
        );
        var token = spotifyProperties.login(request).getAccessToken();
        Album album = albumSpotifyClient.getAlbumById("Bearer " + token, id);
        return ResponseEntity.ok(album);
    }

}
