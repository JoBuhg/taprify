package com.taprify.musicservice;

import com.taprify.musicservice.infraestructure.SpotifyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableConfigurationProperties(SpotifyConfig.class)
@SpringBootApplication
@EnableFeignClients
public class MusicServiceApplication {
       public static void main(String[] args) {
           SpringApplication.run(MusicServiceApplication.class, args);
    }
}
