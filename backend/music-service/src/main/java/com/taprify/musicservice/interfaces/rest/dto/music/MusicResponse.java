package com.taprify.musicservice.interfaces.rest.dto.music;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MusicResponse {

    public MusicWrapper track;

    public MusicResponse() {
    }

    public MusicResponse(MusicWrapper track) {
        this.track = track;
    }

    public MusicWrapper getMusic() {
        return track;
    }

    public void setMusicItem(MusicWrapper track) {
        this.track = track;
    }
}
