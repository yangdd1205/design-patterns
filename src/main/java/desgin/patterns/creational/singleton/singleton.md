# 单例模式
## 参考链接

> http://www.barryzhang.com/archives/521<br/>http://www.programcreek.com/2011/07/java-design-pattern-singleton/

单例模式是Java中最常用的模式之一。它用于通过防止外部实例化和修改来控制创建的对象数量。单例对象的类必须保证只有一个实例存在。

## 举个栗子
一个国家只能有一个主席，所以每当需要主席时，都是唯一的主席出面，而不是创造一个新的主席。

## 程序如何实现
1. 私有的构造函数，不允许其他类可以实例化一个新对象
2. 私有引用，防止外部修改
3. `public static`方法是唯一可以获取对象的地方

## 类图和代码

单例的加载有两种模式：

饿汉式

优点：确保了线程安全，在类加载的时候就已经创建好了一个静态的对象供系统调用。

缺点：可能由于初始化的太早，造成资源的浪费。如果初始化本身依赖于一些其他数据，那么也就很难保证其他数据会在它初始化之前准备好。

懒汉式

优点：在需要使用时才创建实例，实现资源的最大化利用。

缺点：要**注意线程安全**问题，相比饿汉式来说，多了判断。


### 饿汉模式

#### [PresidentEager](https://github.com/yangdd1205/design-patterns/blob/master/src/main/java/desgin/patterns/creational/singleton/PresidentEager.java)

### 懒汉模式

#### [PresidentLazy](https://github.com/yangdd1205/design-patterns/blob/master/src/main/java/desgin/patterns/creational/singleton/PresidentLazy.java)

**此写法非线程安全**

问题在于，当多线程工作时，如果有多个线程同时运行到`if (instance == null)`，都判断为null，那么两个线程就各自会创建一个实例。这样一来，就不是单例了。



### [PresidentLazySync](https://github.com/yangdd1205/design-patterns/blob/master/src/main/java/desgin/patterns/creational/singleton/PresidentLazySync.java)


现在我们在方法加上了`synchronized`，每次只有获得锁的线程才能执行，其他线程只能等待着某个线程执行完并释放锁。这样解决了上面多个线程造成的多实例问题。但是带来了新的问题：每次只有1个线程能访问，造成了效率问题。

### [PresidentLazySyncDC](https://github.com/yangdd1205/design-patterns/blob/master/src/main/java/desgin/patterns/creational/singleton/PresidentLazySyncDC.java)

**此写法非线程安全**

现在我们通过双重检查（Double-Check）来将`synchronized`的范围缩小。

第一个`if (instance == null)`，为了解决`PresidentLazySync`中的效率问题，只有当`instance`为null的时候，才进入`synchronized`代码块。

第二个`if (instance == null)`，则是为了防止`PresidentLazy`中有可能出现多个实例的情况。

但是，此写法还是有个小概率出问题。这里涉及到几个概念：`原子操作`、`指令重排`。

这里不再写了可以直接去看第一个参考链接

### [PresidentLazySyncDCVolatile](https://github.com/yangdd1205/design-patterns/blob/master/src/main/java/desgin/patterns/creational/singleton/PresidentLazySyncDCVolatile.java)

通过在`PresidentLazySyncDC`的继承上，加上关键字`volatile`来禁止`指令重排`。


### 其他写法

#### [PresidentStaticInnerClass](https://github.com/yangdd1205/design-patterns/blob/master/src/main/java/desgin/patterns/creational/singleton/PresidentStaticInnerClass.java)

通过静态内部类实现，**非常巧妙**。

#### [PresidentEnum](https://github.com/yangdd1205/design-patterns/blob/master/src/main/java/desgin/patterns/creational/singleton/PresidentEnum.java)

通过枚举实现，**膜拜**。

## Java类库中单例模式的使用

`java.lang.Runtime`：当前Java应用程序关联的运行时对象。我们可以通过`Runtime.getRuntime()`来获取。

在Windows系统下，使用`getRuntime()`的小例子。

```java
Process p = Runtime.getRuntime().exec("C:/windows/system32/ping.exe programcreek.com");
//get process input stream and put it to buffered reader
BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
 
String line;
while ((line = input.readLine()) != null) {
	System.out.println(line);
}
 
input.close();
```




