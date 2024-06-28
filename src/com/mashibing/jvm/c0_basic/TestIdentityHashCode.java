package com.mashibing.jvm.c0_basic;

public class TestIdentityHashCode {
    public static void main(String[] args) {
        Object object = new Object();
        System.out.println(object.hashCode());
        // 为给定对象返回与默认方法hashCode()返回的相同的哈希码
        System.out.println(System.identityHashCode(object));
        System.out.println("------------------------------------");
        InnerClass innerClass = new InnerClass();
        System.out.println(innerClass.hashCode());
        System.out.println(innerClass.superHashCode());
        System.out.println(System.identityHashCode(innerClass));
        System.out.println("------------------------------------");
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        System.out.println(s1.hashCode() == s2.hashCode());
        System.out.println(System.identityHashCode(s1) == System.identityHashCode(s2));
    }

    private static final class InnerClass {
        @Override
        public int hashCode() {
            return 10000;
        }
        public int superHashCode() {
            return super.hashCode();
        }
    }
}