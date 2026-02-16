package com.example.demo.service;

import com.example.demo.model.Decision;
import com.example.demo.model.Player;
import com.example.demo.report.FinancialReport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SimulationEngine {

    private final EventService eventService;
    private final RiskService riskService;
    private final HealthService healthService;
    private final CreditScoreService creditService;
    private final AdviceService adviceService;

    public FinancialReport runMonth(Player player, Decision decision) {

        player.setMonth(player.getMonth() + 1);

        // Apply salary
        player.setBalance(player.getBalance() + 50000);

        // Apply random life event
        eventService.applyRandomEvent(player);

        // Apply player decision
        applyDecision(player, decision);

        // Update credit score
        creditService.update(player);

        // Calculate risk & health
        String risk = riskService.evaluate(player);
        String health = healthService.evaluate(player);

        // Determine level
        String level = calculateLevel(player);

        // Generate advice
        String advice = adviceService.generate(player, risk, health);
        double netWorth = player.getBalance() + player.getSavings() - player.getDebt();
        return new FinancialReport(
                player.getId(),
                player.getBalance(),
                player.getSavings(),
                player.getDebt(),
                player.getCreditScore(),
                risk,
                health,
                level,
                advice,
                netWorth
        );
    }

    private void applyDecision(Player player, Decision decision) {

        if (decision == null) return;

        switch (decision.getType()) {

            case "SAVE":
                player.setBalance(player.getBalance() - decision.getAmount());
                player.setSavings(player.getSavings() + decision.getAmount());
                break;

            case "INVEST":
                player.setBalance(player.getBalance() - decision.getAmount());
                player.setSavings(player.getSavings() + decision.getAmount() * 1.2);
                break;

            case "SPEND":
                player.setBalance(player.getBalance() - decision.getAmount());
                break;

            case "LOAN":
                player.setDebt(player.getDebt() + decision.getAmount());
                player.setBalance(player.getBalance() + decision.getAmount());
                break;
        }
    }

    private String calculateLevel(Player p) {

        double netWorth = p.getBalance() + p.getSavings() - p.getDebt();

        if (netWorth < 0) return "BROKE";
        if (netWorth < 100000) return "STABLE";
        if (netWorth < 500000) return "GROWING";
        if (netWorth < 1000000) return "INVESTOR";
        return "WEALTHY";
    }
    private String gameStatus(Player p) {
        if (p.getDebt() > 500000) return "BANKRUPT";
        if (p.getSavings() > 1000000) return "FINANCIALLY FREE";
        return "IN PROGRESS";
    }


}