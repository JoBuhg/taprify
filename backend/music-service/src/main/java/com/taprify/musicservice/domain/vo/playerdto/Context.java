package com.taprify.musicservice.domain.vo.playerdto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.taprify.musicservice.domain.vo.ExternalUrls;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Context {
    private String type;
    private String uri;
    private String href;
    private ExternalUrls externalUrls;

    public Context() {
    }

    public Context(String type, String uri, String href, ExternalUrls externalUrls) {
        this.type = type;
        this.uri = uri;
        this.href = href;
        this.externalUrls = externalUrls;
    }

}

