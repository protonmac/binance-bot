package pl.bestapp.binancebot.client.domain.account;

import pl.bestapp.binancebot.client.domain.OrderSide;
import pl.bestapp.binancebot.client.domain.OrderStatus;
import pl.bestapp.binancebot.client.domain.OrderType;
import pl.bestapp.binancebot.client.domain.TimeInForce;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Order {

  private String symbol;
  private Long orderId;
  private String clientOrderId;
  private String price;
  private String origQty;
  private String executedQty;
  private OrderStatus status;
  private TimeInForce timeInForce;
  private OrderType type;
  private OrderSide side;
  private String stopPrice;
  private String icebergQty;
  private long time;

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public String getClientOrderId() {
    return clientOrderId;
  }

  public void setClientOrderId(String clientOrderId) {
    this.clientOrderId = clientOrderId;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getOrigQty() {
    return origQty;
  }

  public void setOrigQty(String origQty) {
    this.origQty = origQty;
  }

  public String getExecutedQty() {
    return executedQty;
  }

  public void setExecutedQty(String executedQty) {
    this.executedQty = executedQty;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public TimeInForce getTimeInForce() {
    return timeInForce;
  }

  public void setTimeInForce(TimeInForce timeInForce) {
    this.timeInForce = timeInForce;
  }

  public OrderType getType() {
    return type;
  }

  public void setType(OrderType type) {
    this.type = type;
  }

  public OrderSide getSide() {
    return side;
  }

  public void setSide(OrderSide side) {
    this.side = side;
  }

  public String getStopPrice() {
    return stopPrice;
  }

  public void setStopPrice(String stopPrice) {
    this.stopPrice = stopPrice;
  }

  public String getIcebergQty() {
    return icebergQty;
  }

  public void setIcebergQty(String icebergQty) {
    this.icebergQty = icebergQty;
  }

  public long getTime() {
    return time;
  }

  public void setTime(long time) {
    this.time = time;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("symbol", symbol)
        .append("orderId", orderId)
        .append("clientOrderId", clientOrderId)
        .append("price", price)
        .append("origQty", origQty)
        .append("executedQty", executedQty)
        .append("status", status)
        .append("timeInForce", timeInForce)
        .append("type", type)
        .append("side", side)
        .append("stopPrice", stopPrice)
        .append("icebergQty", icebergQty)
        .append("time", time)
        .toString();
  }
}
