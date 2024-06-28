package com.mashibing.jvm.c0_basic;

public class ClassBasicInfo {
    int i1 = 8;

    int i2 = 300;

    public String getName() throws RuntimeException {
        // aload_0：从局部变量表中加载第0个槽的引用(this)到当前方法栈帧的栈顶
        // getfield i1
        // bipush 8：将8压入到操作数栈
        // if_icmple
        if (i1 > 8) {
            // 1、new:在堆上分配内存空间，并将地址压入操作数栈顶
            // 2、dup：复制操作数栈顶值，并将其压入栈顶，也就是说此时操作数栈上有连续相同的两个对象地址
            // 3、invokespecial：实例初始化(init)，此方法需要从操作数栈顶弹出一个this引用，所以需要dup指令
            // 4、athrow：操作数栈顶取出一个引用类型的值，并抛出
            throw new IllegalArgumentException();
        }

        // aload_0：从局部变量表中加载第0个槽的引用(目前为this)到当前方法栈帧的栈顶
        // getfield i2
        // sipush 300
        // if_icmple
        if (i2 > 300) {
            // new
            // dup
            // ldc Too big>>>的符号引用：将Too big>>>从运行时常量池压栈到操作数栈
            // invokespecial
            // athrow
            throw new IllegalArgumentException("Too big>>>");
        }
        // ldc
        // areturn
        return "SUCCESS";
    }
        // 本类<init>方法jvm指令
        // aload_0
        // invokespecial
        // aload_0
        // bipush 8
        // putfield i1
        // aload_0
        // sipush 300
        // putfield i2
        // return
}