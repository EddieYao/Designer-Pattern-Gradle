package decrateor.shorts;

/**
 * 算法可以自由切换；
 * 避免使用多重条件判断；
 * 扩展性良好
 */
public class ViewResult {
    public static void main(String[] args) {
        Person xc = new Person("yao");

        Sneakers sneakers = new Sneakers();
        TShirts tShirts = new TShirts();
        BigTrouser bigTrouser = new BigTrouser();
        Aj aj = new Aj();

        sneakers.decorate(new Person("yao"));
        sneakers.show();

        bigTrouser.decorate(sneakers);
        bigTrouser.show();

        tShirts.decorate(bigTrouser);
        aj.decorate(tShirts);
        aj.show();

    }
}
