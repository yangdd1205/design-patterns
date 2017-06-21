package desgin.patterns.creational.factory;

/**
 * @author yangdd
 */
public class HumanFactory {
    public static Human createHuman(String m) {
        Human p = null;
        if (m.equals("boy")) {
            p = new Boy();
        } else if (m.equals("girl")) {
            p = new Girl();
        }

        return p;
    }
}
