package com.wolab.functionInterface.supplier;

import com.wolab.model.People;
import com.wolab.model.Student;

import java.util.concurrent.CompletableFuture;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

/**
 * 供给者 函数  void -> T
 * @author bruce.sun  
 * @date 2018/6/4
 * 
 */  
public class SupplierDemo {

    CompletableFuture cf=new CompletableFuture();


    /**
     *   Supplier   无参数传入,返回一个结果,方法为 T get()
     *              表示的是一种生成的能力,比如new 这种动作, 一直是new的对对象. 返回一个给定类型的结果.
     * @author bruce.sun
     * @date 2018/6/4
     * @param
     * @return
     *
     */
    public static void main(String[] args) {
        Supplier<String> supplier=()-> "Hello World";
        System.out.println(supplier.get());

        Supplier<People> studentSupplier=People::new;
        System.out.println(studentSupplier.get());

        BooleanSupplier booleanSupplier=()-> true;
        booleanSupplier.getAsBoolean();


    }
}
