package pl.bestapp.binancebot.infrastructure.strategy.controller;

import org.springframework.web.bind.annotation.*;
import pl.bestapp.binancebot.infrastructure.account.domain.AccountDetails;
import pl.bestapp.binancebot.infrastructure.account.domain.Position;
import pl.bestapp.binancebot.infrastructure.strategy.domain.CommissionType;
import pl.bestapp.binancebot.infrastructure.strategy.domain.Interval;
import pl.bestapp.binancebot.infrastructure.strategy.domain.SellType;
import pl.bestapp.binancebot.infrastructure.strategy.domain.Strategy;
import pl.bestapp.binancebot.infrastructure.strategy.service.StrategyService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RequestMapping("/strategy")
@RestController
public class StrategyController {

    private final StrategyService strategyService;

    public StrategyController(StrategyService strategyService) {
        this.strategyService = strategyService;
    }

    @GetMapping("/{id}")
    public Strategy getStrategy(String id) {
        return strategyService.get("1");
    }

    @GetMapping("/calculate")
    public void calculate() {
        strategyService.calculateStrategy();
    }

    @GetMapping("/all")
    public List<Strategy> getStrategies() {
        return null;
    }

    @PostMapping("/")
    public void addStrategy(@RequestBody Strategy strategy) {
        strategyService.save(strategy, "1");
    }

    @PutMapping("/")
    public void updateStrategy(@RequestBody Strategy Strategy) {
        /* todo */
    }
}
