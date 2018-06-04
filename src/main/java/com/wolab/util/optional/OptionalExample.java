package com.wolab.util.optional;


import com.wolab.model.Champion;
import com.wolab.model.User;

import java.util.Optional;

;

/**
 * java optionalAPI
 * @author bruce.sun
 * @date 2018/6/1
 *
 */
public class OptionalExample {


    /**
     *   名字为空 输出 默认值
     *   map 接收一个Function 方法,改变原来的值.
     * @author bruce.sun
     * @date 2018/6/1
     * @param
     * @return
     *
     */
    public static String getName(User user){
        return Optional.ofNullable(user).map(u ->u.getName()).orElse("No value found");
    }

    /**
     *   名字为空 抛出异常
     * @author bruce.sun
     * @date 2018/6/1
     * @param
     * @return
     *
     */
    public static String getNameThrowException(User user){
        return Optional.ofNullable(user).map(u->u.getName()).orElseThrow(IllegalArgumentException::new);
    }

    /**
     *   2. 名字为空 抛出异常
     * @author bruce.sun
     * @date 2018/6/1
     * @param
     * @return
     *
     */
    public static String getNameThrowExceptionStr(User user){
        return Optional.ofNullable(user).map(u->u.getName()).orElseThrow(IllegalArgumentException::new);
    }

    /**
     *   2.嵌套层的Optional 用法
     *   Champion类里面有Person
     * @author bruce.sun
     * @date 2018/6/1
     * @param
     * @return
     *
     */
    public static String getChampionName(Champion champion){
        return Optional.ofNullable(champion)
                .map(c->c.getPerson())
                .map(u->u.getName())
                .orElseThrow(()->new IllegalArgumentException("参数值不可用"));
    }


    public static void main(String[] args) {
        System.out.println(OptionalExample.getName(null));
        System.out.println(OptionalExample.getNameThrowException(null));

    }









}
