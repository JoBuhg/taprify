package com.taprify.musicservice.infraestructure.music;

import com.taprify.musicservice.domain.vo.Music;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "MusicSpotifyClient", url = "https://api.spotify.com")
public interface MusicSpotifyClient {

    @GetMapping("/v1/tracks")
    Music getMultipleTracks(@RequestHeader("Authorization") String authorization);

    @GetMapping("/v1/tracks/{id}")
    Music getTrackById(@RequestHeader("Authorization") String authorization,
                       @PathVariable("id") String trackId);


}
