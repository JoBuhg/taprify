package com.taprify.musicservice.domain.vo.artistdto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.taprify.musicservice.domain.vo.ExternalUrls;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ArtistSummary {
    private ExternalUrls externalUrls;
    private String href;
    private String id;
    private String name;
    private String type;
    private String uri;

    public ArtistSummary() {}

    public ExternalUrls getexternalUrls() {
        return externalUrls;
    }

    public void setExternalUrls(ExternalUrls externalUrls) {}

}
