package decrateor.coffee;

public class Sugar extends CondimentDecorator {
    private Coffee coffee;

    public Sugar(Coffee coffee) {
        this.coffee = coffee;
    }
    @Override
    public String getSeasoning() {
        return coffee.getSeasoning()+"加糖";
    }

    @Override
    public double price() {
        return coffee.price()+0.2;
    }

}
