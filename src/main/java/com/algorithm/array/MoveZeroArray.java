package com.algorithm.array;

import com.sun.javaws.IconUtil;

/**
 * @program: algorithmCode
 * @description: 移动零 在原数组上操作，不可有额外空间
 * @packagename: com.algorithm.array
 * @author: Squirrel
 * @date: 2021-03-18 23:46
 **/
public class MoveZeroArray {

    /**
     * 日期：2021-03-18
     * 解题思路1：
     * 我想的是从右向左依次检索数组是否有0，如果当前位置是0就从这个位置将零移动到后面，用count记录0的个数
     * 保证移动后 0的位置为 length-1-i
     */
    public static void moveZeroes1(int[] nums) {
        int length = nums.length;
        int q = 0;
        int count = 0;
        for(int i = length-1 ; i>=0 ; i--){
            if(nums[i]==0){
                //移动
                for(q=i;q<length-1-count;q++){
                    nums[q] = nums[q+1];
                }
                nums[length-1-count] = 0;
                count++;
            }
        }
    }

    /**
     * 日期：2021-03-19
     * 解题思路：双指针
     * 这个思路是需要观察一下移动0前后数组的变化
     * 例如 120304移动后
     *     123004
     *     123400
     * 我们可以看成是i=2位置的0和从为0位置的向后第一个不为0数的交换i=2的指针叫p 后面第一个不为0位置指针叫q
     * 交换完成后指针继续向后再交换，直到q=length-1
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        int q = 0;
        int temp = 0;
        for(int p = 0;p<nums.length;p++){
            if(nums[p]==0){
                q=p;
                while ((nums[q]==0)){
                    if(q == nums.length-1){
                        break;
                    }
                    q++;
                }
                if(q == nums.length){
                    break;
                }
                //交换
                temp=nums[p]; nums[p]=nums[q];nums[q]=temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums={0,1,0,3,12};
        moveZeroes2(nums);
        for(int num : nums){
            System.out.print(num+" ");
        }

    }
}
