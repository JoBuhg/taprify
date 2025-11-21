package com.taprify.musicservice.domain.vo.artistdto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Artists {
    private List<Artist> artists;

    public Artists() {
    }

    public Artists(List<Artist> artists) {
        this.artists = artists;
    }

}
