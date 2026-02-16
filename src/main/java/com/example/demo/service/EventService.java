package com.example.demo.service;

import com.example.demo.model.Player;
import org.springframework.stereotype.Service;


import java.util.Random;

@Service
public class EventService {

    private final Random random = new Random();

    public void applyRandomEvent(Player player) {

        int event = random.nextInt(4);

        switch (event) {

            case 0: // Emergency expense
                player.setBalance(player.getBalance() - 10000);
                break;

            case 1: // Bonus
                player.setBalance(player.getBalance() + 20000);
                break;

            case 2: // Investment loss
                player.setSavings(player.getSavings() - 5000);
                break;

            case 3: // Medical emergency → debt
                player.setDebt(player.getDebt() + 15000);
                break;
        }
    }
}
