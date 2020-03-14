package simplefactory.calculator;

import java.util.Scanner;

/**
 * 界面
 * 客户端类ViewResult
 * 算法类Operation 算法子类 - AddOperation 、MulOperation
 */
public class ViewResult {
    public static void main(String[] args) {
        try {
            //工厂只负责产生对象，具体操作由对象本身操作
            Scanner scanner = new Scanner(System.in);
            System.out.print("确认启动计算器？(Y:是 N:否) ：");
            while ("Y".equals(scanner.next())) {
                OperationFactory operationFactory = new OperationFactory();
                System.out.print("请输入第一个数：");
                double Num1 = scanner.nextDouble();
                System.out.print("请输入运算符：");
                String operationStr = scanner.next();
                System.out.print("请输入第二个数：");
                double Num2 = scanner.nextDouble();
                //double精度问题，保留6位小数
                System.out.println("计算结果：" + String.format("%.6f",operationFactory.getOperation(operationStr).getResult(Num1, Num2)));
                System.out.println("是否继续计算？(Y:是 N:否) ：");
            }
        } catch (Exception e) {
            System.out.println("错误信息: " + e.getMessage());
        }
    }
}
