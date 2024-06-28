package com.mashibing.jvm.c0_basic;

import java.util.ArrayList;
import java.util.List;

public class TestObjectSize {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        Runtime runtime = Runtime.getRuntime();

        // 返回Java虚拟机中的空闲内存量
        long l1 = runtime.freeMemory();

        // 构造100万个Object
        for (int idx = 0; idx < 100_0000; idx++) {
            list.add(new Object());
        }
        long l2 = runtime.freeMemory();
        System.out.println((l1 - l2) / 100_0000);
    }
}