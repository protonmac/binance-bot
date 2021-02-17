package pl.bestapp.binancebot.infrastructure.strategy.domain;

public class Strategy {

    /*Liczba ostatnio pobranych wartosci do wyliczenia sredniej*/
    private int average;
    /* Interwał czasowy*/
    private Interval interval;
    /*Typ sprzedarzy czy od ceny zakupu czy od sredniej*/
    private SellType sellType;
    /*Sledzenie zmian ceny procentowo czy wartoscia*/
    private CommissionType commissionType;
    /*Wartosc okreslajaca spadek sredniej ceny po ktorej bot sklada zlecenie kupna*/
    private Double purchaseOrder;
    /*Wartosc okreslajaca wzrost sredniej ceny po ktorej bot sklada zlecenie sprzedazy*/
    private Double salesOrder;
    private Double stopLoss;
    /*Ile czas bot ma odczekac do nastepnego kupna po wykonaniu stop loss*/
    private int stopLossPause;
    /*procentowe zaangazowanie kapitalu*/
    private Double percentageCommitment;

    public Strategy() {
    }

    public Strategy(int average, Interval interval, SellType sellType, CommissionType commissionType, Double purchaseOrder, Double salesOrder, Double stopLoss, int stopLossPause, Double percentageCommitment) {
        this.average = average;
        this.interval = interval;
        this.sellType = sellType;
        this.commissionType = commissionType;
        this.purchaseOrder = purchaseOrder;
        this.salesOrder = salesOrder;
        this.stopLoss = stopLoss;
        this.stopLossPause = stopLossPause;
        this.percentageCommitment = percentageCommitment;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public Interval getInterval() {
        return interval;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }

    public SellType getSellType() {
        return sellType;
    }

    public void setSellType(SellType sellType) {
        this.sellType = sellType;
    }

    public CommissionType getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(CommissionType commissionType) {
        this.commissionType = commissionType;
    }

    public Double getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(Double purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public Double getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(Double salesOrder) {
        this.salesOrder = salesOrder;
    }

    public Double getStopLoss() {
        return stopLoss;
    }

    public void setStopLoss(Double stopLoss) {
        this.stopLoss = stopLoss;
    }

    public int getStopLossPause() {
        return stopLossPause;
    }

    public void setStopLossPause(int stopLossPause) {
        this.stopLossPause = stopLossPause;
    }

    public Double getPercentageCommitment() {
        return percentageCommitment;
    }

    public void setPercentageCommitment(Double percentageCommitment) {
        this.percentageCommitment = percentageCommitment;
    }
}
