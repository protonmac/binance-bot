package pl.bestapp.binancebot.infrastructure.account.domain;

import java.math.BigDecimal;
import java.util.List;

public class AccountDetails {

    private BigDecimal amount;
    private String currency;
    private List<Position> openPositions;

    public AccountDetails(BigDecimal amount, String currency, List<Position> openPositions) {
        this.amount = amount;
        this.currency = currency;
        this.openPositions = openPositions;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public List<Position> getOpenPositions() {
        return openPositions;
    }
}
