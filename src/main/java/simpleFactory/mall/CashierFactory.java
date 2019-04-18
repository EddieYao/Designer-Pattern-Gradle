package simpleFactory.mall;

/**
 * 工厂类只负责创建对象，同时初始化对象
 * 调用方法由产生的对象调用
 */
public class CashierFactory {
    CashSup getCashier(int rebateType) throws Exception {
        CashSup cashSup;
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
        return cashSup;
    }
}
