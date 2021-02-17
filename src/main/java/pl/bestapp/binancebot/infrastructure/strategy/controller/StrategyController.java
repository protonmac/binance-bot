package pl.bestapp.binancebot.infrastructure.strategy.controller;

import org.springframework.web.bind.annotation.*;
import pl.bestapp.binancebot.infrastructure.account.domain.AccountDetails;
import pl.bestapp.binancebot.infrastructure.account.domain.Position;
import pl.bestapp.binancebot.infrastructure.strategy.domain.CommissionType;
import pl.bestapp.binancebot.infrastructure.strategy.domain.Interval;
import pl.bestapp.binancebot.infrastructure.strategy.domain.SellType;
import pl.bestapp.binancebot.infrastructure.strategy.domain.Strategy;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RequestMapping("/strategy")
@RestController
public class StrategyController {

    @GetMapping("/{id}")
    public Strategy getStrategy(String id) {
        return new Strategy(5, Interval.ONE_DAY, SellType.PURCHASE_PRICE, CommissionType.VALUE, 4.5, 5.5, 10.0, 15, 20.0);
    }

    @GetMapping("/all")
    public List<Strategy> getStrategies() {
        return Collections.singletonList(new Strategy(5, Interval.ONE_DAY, SellType.PURCHASE_PRICE, CommissionType.VALUE, 4.5, 5.5, 10.0, 15, 20.0));
    }

    @PostMapping("/")
    public void addStrategy(Strategy Strategy) {
        /* todo */
    }

    @PutMapping("/")
    public void updateStrategy(Strategy Strategy) {
        /* todo */
    }
}
