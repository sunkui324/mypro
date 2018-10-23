package com.wolab;

import java.util.*;

public class WorkSpaceTest {

    public static void main(String[] args) {
        int[] nums={1,2,2,3,1};

        new WorkSpaceTest().findShortestSubArray(nums);
    }

    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,int[]> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int[] arr=map.get(nums[i]);
                arr[0] ++;
                arr[2] =i;
                map.put(nums[i],arr);
            }else{
                map.put(nums[i],new int[]{1,i,i});
            }
        }

        int max=Integer.MIN_VALUE; int length=Integer.MAX_VALUE;
        for(int[] arr: map.values()){
            if(arr[0]>max){
                max=arr[0];
                length=arr[2]-arr[1] +1;
            }else if(arr[0]==max){
                length=Math.min(arr[2]-arr[1] +1,length);
            }
        }
        return length;


    }
}
