package com.wolab.dataStructuresAndAlgorithmAnalysisInJava.ch01;

/**
 *   一组Ｎ个数而要确定其中第ｋ个最大者
 *   时间复杂度 O^2
 *   空间复杂度 O
 *   稳定性:稳定
 * @author bruce.sun
 * @date 2018/7/16
 * @param
 * @return
 *
 */
public class SelectionProblem {


    static int[] arrays =new int[]{12,41,84,21,52,15,82};

    public static void main(String[] args) {
        //SelectionProblem.BubbleSort_first(arrays);
        //SelectionProblem.BubbleSort_second(arrays);

        System.out.println("=====================");

        SelectionProblem.printout(1587);
        /*for (int i=0;i<arrays.length;i++){
            System.out.println(arrays[i]);
        }*/

        int k=3;
        System.out.println("==================第"+k+"大的值为"+arrays[k-1]);
    }

    /**
     * 最简单的冒泡排序
     * @author bruce.sun
     * @date 2018/7/16
     * @param
     * @return
     *
     */
    private static void BubbleSort_first(int[] arrays){
        //外循环,限定次数,N项需要循环N-1次 ,每次缩小范围1
        for(int i=0;i<arrays.length-1;i++){
            // 要循环的N-1次,再减去已经排序好的i次.
            for(int j=0;j<arrays.length-1-i;j++){
                //两者比较,将较大数的冒泡到最后.每次确定一个最大值
                if(arrays[j]<arrays[j+1]){
                    int temp=arrays[j];
                    arrays[j]=arrays[j+1];
                    arrays[j+1]=temp;
                }
            }
            /*
            for (int k=0;k<arrays.length;k++){
                System.out.println(arrays[k]);
            }*/


        }
    }


    /**
     *   基本冒泡排序的另一种算法, 每次正向和反向冒泡,减少比较次数.每次缩小范围2
     * @author bruce.sun
     * @date 2018/7/16
     * @param
     * @return
     *
     */
    public static void BubbleSort_second(int[] arrays){

        for (int i=0;i<arrays.length-1;i++){
            boolean isOver=true;
            for (int j=0;j<arrays.length-1-i;j++){
                if(arrays[j]>arrays[j+1]){
                    int temp=arrays[j];
                    arrays[j]=arrays[j+1];
                    arrays[j+1]=temp;
                    isOver=false;
                }
            }

            if(isOver){
                System.out.println("isOver");
                break;
            }
        }
    }


    /**
     *   依次打印每个数字
     * @author bruce.sun
     * @date 2018/7/17
     * @param
     * @return
     *
     */
    public static void  printout(int n){
        if(n>=10){
            printout(n/10);
        }

        System.out.println(n%10);


    }
}
