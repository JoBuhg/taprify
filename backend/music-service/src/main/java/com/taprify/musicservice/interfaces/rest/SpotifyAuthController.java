    package com.taprify.musicservice.interfaces.rest;

    import com.taprify.musicservice.infraestructure.authentication.AuthSpotifyService;
    import com.taprify.musicservice.interfaces.rest.dto.login.LoginResponse;
    import jakarta.servlet.http.HttpServletResponse;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.io.IOException;

    @RestController
    @RequestMapping("/spotify/api")
    public class SpotifyAuthController {

        private final AuthSpotifyService authService;

        public SpotifyAuthController(AuthSpotifyService authService) {
            this.authService = authService;
        }

        // Redirect user to Spotify login
        @GetMapping("/login")
        public void login(HttpServletResponse response) throws IOException {
            response.sendRedirect(authService.getLoginUrl());
        }


        // Callback endpoint: exchange code for tokens
        @GetMapping("/callback")
        public ResponseEntity<?> callback(@RequestParam("code") String code) {
            try {
                LoginResponse response = authService.exchangeCode(code);
                return ResponseEntity.ok(response);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Erro ao autenticar com Spotify: " + e.getMessage());
            }
        }

        // Refresh endpoint: renewaccess token using refresh token
        @GetMapping("/refresh")
        public ResponseEntity<?> refresh() {
            try {
                LoginResponse response = authService.refreshAccessToken();
                return ResponseEntity.ok(response);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Erro ao atualizar token: " + e.getMessage());
            }
        }
    }