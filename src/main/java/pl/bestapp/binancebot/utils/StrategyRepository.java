package pl.bestapp.binancebot.utils;

import org.springframework.stereotype.Service;
import pl.bestapp.binancebot.infrastructure.strategy.domain.Strategy;

@Service
public interface StrategyRepository {

    void save(Strategy strategy, String strategyName);
    Strategy get(String strategyName);

}
