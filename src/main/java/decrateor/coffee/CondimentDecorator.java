package decrateor.coffee;
//抽象装饰类
public abstract class CondimentDecorator implements Coffee{
    @Override
    public abstract String getSeasoning();

    @Override
    public abstract double price();
}
