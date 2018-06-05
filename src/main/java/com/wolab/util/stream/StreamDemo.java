package com.wolab.util.stream;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 流操作的demo
 *
 * @param
 * @author bruce.sun
 * @date 2018/6/4
 * @return
 */
public class StreamDemo {

    public static void main(String[] args) {
        /**
         *   生成stream的方式  从Collection 和数组生成
         * @author bruce.sun
         * @date 2018/6/4
         * @param [args]
         * @return void
         *
         */
        List list1 = new ArrayList();
        list1.stream();
        list1.parallelStream();

        Integer[] arrays = new Integer[]{1, 2, 3};
        Arrays.stream(arrays);
        Stream.of(arrays);

        /**
         *   生成stream对的方式,通过BufferedReader获取
         * @author bruce.sun
         * @date 2018/6/4
         * @param [args]
         * @return void
         *
         */
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("c:text.txt"))) {
            bufferedReader.lines();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         *   静态工厂生成
         * @author bruce.sun
         * @date 2018/6/4
         * @param [args]
         * @return void
         *
         */
        IntStream.range(1, 10).forEach(System.out::println);

        /**
         * 最早java 提供顺序遍历迭代器Iterator时,还是单核时代,但是在多核时代下,顺序便利已经不能满足需求...
         * Spliterator应运而生. Spliterator应该要提到java7的Fork/Join框架,总的来说的是用递归的方式吧并行的任务
         * 拆分成更小的任务,然后把每个子任务结果合并生成整体结果.
         * @author bruce.sun
         * @date 2018/6/4
         * @param [args]
         * @return void
         *
         */
        Spliterators.spliterator(new ArrayList<>(), 10);


        /**
         *   常用的构造Stream的样例
         * @author bruce.sun
         * @date 2018/6/4
         * @param [args]
         * @return void
         *
         */

        //1.Individual Values
        Stream<String> stream = Stream.of("a", "b", "c");
        //2. Arrays
        String[] strArray = new String[]{"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);
        //3.Collections
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();


        //IntStream DoubleStream  LongStream 减少了装箱,拆箱操作,节省时间
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        IntStream.range(1, 4).forEach(System.out::println);
        IntStream.rangeClosed(1, 4).forEach(System.out::println);


        DoubleStream.of(new double[]{1d, 2d, 3d, 4d}).forEach(System.out::println);
        DoubleStream.of(new double[]{1d, 2d, 3d, 4d}).count();


        /**
         *  stream 转换成其他数据结构
         *
         * @author bruce.sun
         * @date 2018/6/4
         * @param [args]
         * @return void
         *
         */
        //转换成数组
        String[] strArray1 = (String[]) stream.toArray(String[]::new);

        //转换成List
        List<String> list6 = (List<String>) stream.collect(Collectors.toList());

        List<String> list7 = (List<String>) stream.collect(Collectors.toCollection(ArrayList::new));
        //转换成set
        Set set1 = (Set) stream.collect(Collectors.toSet());

        //3. String
        String str = stream.collect(Collectors.joining()).toString();




    }

}
