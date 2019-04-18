package decrateor.coffee;

public class ViewResult {
    public static void main(String[] args) {
        //装饰一个对象
        Coffee coffee = new Milk(new DarkCoffee());
        coffee = new Sugar(coffee);
        coffee = new Sugar(coffee);
        System.out.println(coffee.getSeasoning() + ": $" + String.format("%.6f", coffee.price()));
        System.out.println(coffee.getSeasoning() + ": $" + coffee.price());

        Coffee coffeeC = new Cappuccino();
        coffeeC = new Sugar(coffeeC);
        System.out.println(coffeeC.getSeasoning() + ": $" + String.format("%.6f", coffeeC.price()));
        System.out.println(coffeeC.getSeasoning() + ": $" + coffeeC.price());
    }
}
