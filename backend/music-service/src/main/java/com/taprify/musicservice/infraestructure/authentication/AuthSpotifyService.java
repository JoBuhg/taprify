package com.taprify.musicservice.infraestructure.authentication;

import com.taprify.musicservice.application.SpotifyAuth;
import com.taprify.musicservice.application.SpotifyAuthRepository;
import com.taprify.musicservice.infraestructure.SpotifyConfig;
import com.taprify.musicservice.interfaces.rest.dto.login.LoginResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;

@Service
public class AuthSpotifyService {

    private final AuthSpotifyClient authClient;
    private final SpotifyConfig props;
    private final SpotifyAuthRepository spotifyAuthRepository; // ✅ campo correto

    private String accessToken;
    private Instant expiresAt;
    private String refreshToken;

    public AuthSpotifyService(AuthSpotifyClient authClient,
                              SpotifyConfig props,
                              SpotifyAuthRepository spotifyAuthRepository) {
        this.authClient = authClient;
        this.props = props;
        this.spotifyAuthRepository = spotifyAuthRepository; // ✅ injeta via construtor

        // tenta carregar do banco ao iniciar
        spotifyAuthRepository.findById(1L).ifPresent(auth -> {
            this.accessToken = auth.getAccessToken();
            this.refreshToken = auth.getRefreshToken();
            this.expiresAt = auth.getExpiresAt();
        });
    }



    // LOGIN URL
    public String getLoginUrl() {
        return "https://accounts.spotify.com/authorize"
                + "?client_id=" + props.getClientId()
                + "&response_type=code"
                + "&redirect_uri=" + URLEncoder.encode(props.getRedirectUri(), StandardCharsets.UTF_8)
                + "&scope=" + URLEncoder.encode(
                "user-read-private user-read-email user-read-playback-state user-modify-playback-state user-read-currently-playing",
                StandardCharsets.UTF_8
        );
    }

    // --------------------------------------------
    // TROCA O CODE POR TOKEN
    // --------------------------------------------
    public LoginResponse exchangeCode(String code) {

        String basicAuth = Base64.getEncoder()
                .encodeToString((props.getClientId() + ":" + props.getClientSecret()).getBytes());

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("grant_type", "authorization_code");
        form.add("code", code);
        form.add("redirect_uri", props.getRedirectUri());

        LoginResponse response = authClient.exchangeCode(
                "Basic " + basicAuth,
                form
        );

        this.accessToken = response.getAccessToken();
        this.expiresAt = Instant.now().plusSeconds(response.getExpiresIn());
        this.refreshToken = response.getRefreshToken();

        SpotifyAuth authEntity = new SpotifyAuth();
        authEntity.setAccessToken(accessToken);
        authEntity.setRefreshToken(refreshToken);
        authEntity.setExpiresAt(expiresAt);

        spotifyAuthRepository.save(authEntity);

        return response;

    }

    // --------------------------------------------
    // TOKEN VÁLIDO (para chamadas à API do Spotify)
    // --------------------------------------------
    public String getValidAccessToken() {
        if (accessToken == null) {
            throw new IllegalStateException("Usuário não autenticado no Spotify. Faça login primeiro.");
        }

        if (Instant.now().isAfter(expiresAt)) {
            // tenta renovar automaticamente
            LoginResponse refreshed = refreshAccessToken();
            return refreshed.getAccessToken();
        }

        return accessToken;
    }

    // --------------------------------------------
    // REFRESH TOKEN FLOW
    // --------------------------------------------
    public LoginResponse refreshAccessToken() {
        if (refreshToken == null) {
            throw new IllegalStateException("Nenhum refresh token disponível. Usuário precisa autenticar novamente.");
        }

        String basicAuth = Base64.getEncoder()
                .encodeToString((props.getClientId() + ":" + props.getClientSecret()).getBytes());

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("grant_type", "refresh_token");
        form.add("refresh_token", refreshToken);

        LoginResponse response = authClient.exchangeCode("Basic " + basicAuth, form);

        this.accessToken = response.getAccessToken();
        this.expiresAt = Instant.now().plusSeconds(response.getExpiresIn());
        if (response.getRefreshToken() != null) {
            this.refreshToken = response.getRefreshToken();
        }

        SpotifyAuth authEntity = new SpotifyAuth();
        authEntity.setAccessToken(accessToken);
        authEntity.setRefreshToken(refreshToken);
        authEntity.setExpiresAt(expiresAt);

        spotifyAuthRepository.save(authEntity);

        return response;
    }
}
