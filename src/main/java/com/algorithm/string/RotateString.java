package com.algorithm.string;

/**
 * @program: algorithmCode
 * @description: 旋转字符串
 * @packagename: com.algorithm.string
 * @author: Squirrel
 * @date: 2021-03-22 22:51
 **/
public class RotateString {
    /**
     * 日期：2021-03-22
     * 解题思路：双指针
     * 例如{'a','b','c','d','e'}
     * 我们可以一个指针p=0 另一个为q=length-1=4
     * 两个指针位置的数值做交换，然后p向后 q向前
     * 一共交换 length/2次
     * 或者是 0<=q-p<=1就不交换了
     */
    public static void reverseString(char[] s) {
        int p = 0;
        int q = s.length-1;
        char temp = 0;
        for(int i=0;i<=(s.length-1)/2;i++){
            temp = s[p];
            s[p] = s[q];
            s[q] = temp;
            p++;
            q--;
        }
    }
    public static void main(String[] args) {
        char[] s = {'a','b','c','d'};
        reverseString(s);
        System.out.println(s);
    }
}
