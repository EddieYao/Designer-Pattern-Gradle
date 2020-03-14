package simplefactory.calculator;
//继承
public class SubOperation extends Operation{
    //多态
    //子类有自己的多样性
    @Override
    public double getResult(double Num1, double Num2) throws Exception {
        return Num1 - Num2;
    }
}
