package com.taprify.musicservice.interfaces.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/spotify/api/login";
    }

    @GetMapping("/spotify/api")
    public String redirectToLogin2() {
        return "redirect:/spotify/api/login";
    }

}
