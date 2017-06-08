package desgin.patterns.creational.singleton;

/**
 * 使用枚举
 *
 * @author yangdd
 * @date 2017-6-8
 */
public enum PresidentEnum {
    INSTANCE;

    // all the methods you want

    public void DoSomething() {
        System.out.println("do something");
    }
}