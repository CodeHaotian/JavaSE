package com.javase.study.File;

import java.io.File;

/*
    递归:方法自己调用自己
    - 递归的分类:
      - 递归分为两种，直接递归和间接递归。
      - 直接递归称为方法自身调用自己。
      - 间接递归可以A方法调用B方法，B方法调用C方法，C方法调用A方法。
    - 注意事项：
      - 递归一定要有条件限定，保证递归能够停止下来，否则会发生栈内存溢出。
      - 在递归中虽然有限定条件，但是递归次数不能太多。否则也会发生栈内存溢出。
      - 构造方法,禁止递归
    递归的使用前提:
        当调用方法的时候,方法的主体不变,每次调用方法的参数不同,可以使用递归
 */
public class Test_Recurison {
    public static void main(String[] args) {
        //a();
        b( 1 );
        int s = sum( 3 );
        System.out.println( s );
        int jc = jc( 10 );
        System.out.println( jc );
        File file = new File( "F:\\Java\\学习笔记" );
        findAllFile( file );
    }

    /**
     * 递归查找目录下的所有文件
     *
     * @param file
     */
    private static void findAllFile(File file) {
        //将所有目录文件列出来封装成数组
        File[] files = file.listFiles();
        //判断是否有数据
        if (files != null) {
            //遍历数组
            for (File f : files) {
                //是目录继续遍历
                if (f.isDirectory()) {
                    findAllFile( f );
                } else {
                    //不是目录输出文件绝对路径
                    System.out.println( f.getAbsoluteFile() );
                }
            }
        }
    }

    /**
     * 构造方法,禁止递归
     * 编译报错:构造方法是创建对象使用的,一直递归会导致内存中有无数多个对象,直接编译报错
     */
    public Test_Recurison() {
        //Demo01Recurison();
    }

    /**
     * 在递归中虽然有限定条件，但是递归次数不能太多。否则也会发生栈内存溢出。
     * 11157
     * Exception in thread "main" java.lang.StackOverflowError
     */
    private static void b(int i) {
        System.out.println( i );
        if (i == 10000) {
            return; //结束方法
        }
        b( ++i );
    }

    /**
     * 递归一定要有条件限定，保证递归能够停止下来，否则会发生栈内存溢出。
     * Exception in thread "main" java.lang.StackOverflowError
     */
    private static void a() {
        System.out.println( "a方法!" );
        a();
    }

    //使用递归求1~n之间的和
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum( n - 1 );
    }

    //使用递归求阶乘：n!
    public static int jc(int n) {
        if (n == 1) {
            return 1;
        }
        return n * sum( n - 1 );
    }

}
