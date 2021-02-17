package pl.bestapp.binancebot.infrastructure.strategy.domain;

public class Strategy {

    /*Liczba ostatnio pobranych wartosci do wyliczenia sredniej*/
    private final int average;
    /* Interwał czasowy*/
    private final Interval interval;
    /*Typ sprzedarzy czy od ceny zakupu czy od sredniej*/
    private final SellType sellType;
    /*Sledzenie zmian ceny procentowo czy wartoscia*/
    private final CommissionType commissionType;
    /*Wartosc okreslajaca spadek sredniej ceny po ktorej bot sklada zlecenie kupna*/
    private final Double purchaseOrder;
    /*Wartosc okreslajaca wzrost sredniej ceny po ktorej bot sklada zlecenie sprzedazy*/
    private final Double salesOrder;
    private final Double stopLoss;
    /*Ile czas bot ma odczekac do nastepnego kupna po wykonaniu stop loss*/
    private final int stopLossPause;
    /*procentowe zaangazowanie kapitalu*/
    private final Double percentageCommitment;

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

    public Interval getInterval() {
        return interval;
    }

    public SellType getSellType() {
        return sellType;
    }

    public CommissionType getCommissionType() {
        return commissionType;
    }

    public Double getPurchaseOrder() {
        return purchaseOrder;
    }

    public Double getSalesOrder() {
        return salesOrder;
    }

    public Double getStopLoss() {
        return stopLoss;
    }

    public int getStopLossPause() {
        return stopLossPause;
    }

    public Double getPercentageCommitment() {
        return percentageCommitment;
    }
}
