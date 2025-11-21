package com.taprify.musicservice.domain.vo.artistdto;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Artist {
    private String name;
    private String id;
    private Followers followers;



    public Artist() {
    }

    public Artist(String name, String id) {
        this.name = name;
        this.id = id;
    }

}
