package pl.bestapp.binancebot.client.domain.account.request;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CancelOrderRequest extends OrderRequest {

  private Long orderId;
  private String origClientOrderId;

  public CancelOrderRequest(String symbol, Long orderId) {
    super(symbol);
    this.orderId = orderId;
  }

  public CancelOrderRequest(String symbol, String origClientOrderId) {
    super(symbol);
    this.origClientOrderId = origClientOrderId;
  }

  private String newClientOrderId;

  public Long getOrderId() {
    return orderId;
  }

  public CancelOrderRequest orderId(Long orderId) {
    this.orderId = orderId;
    return this;
  }

  public String getOrigClientOrderId() {
    return origClientOrderId;
  }

  public CancelOrderRequest origClientOrderId(String origClientOrderId) {
    this.origClientOrderId = origClientOrderId;
    return this;
  }

  public String getNewClientOrderId() {
    return newClientOrderId;
  }

  public CancelOrderRequest newClientOrderId(String newClientOrderId) {
    this.newClientOrderId = newClientOrderId;
    return this;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("orderId", orderId)
        .append("origClientOrderId", origClientOrderId)
        .append("newClientOrderId", newClientOrderId)
        .toString();
  }
}
