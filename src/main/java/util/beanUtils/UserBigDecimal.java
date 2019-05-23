package util.beanUtils;

import java.math.BigDecimal;

public class UserBigDecimal {
    private BigDecimal id;

    public UserBigDecimal(BigDecimal id) {
        this.id = id;
    }
    public UserBigDecimal() {

    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }
}
