package simplefactory.calculator;
//继承
public class DivOperation extends Operation{
    //多态

    @Override
    public double getResult(double Num1, double Num2) throws Exception {
        if (Num2 == 0){
            throw new Exception("被除数不能为0");
        }
        return Num1 / Num2;
    }
}
