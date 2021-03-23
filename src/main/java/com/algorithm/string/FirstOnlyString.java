package com.algorithm.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @program: algorithmCode
 * @description: 字符串中的第一个唯一字符
 * @packagename: com.algorithm.string
 * @author: Squirrel
 * @date: 2021-03-23 16:13
 **/
public class FirstOnlyString {
    /**
     * 日期：2021-03-23
     * 解题思路1：
     * 利用哈希表
     * 如果重复，那么这个key的value+1
     * 最后找到第一个value==1的下标返回即可
     */
    public static int firstUniqChar1(String s) {
        if(s.length()==0){
            return -1;
        }
        HashMap<Character, Integer> set = new HashMap<>();
        for(int i=0;i<s.length();i++){
            set.put(s.charAt(i),set.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i = 0; i<s.length();i++){
            if(set.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 日期：2021-03-23
     * 解题思路2：哈希表存储索引
     * 遍历字符串，如果当前字符没出现过就用字典记录它在字符串中的位置，出现过了就把字典里的那条记录改成-1
     * 然后找字典里位置最靠前的（而且不是-1的）那个字符
     */
    public static int firstUniqChar2(String s) {
        if(s.length()==0){
            return -1;
        }
        HashMap<Character, Integer> set = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(set.containsKey(s.charAt(i))){
                set.put(s.charAt(i),-1);
            }else{
                set.put(s.charAt(i),i);
            }
        }
        int first = s.length();
        for(Map.Entry<Character, Integer> entry : set.entrySet()){
            if(-1 != entry.getValue() && entry.getValue()<first){
                first = entry.getValue();
            }
        }
        if(first == s.length()){
            return -1;
        }
        return first;
    }

    public static void main(String[] args) {
        String s = "abccda";
        System.out.println(firstUniqChar2(s));
    }
}
