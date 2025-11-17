package com.taprify.musicservice.domain.vo.albumdto;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.taprify.musicservice.domain.vo.Artist;
import com.taprify.musicservice.domain.vo.Image;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Album {

    private String id;
    private String name;
    private String releaseDate;
    private String totalTracks;
    private List<Artist> artists;
    private Tracks tracks;
    private Integer popularity;
    private String albumType;
    private String uri;
    private List<Image> images;

    public Album() {
    }

    public Album(String id, String name, String releaseDate, String totalTracks, List<Artist> artists, Tracks tracks, Integer popularity, String albumType, String uri, List<Image> images) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.totalTracks = totalTracks;
        this.artists = artists;
        this.tracks = tracks;
        this.popularity = popularity;
        this.albumType = albumType;
        this.uri = uri;
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTotalTracks() {
        return totalTracks;
    }

    public void setTotalTracks(String totalTracks) {
        this.totalTracks = totalTracks;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public Tracks getTracks() {
        return tracks;
    }

    public void setTracks(Tracks tracks) {
        this.tracks = tracks;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public String getAlbumType() {
        return albumType;
    }

    public void setAlbumType(String type) {
        this.albumType = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
