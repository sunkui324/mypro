package com.wolab.functionInterface.supplier;

import java.util.Objects;
import java.util.function.Supplier;

/**
 *   supplier 可以作为一个参数传输
 *
 * @author bruce.sun
 * @date 2018/6/4
 * @param
 * @return
 *
 */
public class SupplierDemo2 {

    public static SunPower produce(Supplier<SunPower> supplier){
        return supplier.get();
    }



    public static void main(String[] args) {
        SunPower power=new SunPower();
        SunPower p1=produce(()->power);
        SunPower p2=produce(()->power);

        System.out.println("check the same Object?"+ Objects.equals(p1,p2));


    }

}

class SunPower {
    public SunPower(){
        System.out.println("Sun Power initialized...");
    }
}


