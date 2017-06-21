# 简单工厂模式

## 参考链接

> http://www.programcreek.com/2013/02/java-design-pattern-factory/<br>http://blog.csdn.net/lovelion/article/details/9300731


简单工厂模式用于根据不同的参数创建一个对象。

## 举个栗子

一个可以创造人的工厂。如果我们要求创造一个男孩，工厂就会生产一个男孩；如果我们要求创造一个女孩，工厂就会生产一个女孩。根据不同的参数，工厂生产不同的产品。

## 类图

![](http://www.programcreek.com/wp-content/uploads/2013/02/factory-design-pattern.png)

`Human`一个人类的标准

`Boy`男孩产品

`Girl`女孩产品

`HumanFactory`创造人的工厂

## Java类库中工厂模式的使用

根据不同的参数，`getInstance()` 返回不同的`Calendar`实例

```java
java.util.Calendar - getInstance()
java.util.Calendar - getInstance(TimeZone zone)
java.util.Calendar - getInstance(Locale aLocale)
java.util.Calendar - getInstance(TimeZone zone, Locale aLocale)
java.text.NumberFormat - getInstance()
java.text.NumberFormat - getInstance(Locale inLocale)
```


## 总结

提供专门的工厂类来创建对象

### 主要优点

1. 对客户端提供了一个统一标准的产品
2. 实现了对象创建和使用的分离
3. 无须知道具体的产品类的类名，只需要知道具体产品类所对应的参数即可

### 主要缺点

1. 工厂类包含了所有的产品创建逻辑，职责过重，一旦不能正常工作，整个系统都要受到影响
2. 系统扩展困难，一旦添加新的产品就不得不修改工厂逻辑，如果产品类型过多或者创建逻辑改动频繁，不利于系统的扩展和维护
3. 由于使用了静态工厂方法，造成工厂角色无法形成基于继承的结构

### 使用场景

1. 工厂类负责创建的对象比较少，创建的逻辑改动不频繁
2. 客户端只知道传入工厂类的参数，对于怎么创建对象不关心




