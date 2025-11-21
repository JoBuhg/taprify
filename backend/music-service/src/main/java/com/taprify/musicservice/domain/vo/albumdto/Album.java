package com.taprify.musicservice.domain.vo.albumdto;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.taprify.musicservice.domain.vo.ExternalUrls;
import com.taprify.musicservice.domain.vo.artistdto.Artist;
import com.taprify.musicservice.domain.vo.Image;
import com.taprify.musicservice.domain.vo.artistdto.ArtistSummary;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Album {

    private String albumType;
    private int totalTracks;
    private ExternalUrls externalUrls;
    private String href;
    private String id;
    private List<Image> images;
    private String name;
    private String releaseDate;
    private String releaseDatePrecision;
    private Restrictions restrictions;
    private String type;
    private String uri;
    private List<ArtistSummary> artists;
    private String albumGroup;

    public Album() {
    }

    public Album(String albumType, int totalTracks, ExternalUrls externalUrls, String href, String id, List<Image> images, String name, String releaseDate, String releaseDatePrecision, Restrictions restrictions, String type, String uri, List<ArtistSummary> artists, String albumGroup) {
        this.albumType = albumType;
        this.totalTracks = totalTracks;
        this.externalUrls = externalUrls;
        this.href = href;
        this.id = id;
        this.images = images;
        this.name = name;
        this.releaseDate = releaseDate;
        this.releaseDatePrecision = releaseDatePrecision;
        this.restrictions = restrictions;
        this.type = type;
        this.uri = uri;
        this.artists = artists;
        this.albumGroup = albumGroup;
    }

}
