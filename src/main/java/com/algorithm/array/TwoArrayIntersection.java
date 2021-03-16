package com.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: algorithmCode
 * @description: 两个数组的交集 给定两个数组，编写一个函数来计算它们的交集
 * @packagename: com.algorithm.array
 * @author: Squirrel
 * @date: 2021-03-16 12:45
 **/
public class TwoArrayIntersection {
    /**
     * 日期：2021-03-16
     *解题思路1: 利用Hash表
     * 首先遍历第一个数组，并在哈希表中记录第一个数组中的每个数字以及对应出现的次数，
     * 然后遍历第二个数组，对于第二个数组中的每个数字，如果在哈希表中存在这个数字，则将该数字添加到答案，并减少哈希表中该数字出现的次数。
     * 为了降低空间复杂度，首先遍历较短的数组并在哈希表中记录每个数字以及对应出现的次数，然后遍历较长的数组得到交集
     */
    public static int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect1(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] nums = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                nums[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(nums, 0, index);
    }

    /**
     * 日期：2021-03-16
     * 解题思路2：排序 + 双指针
     *  如果两个数组是有序的，则可以使用双指针的方法得到两个数组的交集。
     * 首先对两个数组进行排序，然后使用两个指针遍历两个数组。
     * 初始时，两个指针分别指向两个数组的头部。
     * 每次比较两个指针指向的两个数组中的数字，如果两个数字不相等，则将指向较小数字的指针右移一位，
     * 如果两个数字相等，将该数字添加到答案，并将两个指针都右移一位。
     * 当至少有一个指针超出数组范围时，遍历结束
     */
    public static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1=0;
        int p2=0;
        int[] nums = new int[Math.min(nums1.length,nums2.length)];
        int index = 0;
        while(p1<nums1.length&&p2<nums2.length){
            if(nums1[p1] == nums2[p2]){
                nums[index++] = nums1[p1];
                p1++;
                p2++;
            }else{
                if(nums1[p1]>nums2[p2]) p2++;
                else p1++;
            }
        }
        return Arrays.copyOfRange(nums, 0, index);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2,2};
        int[] nums = intersect2(nums1,nums2);
        for(int num : nums){
            System.out.print(num+" ");
        }
    }

}
