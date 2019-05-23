package java8.reduce;

import java.math.BigDecimal;

public class Reduce {
    public Reduce(BigDecimal money, Integer count) {
        this.money = money;
        this.count = count;
    }

    private BigDecimal money;

    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
