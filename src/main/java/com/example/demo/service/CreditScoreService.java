package com.example.demo.service;

import com.example.demo.model.Player;
import org.springframework.stereotype.Service;


@Service
public class CreditScoreService {

    public void update(Player p) {

        int score = 650;

        if (p.getDebt() > 200000) score -= 100;
        if (p.getSavings() > 100000) score += 50;
        if (p.getBalance() < 0) score -= 50;

        p.setCreditScore(score);
    }
}