package desgin.patterns.creational.factory;

/**
 * @author yangdd
 */
public class Boy implements Human {
    @Override
    public void talk() {
        System.out.println("Boy is talking...");
    }

    @Override
    public void walk() {
        System.out.println("Boy is walking...");
    }
}
