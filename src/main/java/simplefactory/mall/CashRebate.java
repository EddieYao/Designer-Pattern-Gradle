package simplefactory.mall;

public class CashRebate extends CashSup {
    private double rebateRate;
    public double getRebateRate() {
        return rebateRate;
    }

    public void setRebateRate(double rebateRate) {
        this.rebateRate = rebateRate;
    }

    public CashRebate(double rebateRate) {
        this.rebateRate = rebateRate;
    }

    @Override
    public double getMoney(double money) {
        return money * this.rebateRate;
    }
}
