package com.example.demo.service;

import com.example.demo.model.Player;
import org.springframework.stereotype.Service;

@Service
public class FinancialScoreService {
    public int calculate(Player p){
        int score =50;
        score+=p.getSavings()/10000;
        score-=p.getDebt()/20000;
        score+= p.getCreditScore()/20;
        if (score>100)score =100;
        if (score <0)score =0;
         return score;
    }
}
