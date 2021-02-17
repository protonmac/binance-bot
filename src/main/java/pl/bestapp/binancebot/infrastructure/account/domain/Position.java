package pl.bestapp.binancebot.infrastructure.account.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Position {
    private String name;
    private Double amount;
    private Date purchaseDate;
    private BigDecimal value;

    public Position(String name, Double amount, Date purchaseDate, BigDecimal value) {
        this.name = name;
        this.amount = amount;
        this.purchaseDate = purchaseDate;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Double getAmount() {
        return amount;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public BigDecimal getValue() {
        return value;
    }
}
