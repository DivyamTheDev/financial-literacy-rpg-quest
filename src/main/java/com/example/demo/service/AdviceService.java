package com.example.demo.service;
import com.example.demo.model.Player;
import org.springframework.stereotype.Service;


@Service
public class AdviceService {

    public String generate(Player p, String risk, String health) {

        if ("HIGH".equals(risk))
            return "Reduce debt and avoid unnecessary spending.";

        if ("CRITICAL".equals(health))
            return "Focus on savings and stabilize finances.";

        if (p.getSavings() < 50000)
            return "Increase savings for financial security.";

        return "Financial condition is improving. Continue disciplined strategy.";
    }
}