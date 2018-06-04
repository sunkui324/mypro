package com.wolab.functionInterface.supplier;

import com.wolab.model.Student;

import java.util.function.Supplier;

public class SupplierDemo4 {
    public static void main(String[] args) {

        Supplier<Student> studentSupplier = SupplierDemo4::employeeMaker;

        for (int i = 0; i < 10; i++) {
            System.out.println("#"+i+": " +studentSupplier.get());
        }

    }

    public static Student employeeMaker() {
        return new Student("Thomas", "James", 3.0);
    }


}


