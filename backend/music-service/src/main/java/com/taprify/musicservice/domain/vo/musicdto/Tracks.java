package com.taprify.musicservice.domain.vo.musicdto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Tracks {
    private List<Music> tracks;

    public Tracks() {
    }

    public Tracks(List<Music> tracks) {
        this.tracks = tracks;
    }

}
