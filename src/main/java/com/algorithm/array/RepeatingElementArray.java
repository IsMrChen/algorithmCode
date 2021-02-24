package com.algorithm.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: algorithmCode
 * @description: 存在重复元素数组
 *              给定一个整数数组，判断是否存在重复元素。
 *              如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false
 * @packagename: com.algorithm.array
 * @author: Squirrel
 * @date: 2021-02-24 11:12
 **/
public class RepeatingElementArray {
    /**
     * 日期：2021-02-24
     * 解题思路1：
     * 先排序，然后比较相邻的两个元素是否相等，相等就证明重复了
     */
    public static boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 日期：2021-02-24
     * 解题思路2：Set去重
     *
     */
    public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> numSet=new HashSet<>();
        for(int num :nums){
            if(!numSet.add(num)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int nums1[]={1,2,3,4,5,6,6};
        //题解1
        System.out.println(containsDuplicate1(nums1));
        //题解2
        System.out.println(containsDuplicate2(nums1));
    }
}
