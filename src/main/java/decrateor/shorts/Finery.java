package decrateor.shorts;

/**
 * 服飾類 为抽象类
 */
public abstract class Finery extends Person {
    protected Person person;

    public void decorate(Person person) {
        this.person = person;
    }

    @Override
    public void show() {
        person.show();
    }
}
