package com.taprify.musicservice.domain.vo;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Image {
    private String url;
    private Integer height;
    private Integer width;

    public Image() {
    }

    public Image(String url, Integer height, Integer width) {
        this.url = url;
        this.height = height;
        this.width = width;
    }

}
