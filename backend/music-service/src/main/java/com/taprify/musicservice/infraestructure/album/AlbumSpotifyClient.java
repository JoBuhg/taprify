package com.taprify.musicservice.infraestructure.album;

import com.taprify.musicservice.domain.vo.albumdto.Album;
import com.taprify.musicservice.domain.vo.albumdto.AlbumTracks;
import com.taprify.musicservice.domain.vo.albumdto.Albums;
import com.taprify.musicservice.interfaces.rest.dto.album.AlbumResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "AlbumSpotifyClient", url = "https://api.spotify.com")
public interface AlbumSpotifyClient {

    @GetMapping(value = "/v1/browse/new-releases")
    AlbumResponse getReleases(@RequestHeader("Authorization") String authorization);

    @GetMapping(value = "/v1/albums/{id}")
    Album getAlbumById(@RequestHeader("Authorization") String authorization,
                              @PathVariable("id") String albumId);

    @GetMapping(value = "/v1/albums/{id}/tracks")
    AlbumTracks getAlbumTracks(@RequestHeader("Authorization") String authorization,
                               @PathVariable("id") String albumId);

    @GetMapping("/v1/albums")
    Albums getMultipleAlbums(@RequestHeader("Authorization") String authorization,
                             @RequestParam("ids") String ids);
}
