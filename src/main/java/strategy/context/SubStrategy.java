package strategy.context;

public class SubStrategy implements Strategy {
    @Override
    public void getResult() {
        System.out.println("this is SubMethod");
    }
}
