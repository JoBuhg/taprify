package com.taprify.musicservice.interfaces.rest;

import com.taprify.musicservice.domain.vo.playerdto.Player;
import com.taprify.musicservice.infraestructure.authentication.AuthSpotifyService;
import com.taprify.musicservice.infraestructure.player.PlayerSpotifyClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spotify/api/player")
public class PlayerController {

    private final AuthSpotifyService spotifyProperties;
    private final PlayerSpotifyClient playerSpotifyClient;

    public PlayerController(AuthSpotifyService spotifyProperties,
                            PlayerSpotifyClient playerSpotifyClient) {
        this.spotifyProperties = spotifyProperties;
        this.playerSpotifyClient = playerSpotifyClient;
    }

    // Informação do player
    @GetMapping("/information")
    public ResponseEntity<Player> getPlayer() {
        String token = "Bearer " + spotifyProperties.getValidAccessToken();
        Player player = playerSpotifyClient.getPlayer(token);
        return ResponseEntity.ok(player);
    }

    // Tocar uma faixa específica
    @PostMapping("/play")
    public ResponseEntity<String> playTrack(@RequestParam String trackId) {
        String token = "Bearer " + spotifyProperties.getValidAccessToken();
        playerSpotifyClient.playTrack(token, trackId);
        return ResponseEntity.ok("Playing track: " + trackId);
    }

    // Pausar
    @PostMapping("/pause")
    public ResponseEntity<String> pauseTrack() {
        String token = "Bearer " + spotifyProperties.getValidAccessToken();
        playerSpotifyClient.pauseTrack(token);
        return ResponseEntity.ok("Paused");
    }

    // Próxima faixa
    @PostMapping("/next")
    public ResponseEntity<String> nextTrack() {
        String token = "Bearer " + spotifyProperties.getValidAccessToken();
        playerSpotifyClient.nextTrack(token);
        return ResponseEntity.ok("Next track");
    }

    // Faixa anterior
    @PostMapping("/previous")
    public ResponseEntity<String> previousTrack() {
        String token = "Bearer " + spotifyProperties.getValidAccessToken();
        playerSpotifyClient.previousTrack(token);
        return ResponseEntity.ok("Previous track");
    }
}