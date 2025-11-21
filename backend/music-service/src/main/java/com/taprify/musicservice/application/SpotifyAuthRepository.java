package com.taprify.musicservice.application;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotifyAuthRepository extends JpaRepository<SpotifyAuth, Long> {
}
