package com.taprify.musicservice.domain.vo.playerdto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.taprify.musicservice.domain.vo.musicdto.Music;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Player {
    private Device device;
    private String repeatState;
    private String shuffleState;
    private Context context;
    private Integer timeStamp;
    private Integer progressMs;
    private Boolean isPlaying;
    private Music item;
    private String currentlyPlayingType;
    private Actions actions;

    public Player() {
    }

    public Player(Device device, String repeatState, String shuffleState, Context context, Integer timeStamp, Integer progressMs, Boolean isPlaying, Music item, String currentlyPlayingType, Actions actions) {
        this.device = device;
        this.repeatState = repeatState;
        this.shuffleState = shuffleState;
        this.context = context;
        this.timeStamp = timeStamp;
        this.progressMs = progressMs;
        this.isPlaying = isPlaying;
        this.item = item;
        this.currentlyPlayingType = currentlyPlayingType;
        this.actions = actions;
    }

    public Boolean getPlaying() {
        return isPlaying;
    }

    public void setPlaying(Boolean playing) {
        isPlaying = playing;
    }

}
