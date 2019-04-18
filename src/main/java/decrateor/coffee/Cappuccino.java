package decrateor.coffee;
//具体装饰对象
public class Cappuccino implements Coffee{
    @Override
    public String getSeasoning() {
        return "卡布奇诺";
    }

    @Override
    public double price() {
        return 2.99;
    }
}
