package strategy.context;
/**
 * 算法可以自由切换；
 * 避免使用多重条件判断；
 * 扩展性良好
 */
public class ViewResult {
    public static void main(String[] args) {
        Context context = new Context(new AddStrategy());
        context.getResult();

        context = new Context(new SubStrategy());
        context.getResult();

    }
}
