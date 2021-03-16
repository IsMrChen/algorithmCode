package com.interview.meituan;

/**
 * @program: algorithmCode
 * @description: 美团笔试题目 1
 * @packagename: com.algorithm
 * @author: Squirrel
 * @date: 2021-03-13 16:05
 **/
public class Main1 {

    public static void exchange(int[][] arr,int m,int n){
        for(int j = 0 ; j<n ;j++){
            for(int i = 0 ;i<m;i++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        int[][] arr={{1,2,3},
                     {4,5,6},
                     {7,8,9}};
        exchange(arr,3,3);
    }
}
