package com.taprify.musicservice.domain.vo;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ExternalUrls {
    private String spotify;

    public ExternalUrls() {
    }

    public ExternalUrls(String spotify) {
        this.spotify = spotify;
    }

    public String getSpotify() { return spotify; }
    public void setSpotify(String spotify) { this.spotify = spotify; }

}
