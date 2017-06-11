package desgin.patterns.creational.singleton;

/**
 * 饿汉式
 * <p>
 * 优点：饿汉式是线程安全的，在类加载的时候就已经创建好了一个静态的对象供系统调用，以后不再改变。
 * 缺点：可能由于初始化的太早，造成资源的浪费。如果初始化本身依赖于一些其他数据，那么也就很难保证其他数据会在它初始化之前准备好。
 *
 * @author yangdd
 * @date 2017-6-8
 */
public class PresidentEager {

    private static final PresidentEager INSTANCE = new PresidentEager();

    private PresidentEager() {
    }

    public static PresidentEager getInstance() {
        return INSTANCE;
    }

}
