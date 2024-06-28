package com.mashibing.jvm.c3_jmm;

public class T01_Volatile {
    private volatile int value;

    public void add(int inc) {
        value = value + inc;
    }
}
