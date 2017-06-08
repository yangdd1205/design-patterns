package desgin.patterns.creational.singleton;

/**
 * 不推荐，非线程安全。
 *
 * 懒汉式
 * <p>
 * 优点：在需要使用时才创建实例，实现资源的最大化利用。
 * 缺点：非线程安全，相比饿汉式来说，多了判断。
 *
 * @author yangdd
 * @date 2017-6-8
 */
public class PresidentLazy {

    private static PresidentLazy president_Lazy;

    private PresidentLazy() {
    }

    public static PresidentLazy getInstance() {
        if (president_Lazy == null) {
            president_Lazy = new PresidentLazy();
        }
        return president_Lazy;
    }

}
