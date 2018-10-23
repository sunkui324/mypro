package com.wolab;


import java.util.Scanner;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static void main(String[] args){

        int[] coins=new int[]{1,3,5};
        int dp=0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){

            }
        }

        //int[] nums= new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        //System.out.println(AppTest.minCostClimbingStairs(nums));



    }




    /**
     *
     *
     * @author bruce.sun
     * @date 2018/10/12
     *
     */
    public static int minCostClimbingStairs(int[] cost) {
        int f1 = 0, f2 = 0;
        for (int i = cost.length - 1; i >= 0; --i) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }

}
