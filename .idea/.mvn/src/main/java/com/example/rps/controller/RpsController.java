package com.example.rps.controller;

import com.example.rps.service.RpsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RpsController {

    private final RpsService rpsService;

    public RpsController(RpsService rpsService) {
        this.rpsService = rpsService;
    }

    @GetMapping("/play")
    public String playGame() {
        return rpsService.playGames(100); // Play 100 rounds
    }
}
