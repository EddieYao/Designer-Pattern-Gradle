package strategy.context;

public class AddStrategy implements Strategy {
    @Override
    public void getResult() {
        System.out.println("this is  addMethod");
    }
}
