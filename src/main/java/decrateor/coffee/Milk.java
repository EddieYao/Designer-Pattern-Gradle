package decrateor.coffee;

public class Milk extends CondimentDecorator {
    private Coffee coffee;

    public Milk(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getSeasoning() {
        return coffee.getSeasoning()+"加牛奶";
    }

    @Override
    public double price() {
        return coffee.price()+0.5;
    }
    public void myMethod(){

    }
}
