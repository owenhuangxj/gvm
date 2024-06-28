# Runtime Data Area and Instruction Set

jvms 2.4 2.5

## 指令集分类

1. 基于寄存器的指令集
2. 基于栈的指令集
   Hotspot中的Local Variable Table = JVM中的寄存器

## Runtime Data Area

PC 程序计数器

> 存放指令位置
>
> 虚拟机的运行，类似于这样的循环：
>
> while( not end ) {
>
> 	取PC中的位置，找到对应位置的指令；
>
> 	执行该指令；
>
> 	PC ++;
>
> }

JVM Stack

1. Frame - 每个方法对应一个栈帧
   1. Local Variable Table
   2. Operand Stack
      对于long的处理（store and load），多数虚拟机的实现都是原子的
      jls 17.7，没必要加volatile
   3. Dynamic Linking
       https://blog.csdn.net/qq_41813060/article/details/88379473
      jvms 2.6.3
   4. return address
      一个方法结束，有正常执行完成和出现未处理的异常非正常退出两种方式，方法在正常调用完成之后究竟需要使用哪一个返回指令还需要根据方法
      返回值的实际数据类型而定。在字节码指令中，返回指令包含ireturn(返回值是boolean,byte,char,short,int类型)，lreturn,freturn,
      dreturn以及areturn,另外还有一个return指令供声明为void方法，实例化初始化方法、类和接口的初始化方法使用。而异常处理逻辑存储在一个
      叫着异常处理表的表中，方便在发生异常的时候找到处理异常的代码。无论哪种方式退出，在方法退出后都返回到该方法被调用的位置，方法正常退出时，
      调用者PC寄存器的值做为返回地址，好调用该方法返回后的下一条指令，而异常退出的，返回地址是要通过异常处理表来确定，栈帧中一般不会保存这部分信息。
Heap

Method Area

1. Perm Space (<1.8)
   字符串常量位于PermSpace
   FGC不会清理
   大小启动的时候指定，不能变
2. Meta Space (>=1.8)
   字符串常量位于堆
   会触发FGC清理
   不设定的话，最大就是物理内存

Runtime Constant Pool

Native Method Stack

Direct Memory

> JVM可以直接访问的内核空间的内存 (OS 管理的内存)
>
> NIO ， 提高效率，实现zero copy

思考：

> 如何证明1.7字符串常量位于Perm，而1.8位于Heap？
>
> 提示：结合GC， 一直创建字符串常量，观察堆，和Metaspace



## 常用指令

store

load

pop

mul

sub

invoke

1. InvokeStatic
2. InvokeVirtual
3. InvokeInterface
4. InvokeSpecial
   可以直接定位，不需要多态的方法
   private 方法 ， 构造方法
5. InvokeDynamic
   JVM最难的指令
   lambda表达式或者反射或者其他动态语言scala kotlin，或者CGLib ASM，动态产生的class，会用到的指令

