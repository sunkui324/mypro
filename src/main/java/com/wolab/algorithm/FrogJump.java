package com.wolab.algorithm;

import java.util.ArrayList;


import javax.xml.parsers.DocumentBuilderFactory;

/**
 * 两群青蛙，左右三只，中间有一块空地，左边只能向右跳，右边的只能向左跳，一次只能跳一格或者跨过一个障碍跳一格。
 *
 * 动态规划 算法
 *
 * 回溯法
 * @author bruce.sun
 * @date 2018/7/9
 *
 */
public class FrogJump {

    public static int[] stoneList=new int[]{1,1,1,0,2,2,2};

    /**
     *
     * @author bruce.sun
     * @date 2018/7/9
     *
     */
    public static void main(String[] args) {
        DocumentBuilderFactory documentBuilderFactory =DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setExpandEntityReferences(true);

    }

}
