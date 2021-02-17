package pl.bestapp.binancebot.client;

import pl.bestapp.binancebot.client.domain.event.AggTradeEvent;
import pl.bestapp.binancebot.client.domain.event.CandlestickEvent;
import pl.bestapp.binancebot.client.domain.event.DepthEvent;
import pl.bestapp.binancebot.client.domain.event.UserDataUpdateEvent;
import pl.bestapp.binancebot.client.domain.market.CandlestickInterval;

/**
 * Binance API data streaming façade, supporting streaming of events through web sockets.
 */
public interface BinanceApiWebSocketClient {

  void onDepthEvent(String symbol, BinanceApiCallback<DepthEvent> callback);

  void onCandlestickEvent(String symbol, CandlestickInterval interval, BinanceApiCallback<CandlestickEvent> callback);

  void onAggTradeEvent(String symbol, BinanceApiCallback<AggTradeEvent> callback);

  void onUserDataUpdateEvent(String listenKey, BinanceApiCallback<UserDataUpdateEvent> callback);
}
