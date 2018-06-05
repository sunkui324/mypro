package com.wolab.util.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntermediateDemo {
    public static void main(String[] args) {

        /**
         * 流的操作
         *
         * Intermediate：
         * map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip、 parallel、 sequential、 unordered
         *
         * Terminal：
         * forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 iterator
         *
         * Short-circuiting：
         * anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 limit
         *
         *
         * @author bruce.sun
         * @date 2018/6/4
         * @param [args]
         * @return void
         *
         */


        /**
         *   Map
         *   map是一对一映射,每个输入元素,都按照规则转换成另外一个元素.
         *
         * @author bruce.sun
         * @date 2018/6/5
         * @param [args]
         * @return void
         *
         */

        Stream.of("a", "b", "c").map(String::toUpperCase).collect(Collectors.toSet());

        Stream.of(1, 2, 3, 5).map(n -> n * n).collect(Collectors.toSet());

        /**
         *   filter 进行某项测试,留下的元素生成新的stream
         *   flatmap可以将stream中的层级扁平化,将底层元素抽取出来放在一起.
         *
         * @author bruce.sun
         * @date 2018/6/5
         * @param [args]
         * @return void
         *
         */

        Stream.of(Arrays.asList("1"), Arrays.asList("2"), Arrays.asList("3")).flatMap(n -> n.stream()).collect(Collectors.toSet()).forEach(System.out::println);


        /**
         *   filter 过滤
         * @author bruce.sun
         * @date 2018/6/5
         * @param [args]
         * @return void
         *
         */
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).filter(n -> n % 2 == 0).forEach(System.out::println);


        /**
         *   distinct 去重
         * @author bruce.sun
         * @date 2018/6/5
         * @param [args]
         * @return void
         *
         */
        Stream.of(1, 2, 3, 2, 4, 5, 6, 7, 8, 9).filter(n -> n % 2 == 0).distinct().forEach(System.out::print);

        /**
         *   sorted排序
         * @author bruce.sun
         * @date 2018/6/5
         * @param [args]
         * @return void
         *
         */
        System.out.println("sorted 排序==============================");
        //自然排序
        System.out.println("自然排序==============================");
        Stream.of(2, 4, 5, 6, 7, 1, 2, 3, 8, 9).distinct().sorted().forEach(System.out::println);
        //自然逆序
        System.out.println("自然逆序==============================");
        Stream.of(2, 4, 5, 6, 7, 1, 2, 3, 8, 9).distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        // 字段排序
        System.out.println("字段排序==============================");
        Stream.of("andy", "Zuliya", "cat").sorted(Comparator.comparing(String::length)).forEach(System.out::println);
        // 字段逆序
        System.out.println("字段逆序==============================");
        Stream.of("andy", "Zuliya", "cat").sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);


        /**
         *   peek 生成一个包含所有原来元素的新stream,并且提供一个Consumer(消费函数)
         * @author bruce.sun
         * @date 2018/6/5
         * @param [args]
         * @return void
         *
         */

        System.out.println("peek输出==========================");
        System.out.println("peek 是Intermediate状态,不触发terminal");
        Stream.of("one", "two", "three", "four").peek(e -> System.out.println(e));

        System.out.println("peek 添加 collect 出发打印");
        Stream.of("one", "two", "three", "four").peek(System.out::println).filter(n -> n.length() > 3).peek(System.out::println).collect(Collectors.toSet());

        /**
         *   limit skip concat
         * @author bruce.sun
         * @date 2018/6/5
         * @param [args]
         * @return void
         *
         */
        System.out.println("limit 限制个数");
        Stream.of("one", "two", "three", "four").limit(3).forEach(System.out::println);
        Stream.of("one", "two", "three", "four").limit(3).skip(1).forEach(System.out::println);
        Stream.concat(Stream.of("1"), Stream.of("2")).forEach(System.out::println);


        /**
         *   parallel 并发执行流
         *   影响并行流的主要五个因素
         *   1.数据大小 足够大才有意义
         *   2.数据结构 一般给予集合进行并行化
         *   3.装箱 处理基本类型比处理装箱类型要快
         *   4.核数量 只有多核机器才有意义,并且是运行时能使用的多核
         *   5. 单元处理开销 原先处理耗时较长,使用并行化才有意义
         *
         * @author bruce.sun
         * @date 2018/6/5
         * @param [args]
         * @return void
         *
         */

        System.out.println("非parallel 操作,执行并发操作,按正常顺序输出");
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).forEach(System.out::println);
        System.out.println("parallel 操作,执行并发操作,随机输出");
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).parallel().forEach(System.out::println);


        /**
         *   sequential  返回非并行执行, 非并行
         * @author bruce.sun
         * @date 2018/6/5
         * @param [args]
         * @return void
         *
         */
        System.out.println("sequential 顺序执行");
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .peek(System.out::println)
                .sequential()
                .peek(System.out::println)
                .collect(Collectors.toSet());


        /**
         *   Terminal 操作 forEach  forEachOrdered
         * @author bruce.sun
         * @date 2018/6/5
         * @param [args]
         * @return void
         *
         */
        // 并行排序后要用forEachOrdered进行顺序排序
        Arrays.asList(1, 4, 5, 2, 3, 6, 8, 9, 7)
                .stream()
                .parallel()
                .sorted()
                .forEachOrdered(System.out::print);

        /**
         *   toArray 转变成数组
         * @author bruce.sun
         * @date 2018/6/5
         * @param [args]
         * @return void
         *
         */
        String []copyDatas = Stream.of("a","b","c").toArray(String[]::new);



    }
}
