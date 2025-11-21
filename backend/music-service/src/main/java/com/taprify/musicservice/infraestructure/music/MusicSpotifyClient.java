package com.taprify.musicservice.infraestructure.music;

import com.taprify.musicservice.domain.vo.musicdto.Music;
import com.taprify.musicservice.domain.vo.albumdto.AlbumTracks;
import com.taprify.musicservice.domain.vo.musicdto.Tracks;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "MusicSpotifyClient", url = "https://api.spotify.com")
public interface MusicSpotifyClient {


    @GetMapping("/v1/tracks/{id}")
    Music getTrackById(@RequestHeader("Authorization") String authorization,
                       @PathVariable("id") String trackId);

    @GetMapping("/v1/tracks")
    Tracks getMultipleTracks(@RequestHeader("Authorization") String authorization,
                             @RequestParam("ids") String ids);

}
