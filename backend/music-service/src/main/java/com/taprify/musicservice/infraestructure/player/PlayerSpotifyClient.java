package com.taprify.musicservice.infraestructure.player;

import com.taprify.musicservice.domain.vo.playerdto.Player;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "PlayerSpotifyClient", url = "https://api.spotify.com")
public interface PlayerSpotifyClient {

    // Estado atual do player
    @GetMapping("/v1/me/player")
    Player getPlayer(@RequestHeader("Authorization") String authorization);

    // Tocar uma faixa específica
    @PutMapping("/v1/me/player/play")
    void playTrack(@RequestHeader("Authorization") String authorization,
                   @RequestBody String body);

    // Pausar
    @PutMapping("/v1/me/player/pause")
    void pauseTrack(@RequestHeader("Authorization") String authorization);

    // Próxima faixa
    @PostMapping("/v1/me/player/next")
    void nextTrack(@RequestHeader("Authorization") String authorization);

    // Faixa anterior
    @PostMapping("/v1/me/player/previous")
    void previousTrack(@RequestHeader("Authorization") String authorization);
}