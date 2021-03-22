package com.algorithm.array;

/**
 * @program: algorithmCode
 * @description: 旋转数组（二维）
 * @packagename: com.algorithm.array
 * @author: Squirrel
 * @date: 2021-03-22 20:47
 **/
public class Rotate2Array {
    /**
     * 日期：2021-03-22
     * 解题方案：
     * 简单来看，就是第一行变成了最后一列
     * 我们可以看成一圈一圈的变化
     * 例如4x4
     *
     *
     */
    public static void rotate(int[][] matrix) {
        //一圈一圈地变换，layer表示圈数
        int n=matrix[0].length;
        for(int layer=0;layer<n/2;layer++){
            for(int column=layer;column<n-1-layer;++column){//四个点轮流换位置
                int temp=matrix[layer][column];
                matrix[layer][column]=matrix[n-1-column][layer];
                matrix[n-1-column][layer]=matrix[n-1-layer][n-1-column];
                matrix[n-1-layer][n-1-column]=matrix[column][n-1-layer];
                matrix[column][n-1-layer]=temp;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},
                          {2,4,8,10},
                          {13,3,6,7},
                          {15,14,12,16}};

        rotate(matrix);
        for(int[] c : matrix){
            for(int n :c){
                System.out.print(n+" ");
            }
            System.out.print("\n");
        }
    }
}
