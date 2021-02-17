package pl.bestapp.binancebot.infrastructure.candlestick.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.bestapp.binancebot.client.BinanceApiRestClient;
import pl.bestapp.binancebot.client.domain.market.Candlestick;
import pl.bestapp.binancebot.client.domain.market.CandlestickInterval;
import pl.bestapp.binancebot.client.impl.BinanceApiRestClientImpl;
import pl.bestapp.binancebot.infrastructure.candlestick.domain.CandlestickDTO;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Service
public class CandlestickService {

    @Value("${strategy.path}")
    private String apiKey;
    @Value("${bot.secretKey}")
    private String secretKey;

    private final BinanceApiRestClient binanceApiRestClient;

    public CandlestickService() {
        binanceApiRestClient = new BinanceApiRestClientImpl(apiKey, secretKey);
    }

    public List<CandlestickDTO> getCandlestickBars(String symbol, CandlestickInterval interval) {
        List<Candlestick> result = binanceApiRestClient.getCandlestickBars(symbol, interval);
        return result.stream()
                .map(this::asCandlestickDTO)
                .collect(Collectors.toList());
    }

    private CandlestickDTO asCandlestickDTO(Candlestick candlestick) {
        LocalDateTime openTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(candlestick.getOpenTime()),
                TimeZone.getDefault().toZoneId());
        LocalDateTime closeTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(candlestick.getCloseTime()),
                TimeZone.getDefault().toZoneId());

        return new CandlestickDTO(openTime.toString(),
                candlestick.getOpen(), candlestick.getHigh(),
                candlestick.getLow(), candlestick.getClose(),
                candlestick.getVolume(), closeTime.toString(),
                candlestick.getQuoteAssetVolume(),
                candlestick.getNumberOfTrades(), candlestick.getTakerBuyBaseAssetVolume(),
                candlestick.getTakerBuyQuoteAssetVolume());
    }
}
