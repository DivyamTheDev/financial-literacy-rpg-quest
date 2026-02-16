package com.example.demo.service;


import com.example.demo.model.Player;
import org.springframework.stereotype.Service;


@Service
public class HealthService {

    public String evaluate(Player p) {

        double net = p.getBalance() + p.getSavings() - p.getDebt();

        if (net < 0) return "CRITICAL";
        if (net < 100000) return "WEAK";
        if (net < 500000) return "STABLE";
        return "STRONG";
    }
}