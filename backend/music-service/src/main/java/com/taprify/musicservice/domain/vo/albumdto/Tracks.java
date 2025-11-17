package com.taprify.musicservice.domain.vo.albumdto;

import com.taprify.musicservice.domain.vo.Artist;
import com.taprify.musicservice.domain.vo.Music;

import java.util.List;

public class Tracks {
    private List<Album> album;
    private List<Artist> artists;
    private String href;
    private int limit;
    private int next;
    private int offset;
    private int previous;
    private int total;
    private List<Music> items;


    public Tracks() {
    }

    public Tracks(List<Album> album, List<Artist> artists, String href, int limit, int next, int offset, int previous, int total, List<Music> items) {
        this.album = album;
        this.artists = artists;
        this.href = href;
        this.limit = limit;
        this.next = next;
        this.offset = offset;
        this.previous = previous;
        this.total = total;
        this.items = items;
    }

    public List<Music> getItems() {
        return items;
    }

    public void setItems(List<Music> items) {
        this.items = items;
    }

    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getPrevious() {
        return previous;
    }

    public void setPrevious(int previous) {
        this.previous = previous;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

