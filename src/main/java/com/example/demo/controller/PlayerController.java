package com.example.demo.controller;

import com.example.demo.model.Player;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final Map<String, Player> database = new HashMap<>();

    @PostMapping("/create")
    public Player create() {

        Player p = new Player();
        p.setId(UUID.randomUUID().toString());
        p.setBalance(50000);
        p.setSavings(0);
        p.setDebt(0);
        p.setCreditScore(650);
        p.setMonth(0);

        database.put(p.getId(), p);

        return p;
    }

    public Map<String, Player> getDatabase() {
        return database;
    }
}
