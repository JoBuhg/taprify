package com.taprify.musicservice.domain.vo.playerdto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Device {
    private String name;
    private String id;
    private Boolean isActive;
    private Boolean isPrivateSession;
    private Boolean isRestricted;
    private String type;
    private Integer volumePercent;
    private Boolean supportsVolume;

    public Device() {
    }

    public Device(String name, String id, Boolean isActive, Boolean isPrivateSession, Boolean isRestricted, String type, Integer volumePercent, Boolean supportsVolume) {
        this.name = name;
        this.id = id;
        this.isActive = isActive;
        this.isPrivateSession = isPrivateSession;
        this.isRestricted = isRestricted;
        this.type = type;
        this.volumePercent = volumePercent;
        this.supportsVolume = supportsVolume;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getPrivateSession() {
        return isPrivateSession;
    }

    public void setPrivateSession(Boolean privateSession) {
        isPrivateSession = privateSession;
    }

    public Boolean getRestricted() {
        return isRestricted;
    }

    public void setRestricted(Boolean restricted) {
        isRestricted = restricted;
    }

}