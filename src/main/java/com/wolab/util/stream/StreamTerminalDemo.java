package com.wolab.util.stream;

import com.wolab.model.People;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * Stream 的Terminal 操作. 这里主要介绍 collect、reduce 操作
 *
 * @param
 * @author bruce.sun
 * @date 2018/6/5
 * @return
 */
public class StreamTerminalDemo {


    public static void main(String[] args) {
        /**
         *   reduce 操作
         * @author bruce.sun
         * @date 2018/6/5
         * @param [args]
         * @return void
         *
         * T reduce(T identity, BinaryOperator<T> accumulator);  给定初始值的reduce ,返回的是类型本身
         *
         * Optional<T> reduce(BinaryOperator<T> accumulator); 未给定初始值的reduce 返回optional
         *
         * U reduce(U identity,BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner);
         */
        System.out.println("给定初始值的reduce ,返回的是类型本身的值");
        System.out.println(Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(0, (a, b) -> a + b));

        System.out.println("未给定初始值的reduce ,返回Optional");
        System.out.println(Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce((a, b) -> a + b).orElseGet(() -> 0));

        Optional accResult = Stream.of(1, 2, 3, 4).reduce((acc, item) -> {
            System.out.println("-------");
            System.out.println("acc:" + acc);
            acc += item;
            System.out.println("item: " + item);
            System.out.println("acc + :" + acc);
            System.out.println("-------");
            return acc;
        });

        System.out.println("accResult:" + accResult.get());

        int result = Stream.of(1, 2, 3, 4).reduce(0, (acc, item) -> {
            System.out.println("-------");
            System.out.println("acc:" + acc);
            acc += item;
            System.out.println("item: " + item);
            System.out.println("acc + :" + acc);
            System.out.println("-------");
            return acc;
        });

        System.out.println("result:" + result);

        ArrayList<Integer> accResult_ = Stream.of(1, 2, 3, 4).reduce(new ArrayList<Integer>(),
                new BiFunction<ArrayList<Integer>, Integer, ArrayList<Integer>>() {
                    @Override
                    public ArrayList<Integer> apply(ArrayList<Integer> acc, Integer item) {
                        acc.add(item);
                        System.out.println("item:" + item);
                        System.out.println("acc + :" + acc);
                        System.out.println("BiFunction");
                        return acc;
                    }
                }, new BinaryOperator<ArrayList<Integer>>() {
                    @Override
                    public ArrayList<Integer> apply(ArrayList<Integer> acc, ArrayList<Integer> item) {
                        System.out.println("BinaryOperator");
                        acc.addAll(item);
                        System.out.println("item: " + item);
                        System.out.println("acc +:" + acc);
                        System.out.println("------");

                        return acc;
                    }
                });
        System.out.println("accResult_ :" + accResult_);



        Stream.of(1,2,3,5,6).reduce(Integer::sum).ifPresent(System.out::println);




        /**
         *  Collect
         *
         *     <R, A> R collect(Collector<? super T, A, R> collector);
         *
         *     <R> R collect(Supplier<R> supplier,
         *                   BiConsumer<R, ? super T> accumulator,
         *                   BiConsumer<R, R> combiner);
         *
         * @author bruce.sun
         * @date 2018/6/5
         * @param [args]
         * @return void
         *
         */

        //使用方法引用
        Stream.of(1,2,3,4,5,6,7,8,9).filter(n -> n>2).collect(ArrayList::new,List::add,List::addAll);
        //这个其实是上面的supplier,accumulator,combiner的聚合体,
        Stream.of(1,2,3,4,5,6,7,8,9).filter(n -> n>2).collect(Collectors.toList());

        /**
         *   Collectors.toMap 第三个参数是键值重复策略,如果不传入第三个参数,当有异常的时候会抛出IlleageStateemntException
         * @author bruce.sun
         * @date 2018/6/5
         * @param [args]
         * @return void
         *
         */
        Stream.of(1,2,3,4,5,6,7,8,9).filter(n -> n>2).collect(Collectors.toMap(p->p,p->p,(exist,neww)->neww));


        /**
         *   Connection groupBy 分组
         * @author bruce.sun
         * @date 2018/6/5
         * @param [args]
         * @return void
         *
         */


        Map<Object, List<Object>> peopleByAge=Stream.of("zhangsan","lisi")
                .collect(Collectors.groupingBy(p->p,Collectors.mapping(p ->p.equals("lisa"),Collectors.toList())));


        //SummingInt 对流中元素的一个整数属性求和

    }



}
