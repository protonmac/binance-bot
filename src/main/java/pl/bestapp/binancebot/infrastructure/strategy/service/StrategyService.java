package pl.bestapp.binancebot.infrastructure.strategy.service;

import org.springframework.stereotype.Service;
import pl.bestapp.binancebot.infrastructure.strategy.domain.Strategy;
import pl.bestapp.binancebot.utils.StrategyRepository;

@Service
public class StrategyService {

    private final StrategyRepository repository;

    public StrategyService(StrategyRepository repository) {
        this.repository = repository;
    }

    public void save(Strategy strategy, String strategyName) {
        repository.save(strategy, strategyName);
    }

    public Strategy get(String strategyName) {
        return repository.get(strategyName);
    }
}
