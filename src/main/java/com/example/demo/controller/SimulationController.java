package com.example.demo.controller;

import com.example.demo.model.Decision;
import com.example.demo.model.Player;
import com.example.demo.report.FinancialReport;
import com.example.demo.service.SimulationEngine;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class SimulationController {

    private final SimulationEngine engine;
    private final PlayerController playerController;

    @PostMapping("/play/{playerId}")
    public FinancialReport play(@PathVariable String playerId,
                                @RequestBody(required = false) Decision decision) {

        Player player = playerController.getDatabase().get(playerId);

        if (player == null)
            throw new RuntimeException("Player not found");

        return engine.runMonth(player, decision);
    }
}

