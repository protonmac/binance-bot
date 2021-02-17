package pl.bestapp.binancebot.client.domain.account;

import pl.bestapp.binancebot.client.constant.BinanceApiConstants;
import pl.bestapp.binancebot.client.domain.OrderSide;
import pl.bestapp.binancebot.client.domain.OrderType;
import pl.bestapp.binancebot.client.domain.TimeInForce;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class NewOrder {

  private String symbol;
  private OrderSide side;
  private OrderType type;
  private TimeInForce timeInForce;
  private String quantity;
  private String price;
  private String newClientOrderId;
  private String stopPrice;
  private String icebergQty;
  private Long recvWindow;
  private long timestamp;

  public NewOrder(String symbol, OrderSide side, OrderType type, TimeInForce timeInForce, String quantity) {
    this.symbol = symbol;
    this.side = side;
    this.type = type;
    this.timeInForce = timeInForce;
    this.quantity = quantity;
    this.timestamp = System.currentTimeMillis();
    this.recvWindow = BinanceApiConstants.DEFAULT_RECEIVING_WINDOW;
  }

  public NewOrder(String symbol, OrderSide side, OrderType type, TimeInForce timeInForce, String quantity, String price) {
    this(symbol, side, type, timeInForce, quantity);
    this.price = price;
  }

  public String getSymbol() {
    return symbol;
  }

  public NewOrder symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public OrderSide getSide() {
    return side;
  }

  public NewOrder side(OrderSide side) {
    this.side = side;
    return this;
  }

  public OrderType getType() {
    return type;
  }

  public NewOrder type(OrderType type) {
    this.type = type;
    return this;
  }

  public TimeInForce getTimeInForce() {
    return timeInForce;
  }

  public NewOrder timeInForce(TimeInForce timeInForce) {
    this.timeInForce = timeInForce;
    return this;
  }

  public String getQuantity() {
    return quantity;
  }

  public NewOrder quantity(String quantity) {
    this.quantity = quantity;
    return this;
  }

  public String getPrice() {
    return price;
  }

  public NewOrder price(String price) {
    this.price = price;
    return this;
  }

  public String getNewClientOrderId() {
    return newClientOrderId;
  }

  public NewOrder newClientOrderId(String newClientOrderId) {
    this.newClientOrderId = newClientOrderId;
    return this;
  }

  public String getStopPrice() {
    return stopPrice;
  }

  public NewOrder stopPrice(String stopPrice) {
    this.stopPrice = stopPrice;
    return this;
  }

  public String getIcebergQty() {
    return icebergQty;
  }

  public NewOrder icebergQty(String icebergQty) {
    this.icebergQty = icebergQty;
    return this;
  }

  public Long getRecvWindow() {
    return recvWindow;
  }

  public NewOrder recvWindow(Long recvWindow) {
    this.recvWindow = recvWindow;
    return this;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public NewOrder timestamp(long timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  public static NewOrder marketBuy(String symbol, String quantity) {
    return new NewOrder(symbol, OrderSide.BUY, OrderType.MARKET, null, quantity);
  }

  public static NewOrder marketSell(String symbol, String quantity) {
    return new NewOrder(symbol, OrderSide.SELL, OrderType.MARKET, null, quantity);
  }

  public static NewOrder limitBuy(String symbol, TimeInForce timeInForce, String quantity, String price) {
    return new NewOrder(symbol, OrderSide.BUY, OrderType.LIMIT, timeInForce, quantity, price);
  }

  public static NewOrder limitSell(String symbol, TimeInForce timeInForce, String quantity, String price) {
    return new NewOrder(symbol, OrderSide.SELL, OrderType.LIMIT, timeInForce, quantity, price);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("symbol", symbol)
        .append("side", side)
        .append("type", type)
        .append("timeInForce", timeInForce)
        .append("quantity", quantity)
        .append("price", price)
        .append("newClientOrderId", newClientOrderId)
        .append("stopPrice", stopPrice)
        .append("icebergQty", icebergQty)
        .append("recvWindow", recvWindow)
        .append("timestamp", timestamp)
        .toString();
  }
}
