package com.example.demo.model;
import lombok.Data;

@Data
public class Decision {

    private String type; // SAVE, INVEST, SPEND, LOAN
    private double amount;
}
