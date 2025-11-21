package com.taprify.musicservice.domain.vo.albumdto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Restrictions {
    private String reason;

    public Restrictions() {
    }

    public Restrictions(String reason) {
        this.reason = reason;
    }

}
