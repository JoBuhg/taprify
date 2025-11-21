package com.taprify.musicservice.domain.vo.albumdto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Albums {
    List<Album> albums;

    public Albums() {
    }

    public Albums(List<Album> albums) {
        this.albums = albums;
    }

}
