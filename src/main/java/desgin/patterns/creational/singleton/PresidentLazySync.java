package desgin.patterns.creational.singleton;

/**
 *
 * 使用synchronized加上同步锁
 *
 * 每次只有一个线程能访问，执行效率受影响
 *
 * @author yangdd
 * @date 2017-6-8
 */
public class PresidentLazySync {


    private static PresidentLazySync instance;

    private PresidentLazySync() {
    }

    public static synchronized PresidentLazySync getInstance() {
        if (instance == null) {
            instance = new PresidentLazySync();
        }
        return instance;
    }

}
