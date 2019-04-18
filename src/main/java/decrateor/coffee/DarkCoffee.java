package decrateor.coffee;
//具体装饰对象
public class DarkCoffee implements Coffee{
    @Override
    public String getSeasoning() {
        return "浓缩咖啡";
    }

    @Override
    public double price() {
        return 1.99;
    }
}
