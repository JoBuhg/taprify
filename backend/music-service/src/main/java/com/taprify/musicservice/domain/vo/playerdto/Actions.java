package com.taprify.musicservice.domain.vo.playerdto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Actions {
    private boolean interruptingPlayback;
    private boolean seeking;
    private boolean skippingNext;
    private boolean skippingPrevious;
    private boolean pausing;
    private boolean resuming;
    private boolean togglingShuffle;
    private boolean togglingRepeat;

    public Actions() {
    }

    public Actions(boolean interruptingPlayback, boolean seeking, boolean skippingNext, boolean skippingPrevious, boolean pausing, boolean resuming, boolean togglingShuffle, boolean togglingRepeat) {
        this.interruptingPlayback = interruptingPlayback;
        this.seeking = seeking;
        this.skippingNext = skippingNext;
        this.skippingPrevious = skippingPrevious;
        this.pausing = pausing;
        this.resuming = resuming;
        this.togglingShuffle = togglingShuffle;
        this.togglingRepeat = togglingRepeat;
    }

}
