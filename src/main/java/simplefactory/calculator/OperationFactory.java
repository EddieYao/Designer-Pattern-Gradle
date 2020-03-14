package simplefactory.calculator;

/**
 *
 * 简单工厂
 * 添加算法 则扩展类 同时加多分支
 */
public class OperationFactory {
    public Operation getOperation(String operationStr) throws Exception {
        Operation operation;
        switch (operationStr) {
            case "+":
                operation = new AddOperation();
                break;
            case "-":
                operation = new SubOperation();
                break;
            case "*":
                operation = new MulOperation();
                break;
            case "/":
                operation = new DivOperation();
                break;
            default:
                throw new Exception("不支持的运算符类型");
        }
        return operation;
    }
}
