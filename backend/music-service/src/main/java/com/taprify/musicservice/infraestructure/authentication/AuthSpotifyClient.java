package com.taprify.musicservice.infraestructure.authentication;

import com.taprify.musicservice.interfaces.rest.dto.login.LoginResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "authSpotifyClient",
        url = "https://accounts.spotify.com"
)
public interface AuthSpotifyClient {

    @PostMapping(
            value = "/api/token",
            consumes = "application/x-www-form-urlencoded"
    )
    LoginResponse exchangeCode(
            @RequestHeader("Authorization") String authorization,
            @RequestBody MultiValueMap<String, String> formData
    );

    @PostMapping(
            value = "/api/token",
            consumes = "application/x-www-form-urlencoded"
    )
    LoginResponse refreshToken(
            @RequestHeader("Authorization") String authorization,
            @RequestBody MultiValueMap<String, String> formData
    );
}
