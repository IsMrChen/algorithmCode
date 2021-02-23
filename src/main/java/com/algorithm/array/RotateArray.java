package com.algorithm.array;

import com.sun.deploy.security.BadCertificateDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithmCode
 * @description: 旋转数组
 * @packagename: com.algorithm.array
 * @author: Squirrel
 * @date: 2021-02-23 15:24
 **/
public class RotateArray {
    /**
     * 日期：2021-02-23
     *解题思路1:
     * 这个题目相当于每次都从尾部取一个值，然后将剩下的向后移一位，然后再将这个值放在数组下标为0的位置，循环k次
     * 利用双指针，一个在数组头，一个在数组末尾，并且需要一个中间转换int变量来存放从尾部取出的值
     * 每次取出后，就进行一次移动
     * 这种方法有个弊端就是 时间复杂度为k*（n-1）最坏情况为O(n^2) 空间复杂度为O(1)
     */
    public static void rotate1(int[] nums, int k) {
        int i=nums.length-1;
        int temp=0;
        while(k>0&&i>0){
            temp=nums[i];
            for(int m=nums.length-2;m>=0;m--){
                nums[m+1]=nums[m];
            }
            nums[0]=temp;
            k--;
        }
    }

    /**
     * 日期：2021-02-23
     *解题思路2:
     * 利用空间换时间
     * 就是再新建一个数组，用于存放旋转后的，仔细观察数组旋转前后的变化
     * 下标值： 0 1 2 3 4 5 6
     * 旋转前：[1,2,3,4,5,6,7]
     * 旋转后：[5,6,7,1,2,3,4]
     * 元素的新位置为 (i+k)%n (n为数组长度)
     */
    public static void rotate2(int[] nums, int k) {
        int n=nums.length;
        int[] newArr=new int[n];
        for(int i=0;i<n;i++){
            newArr[(i+k)%n]=nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    public static void main(String[] args) {
        int nums1[]={1,2,3,4,5,6,7};
        int k1=3;
        //题解1
        rotate1(nums1,k1);
        for(int i=0;i<nums1.length;i++){
            System.out.print(nums1[i]+" ");
        }
        System.out.println("\n-------------");
        //题解2
        int nums2[]={1,2,3,4,5,6,7};
        int k2=3;
        rotate2(nums2,k2);
        for(int i=0;i<nums2.length;i++){
            System.out.print(nums2[i]+" ");
        }
    }
}
