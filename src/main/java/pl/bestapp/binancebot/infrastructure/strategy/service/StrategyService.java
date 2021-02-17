package pl.bestapp.binancebot.infrastructure.strategy.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.ta4j.core.*;
import org.ta4j.core.analysis.criteria.AverageProfitableTradesCriterion;
import org.ta4j.core.analysis.criteria.RewardRiskRatioCriterion;
import org.ta4j.core.analysis.criteria.TotalProfitCriterion;
import org.ta4j.core.analysis.criteria.VersusBuyAndHoldCriterion;
import org.ta4j.core.indicators.EMAIndicator;
import org.ta4j.core.indicators.MACDIndicator;
import org.ta4j.core.indicators.RSIIndicator;
import org.ta4j.core.indicators.SMAIndicator;
import org.ta4j.core.indicators.helpers.ClosePriceIndicator;
import org.ta4j.core.num.Num;
import org.ta4j.core.trading.rules.CrossedDownIndicatorRule;
import org.ta4j.core.trading.rules.CrossedUpIndicatorRule;
import org.ta4j.core.trading.rules.StopGainRule;
import org.ta4j.core.trading.rules.StopLossRule;
import pl.bestapp.binancebot.client.BinanceApiRestClient;
import pl.bestapp.binancebot.client.domain.market.Candlestick;
import pl.bestapp.binancebot.client.domain.market.CandlestickInterval;
import pl.bestapp.binancebot.client.impl.BinanceApiRestClientImpl;
import pl.bestapp.binancebot.infrastructure.strategy.domain.Strategy;
import pl.bestapp.binancebot.utils.StrategyRepository;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class StrategyService {

    @Value("${strategy.path}")
    private String apiKey;
    @Value("${bot.secretKey}")
    private String secretKey;

    private final BinanceApiRestClient binanceApiRestClient;
    private final StrategyRepository repository;

    public StrategyService(StrategyRepository repository) {
        this.repository = repository;
        this.binanceApiRestClient = new BinanceApiRestClientImpl(apiKey, secretKey);
    }

    public void save(Strategy strategy, String strategyName) {
        repository.save(strategy, strategyName);
    }

    public Strategy get(String strategyName) {
        return repository.get(strategyName);
    }


    public void calculateStrategy() {
        BarSeries series = new BaseBarSeriesBuilder().withName("AXP_Stock").build();

        List<Candlestick> result = binanceApiRestClient.getCandlestickBars("BTCUSDT", CandlestickInterval.DAILY);

        for (Candlestick candlestick : result) {
            ZonedDateTime zdt = ZonedDateTime.ofInstant(Instant.ofEpochMilli(candlestick.getCloseTime()), ZoneId.systemDefault());
            series.addBar(zdt, candlestick.getOpen(), candlestick.getHigh(),
                    candlestick.getLow(), candlestick.getClose(), candlestick.getVolume());
        }


        /*TODO **********************************************************************************************************************
        *  Przyklad z tej strony:
        * https://ta4j.github.io/ta4j-wiki/Getting-started.html
        *
        *
        * */
        ClosePriceIndicator closePrice = new ClosePriceIndicator(series);


        /*
        * TODO *************************************************************************************************************************
        * Tutaj jest cala dokumentacja wskaznikow:
        * https://oss.sonatype.org/service/local/repositories/releases/archive/org/ta4j/ta4j-core/0.11/ta4j-core-0.11-javadoc.jar/!/index.html
        *
        *
        * */
        SMAIndicator shortSma = new SMAIndicator(closePrice, 5);
        SMAIndicator longSma = new SMAIndicator(closePrice, 30);


        //rulsy do kupowania
        Rule buyingRule = new CrossedUpIndicatorRule(shortSma, longSma).or(new CrossedDownIndicatorRule(closePrice, 50000d));

        //rulsy do sprzedawania
        Rule sellingRule = new CrossedDownIndicatorRule(shortSma, longSma).or(new StopLossRule(closePrice, 3.0)).or(new StopGainRule(closePrice, 2.0));

        org.ta4j.core.Strategy strategy = new BaseStrategy(buyingRule, sellingRule);


        BarSeriesManager manager = new BarSeriesManager(series);
        TradingRecord tradingRecord = manager.run(strategy);
        System.out.println("Number of trades for our strategy: " + tradingRecord.getTradeCount());

        // Getting the profitable trades ratio
        AnalysisCriterion profitTradesRatio = new AverageProfitableTradesCriterion();
        System.out.println("Profitable trades ratio: " + profitTradesRatio.calculate(series, tradingRecord));
        // Getting the reward-risk ratio
        AnalysisCriterion rewardRiskRatio = new RewardRiskRatioCriterion();
        System.out.println("Reward-risk ratio: " + rewardRiskRatio.calculate(series, tradingRecord));

        // Total profit of our strategy
        // vs total profit of a buy-and-hold strategy
        AnalysisCriterion vsBuyAndHold = new VersusBuyAndHoldCriterion(new TotalProfitCriterion());
        System.out.println("Our profit vs buy-and-hold profit: " + vsBuyAndHold.calculate(series, tradingRecord));



    }
}
