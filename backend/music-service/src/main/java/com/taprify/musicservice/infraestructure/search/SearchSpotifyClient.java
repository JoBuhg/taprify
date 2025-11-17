package com.taprify.musicservice.infraestructure.search;

import com.taprify.musicservice.interfaces.rest.dto.search.SearchResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name= "SearchSpotifyClient",
        url = "https://api.spotify.com"
)
public interface SearchSpotifyClient {
    @GetMapping("/v1/search")
    SearchResponse search();
}

