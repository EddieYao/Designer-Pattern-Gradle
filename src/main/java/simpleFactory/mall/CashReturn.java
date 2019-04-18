package simpleFactory.mall;

/**
 * 子对象
 */
public class CashReturn extends CashSup {
    private double moneyCondition;
    private double moneyReturn;

    public double getMoneyCondition() {
        return moneyCondition;
    }

    public void setMoneyCondition(double moneyCondition) {
        this.moneyCondition = moneyCondition;
    }

    public double getMoneyReturn() {
        return moneyReturn;
    }

    public void setMoneyReturn(double moneyReturn) {
        this.moneyReturn = moneyReturn;
    }

    public CashReturn(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public double getMoney(double money) {
        double rate = moneyCondition / moneyReturn;
        return money - money / rate;
    }
    //子对象可以拥有自己的方法
    public double myRetrun(){
        return 0;
    }
}
