package com.wolab.util.optional;


/**
 * 展示Optional类方法的说明和使用.
 */

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        //创建Optional实例，也可以通过方法返回值获得
        Optional<String> name = Optional.of("Sanaulla");

        //创建没有值得optional实例,例如值'null'
        Optional empty=Optional.ofNullable(null);

        //ifPersent 用于检查Optional实例是否有值
        if(name.isPresent()){
            //调用get 返回Optional值.
            System.out.println(name.get());
        }

        try {
            //在Optional实例上调用get() 抛出NoSuchElementException.
            System.out.println(empty.get());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        //ifPersent方法接受lambda表达式传参.
        //如果Optional 值不为空,lambda表达式会处理并在其上执行操作.
        name.ifPresent((value)->{
            System.out.println("The length of the value is :"+value.length());
        });

        //如果有值orElse方法返回Optional 实例,否则返回传入的错误信息.
        System.out.println(empty.orElse("There is no value persent!"));
        System.out.println(name.orElse("There is some value!"));

        try {
            empty.orElseThrow(IllegalAccessError::new);
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }

        //map方法通过传参的lambda表达式修改Optional实例的默认值.
        //lambda表达式返回值会包装为Optional实例.
        Optional<String> upperName=name.map((value)->value.toUpperCase());
        System.out.println(upperName.orElse("No value found"));

        //flatMap 与 map(Function)非常相似,区别在于lambda表达式的返回值.
        //map方法的lambda表达式返回值可以使任何类型,但是返回值会包装成Optional实例.
        //但是flatMap方法的lambda返回值总是Optional类型.
        upperName = name.flatMap((value)-> Optional.of(value.toUpperCase()));
        System.out.println(upperName.orElse("No value found"));


        //filter 方法见检查Optional值是否满足给定条件.
        //如果满足返回Optional实例值,否则返回空Optional.
        Optional<String> longName= name.filter((value)->value.length()>6);
        System.out.println(longName.orElse("The name is less than 6 characters"));

        //另一个示例,Optional值不满足给条件.
        Optional<String> anotherName=Optional.of("Sana");
        Optional<String> shortName=anotherName.filter((value)-> value.length()>6);
        System.out.println(shortName.orElse("The name is less than 6 characters"));



    }
}
