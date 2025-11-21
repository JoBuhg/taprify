package com.taprify.musicservice.infraestructure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "spotify")
public class SpotifyConfig {
    private String clientId;
    private String clientSecret;
    private String redirectUri;

    public SpotifyConfig() {
    }

    public SpotifyConfig(String clientId, String clientSecret, String redirectUri) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUri = redirectUri;
    }

}
