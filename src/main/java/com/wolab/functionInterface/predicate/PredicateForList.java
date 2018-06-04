package com.wolab.functionInterface.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Predicate 函数接口主要用于对输入的对象按照指定的条件进行过滤
 */
public class PredicateForList {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println("输出所有参数:");
        eval(list,n->true);
        System.out.println("输出能被2整除的数字:");
        eval(list,n->n%2==0);
        System.out.println("输出不能2整除的数字:");
        eval(list,n->n%2!=0);
    }



    public static void eval(List<Integer> list, Predicate<Integer> predicate){
        for (Integer n:list){
            if(predicate.test(n)){
                System.out.print(n +" ");
            }
        }
    }
}
