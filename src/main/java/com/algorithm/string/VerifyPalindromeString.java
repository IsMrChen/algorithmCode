package com.algorithm.string;

import java.sql.SQLOutput;
import java.util.LinkedList;

/**
 * @program: algorithmCode
 * @description: 验证回文串
 * @packagename: com.algorithm.string
 * @author: Squirrel
 * @date: 2021-03-25 22:49
 **/
public class VerifyPalindromeString {
    /**
     * 日期：2021-03-25
     * 解题思路1：
     * 什么是回文串，就是正反字母顺序不变
     * 例如 aba a，ba  ABa
     * 也就是说字符串中非字母的字符不算进去,不区分大小写
     * 这个题目首先想到用双指针
     *
     * 很不幸，这个思路超出了时间限制
     * 我看了官方解答以后，才发现它用的工具API，当然快啦...
     * 虽然这个超时了，但是我还是保留，因为思路是一样的
     */
    public static boolean isPalindrome1(String s) {
        int length = s.length();
        if(length == 0 || s.equals(" ")){
            return true;
        }
        LinkedList<Character> linkedList = new LinkedList<>();
        for(int i = 0;i<length;i++){
            if(checkChar(s.charAt(i))){
                linkedList.add(s.charAt(i));
            }
        }
        if(linkedList.size()<=1){
            return true;
        }
        for(int i = 0,j = linkedList.size()-1;j>i;j--,i++){
            if(!String.valueOf(linkedList.get(i)).equalsIgnoreCase(String.valueOf(linkedList.get(j)))){
                return false;
            }
        }
        return true;
    }

    public static boolean checkChar(char c){
        //0-9 a-z A-Z
        if((c>=48 && c<=57) || (c>=65 && c<=90) ||( c>=97 && c<=122)){
            return true;
        }
        return false;
    }

    /**
     * 日期：2021-03-29
     * 解题思路2：筛选+判断
     * 我们可以将字符串的字母和数字保留，放在另一个字符串中 temp
     * 这样我们只需要判断temp字符串是不是一个普通的回文串即可
     *
     * 判断的方式：使用语言中字符串的反转API 得到逆序的字符串，再比较
     */
    public static boolean isPalindrome2(String s) {
       StringBuffer temp = new StringBuffer();
       int length = s.length();
       for(int i=0; i<length; i++){
           char ch = s.charAt(i);
           if(Character.isLetterOrDigit(ch)){
               temp.append(Character.toLowerCase(ch));
           }
       }
       StringBuffer temp_rev = new StringBuffer(temp).reverse();
       return temp.toString().equals(temp_rev.toString());
    }


    public static void main(String[] args) {
        String c = ",acva";
        System.out.println(isPalindrome1(c));
        System.out.println(isPalindrome2(c));
    }
}
