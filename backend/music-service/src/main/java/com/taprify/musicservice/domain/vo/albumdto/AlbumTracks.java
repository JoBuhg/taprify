package com.taprify.musicservice.domain.vo.albumdto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.taprify.musicservice.domain.vo.musicdto.Music;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AlbumTracks {
    private String href;
    private List<Music> items;
    private int limit;
    private String next;
    private int offset;
    private String previous;
    private int total;

    public AlbumTracks() {
    }

    public AlbumTracks(String href, List<Music> items, int limit, String next, int offset, String previous, int total) {
        this.href = href;
        this.items = items;
        this.limit = limit;
        this.next = next;
        this.offset = offset;
        this.previous = previous;
        this.total = total;
    }

}

