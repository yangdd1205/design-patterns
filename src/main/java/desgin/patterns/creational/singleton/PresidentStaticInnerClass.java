package desgin.patterns.creational.singleton;

/**
 * 强烈推荐
 * <p>
 * 对于内部类PresidentHolder，它是一个饿汉式的单例实现，在PresidentHolder初始化的时候会由ClassLoader来保证同步，使PRESIDENT是一个真·单例。
 * <p>
 * 同时，由于PresidentHolder是一个内部类，只在外部类的PresidentStaticInnerClass的getInstance()中被使用，所以它被加载的时机也就是在getInstance()方法第一次被调用的时候。
 * <p>
 * 它利用了ClassLoader来保证了同步，同时又能让开发者控制类加载的时机。从内部看是一个饿汉式的单例，但是从外部看来，又的确是懒汉式的实现。
 *
 * @author yangdd
 * @date 2017-6-8
 */
public class PresidentStaticInnerClass {

    private static class PresidentHolder {
        private static final PresidentStaticInnerClass PRESIDENT = new PresidentStaticInnerClass();
    }

    private PresidentStaticInnerClass() {
    }

    public static PresidentStaticInnerClass getInstance() {
        return PresidentHolder.PRESIDENT;
    }

}
