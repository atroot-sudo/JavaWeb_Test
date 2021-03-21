package com.theoldzheng.ThreadLocal;

import org.junit.Test;

/**
 * Description:
 * ThreadLocal 的作用，它可以解决多线程的数据安全问题。
 * ThreadLocal 它可以给当前线程关联一个数据（可以是普通变量，可以是对象，也可以是数组，集合）
 * ThreadLocal 的特点：
 * 1、ThreadLocal 可以为当前线程关联一个数据。（它可以像Map 一样存取数据，key 为当前线程）
 * 2、每一个ThreadLocal 对象，只能为当前线程关联一个数据，如果要为当前线程关联多个数据，就需要使用多个
 * ThreadLocal 对象实例。
 * 3、每个ThreadLocal 对象实例定义的时候，一般都是static 类型
 * 4、ThreadLocal 中保存数据，在线程销毁后。会由JVM 虚拟自动释放。
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.21 15:24
 */

public class threadLocalTest implements Runnable {
    @Override
    public void run() {
        System.out.println("线程名" + Thread.currentThread().getName());

        ThreadLocal<Integer> test = new ThreadLocal<>();
        int a = 101;
        test.set(a);  //放入---与线程绑定  注意  一个对象只能绑定一个数据(基本数据类型、引用数据类型等)


        System.out.println("do something");

        System.out.println(test.get());  //取出，当线程销毁后，自动销毁其中绑定的信息

        test.remove(); //必须最后执行remove操作，否则就会出错因为Tomcat的底层使用了线程池的技术


    }
    @Test
    public void test1(){
        threadLocalTest threadLocalTest = new threadLocalTest();
        threadLocalTest.run();
    }
}
