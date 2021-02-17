package pl.bestapp.binancebot.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Deposit {

  private String amount;
  private String asset;
  private String insertTime;
  private String txId;
  private int status;

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getAsset() {
    return asset;
  }

  public void setAsset(String asset) {
    this.asset = asset;
  }

  public String getInsertTime() {
    return insertTime;
  }

  public void setInsertTime(String insertTime) {
    this.insertTime = insertTime;
  }

  public String getTxId() {
    return txId;
  }

  public void setTxId(String txId) {
    this.txId = txId;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("amount", amount)
        .append("asset", asset)
        .append("insertTime", insertTime)
        .append("txId", txId)
        .append("status", status)
        .toString();
  }
}
