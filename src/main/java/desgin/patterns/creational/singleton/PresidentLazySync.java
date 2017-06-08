package desgin.patterns.creational.singleton;

/**
 * 不推荐，还是非线程安全的。
 *
 * 使用synchronized加上同步锁
 *
 * @author yangdd
 * @date 2017-6-8
 */
public class PresidentLazySync {


    private static PresidentLazySync president_Lazy;

    private PresidentLazySync() {
    }

    public static synchronized PresidentLazySync getInstance() {
        if (president_Lazy == null) {
            president_Lazy = new PresidentLazySync();
        }
        return president_Lazy;
    }

}
