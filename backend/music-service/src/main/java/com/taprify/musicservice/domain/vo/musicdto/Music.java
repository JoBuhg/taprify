package com.taprify.musicservice.domain.vo.musicdto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.taprify.musicservice.domain.vo.artistdto.Artist;
import com.taprify.musicservice.domain.vo.ExternalUrls;
import com.taprify.musicservice.domain.vo.albumdto.Album;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Music {

    // Getters e Setters
    private String id;
    private String name;
    private int durationMs;
    private int popularity;
    private Album album;
    private List<Artist> artists;
    private ExternalUrls externalUrls;
    private String previewUrl;
    private boolean explicit;
    private String href;

    public Music() {
    }

    public Music (ExternalUrls externalUrls, String previewUrl, boolean explicit, String href, int popularity, int durationMs, String name, String id) {
        this.externalUrls = externalUrls;
        this.previewUrl = previewUrl;
        this.explicit = explicit;
        this.href = href;
        this.popularity = popularity;
        this.durationMs = durationMs;
        this.name = name;
        this.id = id;
    }

}