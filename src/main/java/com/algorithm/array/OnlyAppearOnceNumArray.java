package com.algorithm.array;

import java.util.Arrays;

/**
 * @program: algorithmCode
 * @description: 只出现一次的数字
 *              给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
 * @packagename: com.algorithm.array
 * @author: Squirrel
 * @date: 2021-02-24 13:46
 **/
public class OnlyAppearOnceNumArray {
    /**
     * 日期：2021-02-24
     * 解题思路1：
     * 这个题目首先想到的思路就是先排序，然后就会发现在出现某元素只出现一次之前，都是 nums[2i]=nums[2i+1]
     * 如果在循环到最后一个之前有不相等的情况，就返回num[i]
     * 如果循环结束没有返回，那么证明这个单个的元素是数组中最大的元素
     * 直接返回就可以了
     */
    public static int singleNumber1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length-1;
        for(int i=0;i<n;){
            if(nums[i]!=nums[i+1]){
                return nums[i];
            }
            i=i+2;
        }
        return nums[n];
    }

    /**
     * 解题思路2：
     * 如何才能做到线性时间复杂度和常数空间复杂度呢？
     * 是使用位运算。对于这道题，可使用异或运算⊕。异或运算有以下三个性质。
     * 任何数和 0 做异或运算，结果仍然是原来的数，即 a ⊕ 0=a
     * 任何数和其自身做异或运算，结果是 0，即 a ⊕ a
     * 异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
     * 例如一个数组为[1,2,2,1,3,4,4]
     * 那么用异或：(1⊕1)⊕(2⊕2)⊕(4⊕4)⊕3=0⊕3=3
     * 然后就找到了这个唯一元素
     */
    public static int singleNumber2(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
    public static void main(String[] args) {
        int nums[]={4,1,2,1,2,5,5};
        //题解1
        System.out.println(singleNumber1(nums));
        //解题2
        System.out.println(singleNumber2(nums));
    }
}
