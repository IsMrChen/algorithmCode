package com.interview.meituan;

import java.util.*;

/**
 * @program: algorithmCode
 * @description: 美团笔试题 找到众数
 * @packagename: com.algorithm
 * @author: Squirrel
 * @date: 2021-03-13 16:50
 **/
public class Main3 {
    public static void getModalNumbers(int[] arr,int n, int k){
        int count = n-k+1;//数组数量
        int[][] arrs = new int[count][k];
        //将一维变二维
        for(int i=0 ;i<count;i++){
            int p=0;
            for(int j=i;j<k;j++,p++){
                arrs[i][p]=arr[j];
            }
            k=k+1;
        }
        //找出每一行数组的众数
        for(int p=0;p<count;p++){
            int[] a=arrs[p];
            System.out.println(getModal(a));
        }

    }

    public static int getModal(int[] arr){
        int n = arr.length;
        if(n==0) return -1;
        if(n==1) return arr[0];
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int i=0;i<n;i++){
            //统计每一个数字出现的频率
            if(null == freqMap.get(arr[i])){
                freqMap.put(arr[i],1);
            }else{
                freqMap.put(arr[i],freqMap.get(arr[i])+1);
            }
        }
        //按照频率找到最大值(没有时间写完)
        int max = 0;
        return 0;
    }
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int[] arr={1,2,2,1,3};
        getModalNumbers(arr,5,3);
    }
}
