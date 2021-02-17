package pl.bestapp.binancebot.client.domain.account;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class Account {

  private int makerCommission;
  private int takerCommission;
  private int buyerCommission;
  private int sellerCommission;
  private boolean canTrade;
  private boolean canWithdraw;
  private boolean canDeposit;

  private List<AssetBalance> balances;

  public int getMakerCommission() {
    return makerCommission;
  }

  public void setMakerCommission(int makerCommission) {
    this.makerCommission = makerCommission;
  }

  public int getTakerCommission() {
    return takerCommission;
  }

  public void setTakerCommission(int takerCommission) {
    this.takerCommission = takerCommission;
  }

  public int getBuyerCommission() {
    return buyerCommission;
  }

  public void setBuyerCommission(int buyerCommission) {
    this.buyerCommission = buyerCommission;
  }

  public int getSellerCommission() {
    return sellerCommission;
  }

  public void setSellerCommission(int sellerCommission) {
    this.sellerCommission = sellerCommission;
  }

  public boolean isCanTrade() {
    return canTrade;
  }

  public void setCanTrade(boolean canTrade) {
    this.canTrade = canTrade;
  }

  public boolean isCanWithdraw() {
    return canWithdraw;
  }

  public void setCanWithdraw(boolean canWithdraw) {
    this.canWithdraw = canWithdraw;
  }

  public boolean isCanDeposit() {
    return canDeposit;
  }

  public void setCanDeposit(boolean canDeposit) {
    this.canDeposit = canDeposit;
  }

  public List<AssetBalance> getBalances() {
    return balances;
  }

  public void setBalances(List<AssetBalance> balances) {
    this.balances = balances;
  }

  public AssetBalance getAssetBalance(String symbol) {
    for (AssetBalance assetBalance : balances) {
      if (symbol.equals(assetBalance.getAsset())) {
        return assetBalance;
      }
    }
    AssetBalance emptyBalance = new AssetBalance();
    emptyBalance.setAsset(symbol);
    emptyBalance.setFree("0");
    emptyBalance.setLocked("0");
    return emptyBalance;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("makerCommission", makerCommission)
        .append("takerCommission", takerCommission)
        .append("buyerCommission", buyerCommission)
        .append("sellerCommission", sellerCommission)
        .append("canTrade", canTrade)
        .append("canWithdraw", canWithdraw)
        .append("canDeposit", canDeposit)
        .append("balances", balances)
        .toString();
  }
}
