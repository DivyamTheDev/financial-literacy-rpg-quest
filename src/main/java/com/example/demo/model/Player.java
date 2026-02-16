package com.example.demo.model;

import lombok.Data;

@Data
public class Player {

    private String id;
    private double balance;
    private double savings;
    private double debt;
    private int creditScore;
    private int month;
}
