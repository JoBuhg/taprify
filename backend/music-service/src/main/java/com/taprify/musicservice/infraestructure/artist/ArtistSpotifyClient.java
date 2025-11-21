package com.taprify.musicservice.infraestructure.artist;

import com.taprify.musicservice.domain.vo.albumdto.Albums;
import com.taprify.musicservice.domain.vo.artistdto.Artist;
import com.taprify.musicservice.domain.vo.artistdto.ArtistAlbums;
import com.taprify.musicservice.domain.vo.artistdto.Artists;
import com.taprify.musicservice.domain.vo.musicdto.Tracks;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "spotifyArtistClient",
        url = "https://api.spotify.com"
)
public interface ArtistSpotifyClient {

    @GetMapping(value = "/v1/artists/{id}")
    Artist getArtistById(@RequestHeader("Authorization") String authorization,
                         @PathVariable("id") String artistId);

    @GetMapping(value = "/v1/artists/{id}/albums")
    ArtistAlbums getArtistAlbums(@RequestHeader("Authorization") String authorization,
                                 @PathVariable("id") String artistId);

    @GetMapping("/v1/albums")
    Artists getMultipleArtists(@RequestHeader("Authorization") String authorization,
                               @RequestParam("ids") String ids);

    @GetMapping(value = "/v1/artists/{id}/top-tracks")
    Tracks getArtistTopTracks(@RequestHeader("Authorization") String authorization,
                         @PathVariable("id") String artistId);
}


