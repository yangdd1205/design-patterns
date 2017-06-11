package desgin.patterns.creational.singleton;

/**
 * 线程安全
 * <p>
 * 使用synchronized加上同步锁，再使用双重检查（Double-Check），再使用volatile防止指令重排。
 *
 * @author yangdd
 * @date 2017-6-8
 */
public class PresidentLazySyncDCVolatile {


    private static volatile PresidentLazySyncDCVolatile instance;

    private PresidentLazySyncDCVolatile() {
    }

    public static PresidentLazySyncDCVolatile getInstance() {
        if (instance == null) {
            synchronized (PresidentLazySyncDCVolatile.class) {
                if (instance == null) {
                    instance = new PresidentLazySyncDCVolatile();
                }
            }
        }
        return instance;
    }

}
