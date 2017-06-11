package desgin.patterns.creational.singleton;

/**
 * 不推荐，还是非线程安全的。
 * <p>
 * 使用synchronized加上同步锁，再使用双重检查（Double-Check）
 *
 * @author yangdd
 * @date 2017-6-8
 */
public class PresidentLazySyncDC {


    private static PresidentLazySyncDC instance;

    private PresidentLazySyncDC() {
    }

    public static PresidentLazySyncDC getInstance() {
        if (instance == null) {
            synchronized (PresidentLazySyncDC.class) {
                if (instance == null) {
                    instance = new PresidentLazySyncDC();
                }
            }
        }
        return instance;
    }

}
