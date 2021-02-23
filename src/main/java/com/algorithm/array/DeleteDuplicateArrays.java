package com.algorithm.array;

/**
 * @program: algorithmCode
 * @description: 删除排序数组中的重复项
 * @packagename: com.algorithm.array
 * @author: Squirrel
 * @date: 2021-02-23 14:26
 **/
public class DeleteDuplicateArrays {
    /**
     * 解题思路：
     * 利用双指针，i在前j在后，如果i=j j就往后移一位
     * 如果i！=j i向后移一位然后把j位置的值赋值给i位置的值
     * 这样就可以保证前面的i+1个数的值是不重复的
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        System.out.println(i+1);
        return i + 1;
    }

    public static void main(String[] args) {
        int nums[]={1,2,2,3};
        removeDuplicates(nums);
        System.out.print("nums: ");
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
