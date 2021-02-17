package pl.bestapp.binancebot.infrastructure.candlestick.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public class CandlestickDTO {

    private String openTime;
    private String open;
    private String high;
    private String low;
    private String close;
    private String volume;
    private String closeTime;
    private String quoteAssetVolume;
    private Long numberOfTrades;
    private String takerBuyBaseAssetVolume;
    private String takerBuyQuoteAssetVolume;


    public CandlestickDTO(String openTime, String open, String high, String low, String close, String volume, String closeTime, String quoteAssetVolume, Long numberOfTrades, String takerBuyBaseAssetVolume, String takerBuyQuoteAssetVolume) {
        this.openTime = openTime;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.closeTime = closeTime;
        this.quoteAssetVolume = quoteAssetVolume;
        this.numberOfTrades = numberOfTrades;
        this.takerBuyBaseAssetVolume = takerBuyBaseAssetVolume;
        this.takerBuyQuoteAssetVolume = takerBuyQuoteAssetVolume;
    }

    
    public String getOpenTime() {
        return openTime;
    }

    
    public String getOpen() {
        return open;
    }

    
    public String getHigh() {
        return high;
    }

    
    public String getLow() {
        return low;
    }

    
    public String getClose() {
        return close;
    }

    
    public String getVolume() {
        return volume;
    }

    
    public String getCloseTime() {
        return closeTime;
    }

    
    public String getQuoteAssetVolume() {
        return quoteAssetVolume;
    }

    
    public Long getNumberOfTrades() {
        return numberOfTrades;
    }

    
    public String getTakerBuyBaseAssetVolume() {
        return takerBuyBaseAssetVolume;
    }
    
    public String getTakerBuyQuoteAssetVolume() {
        return takerBuyQuoteAssetVolume;
    }

    public CandlestickDTO withOpenTime(String openTime) {
        this.openTime = openTime;
        return this;
    }

    public CandlestickDTO withOpen(String open) {
        this.open = open;
        return this;
    }

    public CandlestickDTO withHigh(String high) {
        this.high = high;
        return this;
    }

    public CandlestickDTO withLow(String low) {
        this.low = low;
        return this;
    }

    public CandlestickDTO withClose(String close) {
        this.close = close;
        return this;
    }

    public CandlestickDTO withVolume(String volume) {
        this.volume = volume;
        return this;
    }

    public CandlestickDTO withCloseTime(String closeTime) {
        this.closeTime = closeTime;
        return this;
    }

    public CandlestickDTO withQuoteAssetVolume(String quoteAssetVolume) {
        this.quoteAssetVolume = quoteAssetVolume;
        return this;
    }

    public CandlestickDTO withNumberOfTrades(Long numberOfTrades) {
        this.numberOfTrades = numberOfTrades;
        return this;
    }

    public CandlestickDTO withTakerBuyBaseAssetVolume(String takerBuyBaseAssetVolume) {
        this.takerBuyBaseAssetVolume = takerBuyBaseAssetVolume;
        return this;
    }

    public CandlestickDTO withTakerBuyQuoteAssetVolume(String takerBuyQuoteAssetVolume) {
        this.takerBuyQuoteAssetVolume = takerBuyQuoteAssetVolume;
        return this;
    }
}
