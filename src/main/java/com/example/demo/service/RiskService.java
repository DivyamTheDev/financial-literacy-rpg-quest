package com.example.demo.service;

import com.example.demo.model.Player;
import org.springframework.stereotype.Service;


@Service
public class RiskService {

    public String evaluate(Player p) {

        if (p.getDebt() > p.getSavings() * 2) return "HIGH";
        if (p.getDebt() > p.getSavings()) return "MEDIUM";
        return "LOW";
    }
}
