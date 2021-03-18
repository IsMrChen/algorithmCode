package com.algorithm.array;

/**
 * @program: algorithmCode
 * @description: 加一运算
 * @packagename: com.algorithm.array
 * @author: Squirrel
 * @date: 2021-03-18 12:28
 **/
public class PlusOneArray {

    /**
     * 日期：2021-03-18
     * 解题思路：加法有三种情况
     * 1.个位数<9直接加
     * 2.个位数=9需要向高位移动指针，如果高位<9就+1，然后低位都变为0
     * 3.如果出现999这样的数组，则检索完整个数组都没有小于9的数，那么该数组位数加1 直接返回最高位为1低位都为0
     *
     */
    public static int[] plusOne1(int[] digits) {
        int length = digits.length;
        int p = length - 1;
        //个位数<9直接加
        if (digits[p] < 9) {
            digits[p] +=1;
            return digits;
        }
        //个位数=9需要向高位移动指针，如果高位<9就+1，然后低位都变为0
        while (p >= 0) {
            if (digits[p] < 9) {
                digits[p] += 1;
                for(int i=length-1 ;i>p;i--){
                    digits[i]=0;
                }
                return digits;
            }
            p--;
        }
        //循环结束没有退出，就证明数组是999的这种情况
        int[] digit= new int[length+1];
        digit[0]=1;
        return digit;
    }
    public static void main(String[] args) {
        int[] digits = {8,9,9,9};
        int[] results = plusOne1(digits);
        for(int result : results){
            System.out.print(result+" ");
        }
    }
}
