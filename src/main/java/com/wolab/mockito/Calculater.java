package com.wolab.mockito;

public class Calculater {
    public int add(int a, int b) {
        return a + b;
    }

    public double divide(int a, int b) {
        // 检测被除数是否为0
        if (MathUtils.checkZero(b)) {
            throw new RuntimeException("dividend is zero");
        }

        return (double) a / b;
    }

}
