package com.hbuas.test;

import java.util.HashSet;

/**
 * Created by ZSS on 2016/4/27.
 */
public class Test {
    public static void main(String args[]){
//        Configuration configuration = new Configuration().configure();
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//        System.out.println(sessionFactory);
//        int num = 5;
//        int [] a;
//        a= new int[num];
//        System.out.println(a.length);
//        System.out.println(a[2]);
        String a = new String("hello");
        String b = new String("hello");
        String c = new String("hello");
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
//        A a1 =new A(9999);
//        A a2 = new A(9999);
//        A a3 = new A(9999);
//        System.out.println(a1.hashCode());
//        System.out.println(a2.hashCode());
//        System.out.println(a3.hashCode());
        HashSet set = new HashSet();
        set.add(a);
        set.add(b);
        set.add(c);
        System.out.println(set.size());

    }

}
class A{
    int num;
    public A(int num){
        this.num = num;
    }
}