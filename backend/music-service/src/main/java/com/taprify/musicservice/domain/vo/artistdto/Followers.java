package com.taprify.musicservice.domain.vo.artistdto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Followers {
    private Integer total;

    public Followers() {
    }

    public Followers(Integer total) {
        this.total = total;
    }

}
