package com.example.demo.report;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FinancialReport {

    private String playerId;
    private double balance;
    private double savings;
    private double debt;
    private int creditScore;
    private String riskLevel;
    private String financialHealth;
    private String level;
    private String advice;
    private double netWorth;

}
