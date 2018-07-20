package com.wolab.dataStructuresAndAlgorithmAnalysisInJava.ch01;

import com.wolab.model.People;
import com.wolab.model.Shape;

import java.util.Collection;
import java.util.Comparator;

/**
 * @param
 * @author bruce.sun
 * @date 2018/7/17
 * @return
 */
public class GenericDemo<People> {

    private People storedValue;

    public People read() {
        return storedValue;
    }

    public void write(People people) {
        storedValue = people;
    }



    public static double totalArea1(Shape[] arr){
        double total=0;
        for (Shape s:arr){
            if(s !=null){
                total +=s.getArea();
            }
        }

        return total;
    }

    public static double totalArea(Collection<Shape> arr){
        double total=0;
        for (Shape s:arr){
            if(s !=null){
                total +=s.getArea();
            }
        }

        return total;
    }

    /**
     *   由于我们不需要知道准确的类型T,因此可以使用通配符.
     * @author bruce.sun
     * @date 2018/7/17
     * @param
     * @return
     *
     */
    public static <Shape extends Comparable<Shape>> Shape findMax(Shape[] arr){
        int maxIndex=0;
        for (int i=0;i<arr.length;i++){
            if(arr[i].compareTo(arr[maxIndex])>0){
                maxIndex=i;
            }
        }
        return arr[maxIndex];
    }

    /**
     *
     *  ? super T 下线限定,是T 类型的父类,直到Object
     *  ? extends T  上限限定,是T类型的子类,或T 本身
     *  由于我们不需要知道准确的类型T,因此可以使用通配符.
     * @author bruce.sun
     * @date 2018/7/17
     * @param
     * @return
     *
     */
    public static <Shape extends Comparable<? super Shape>> Shape findMax1(Shape[] arr){
        int maxIndex=0;
        for (int i=0;i<arr.length;i++){
            if(arr[i].compareTo(arr[maxIndex])>0){
                maxIndex=i;
            }
        }
        return arr[maxIndex];
    }

}

