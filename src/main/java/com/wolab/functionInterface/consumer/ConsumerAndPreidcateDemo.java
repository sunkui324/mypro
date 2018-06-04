package com.wolab.functionInterface.consumer;

import com.wolab.model.Student;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 函数接口Consumer 例子
 */
public class ConsumerAndPreidcateDemo {


    /**
     *  Consumer 有且只有一个声明为accept(T t)的方法,接收一个输入参数,并且没有返回值.
     */

    /**
     *  Predicate 有且只有一个声明为test(T t)的方法,并且返回一个boolean值.
     */

    public static Student updateStudentFee(Student student, Predicate<Student> predicate, Consumer<Student> consumer){

        if(predicate.test(student)){
            consumer.accept(student);
        }

        return  student;

    }

    public static void main(String[] args) {

        Student student1=new Student("Ashok","Kumar",9.5);
        student1=updateStudentFee(student1, student -> student.getGrade()>8.5, student -> student.feeDiscount = 30.0);
        student1.printFee();

        Student student2 =new Student("Jacke","Verma",8.0);
        student2= updateStudentFee(student2,student -> student.getGrade()>=8.0,student -> student.feeDiscount = 20.0);
        student2.printFee();

    }



}
