package simplefactory.calculator;
//继承
public class AddOperation extends Operation{
    //多态

    @Override
    public double getResult(double Num1, double Num2) throws Exception {
        return Num1 + Num2;
    }
}
