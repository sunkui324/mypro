package com.wolab.functionInterface.supplier;

import java.util.function.Supplier;

/**
 *   supplier 作为一个构造函数入参,传入的作用.
 * @author bruce.sun
 * @date 2018/6/4
 * @param
 * @return
 *
 */
public class SupplierDemo3 {

    private static Employee maker(Supplier<Employee> fx){
        return fx.get();
    }

    public static void main(String[] args) {
        System.out.println(maker(Employee::new));
    }
}

class Employee {
    @Override
    public String toString(){
        return "A Employee";
    }
}
