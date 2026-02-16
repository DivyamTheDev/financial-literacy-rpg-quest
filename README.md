# Financial Literacy RPG Quest

A simulation-based financial learning platform that teaches real-world money management through gameplay.

## Features
- Financial life simulation
- Save, Invest, Spend, Loan decisions
- Credit score calculation
- Risk & financial health evaluation
- Random life events
- AI-based financial advice
- Net worth progression system
- REST API based gameplay

## Tech Stack
- Java
- Spring Boot
- Lombok
- REST API

## API

### Create Player
POST /player/create

### Play Month
POST /game/play/{playerId}

Body:
{
  "type": "SAVE | INVEST | SPEND | LOAN",
  "amount": 10000
}

## Output
- Balance
- Savings
- Debt
- Credit Score
- Risk Level
- Financial Health
- Advice
- Net Worth Level

## Learning Outcome
This project simulates real financial decision-making and helps understand:
- Savings discipline
- Debt risk
- Investment growth
- Financial stability management

## Author
Divyam Chaudhary
