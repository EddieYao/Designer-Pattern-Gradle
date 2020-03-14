package strategy.factory;

import simplefactory.mall.*;

/**
 * 策略模式 + 简单工厂模式
 * 三种折扣都为策略
 */
public class CashContext {
    //策略模式的Strategy类层次为Context定义了一系列的可供重用的算法或行为。
    //继承有助于析取这些公共的算法
    //策略模式是用来封装算法的
    private CashSup cashSup;
    void getCashier(int rebateType) throws Exception {
        switch (rebateType) {
            case RebateConstants.INITIAL:
                cashSup = new InitialCash();
                break;
            case RebateConstants.REBATE_EIGHT:
                cashSup = new CashRebate(0.8);
                break;
            case RebateConstants.RETURN_300SUB100:
                cashSup = new CashReturn(300, 100);
                break;
            default:
                throw new Exception("折扣类型不存在!");
        }
    }
    //共同的策略即为计算最终价格
    //所有对象都有getMoney的方法，所以可用一个父级对象调用一个策略

    double getResultMoney(double money){
        return cashSup.getMoney(money);
    }
}
