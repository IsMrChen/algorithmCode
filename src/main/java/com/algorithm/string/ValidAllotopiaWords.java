package com.algorithm.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: algorithmCode
 * @description: 有效的字母异位词 例如sar 和 car 返回为false/sar asr 返回为true /ssar sarr 返回为false
 * @packagename: com.algorithm.string
 * @author: Squirrel
 * @date: 2021-03-24 18:05
 **/
public class ValidAllotopiaWords {
    /**
     * 日期：2021-03-24
     * 解题思路1：一看是否重复这种问题，就首先想到用哈希表
     * 这个题目不仅要保证两个字符串的所有字母出现的一样，还要保证数量一致
     * 首先先将一个字符串放入哈希表中，相同的字母让值+1
     * 然后再将第二个字符串每一个字母都去上面的hash表中找，没找到，直接返回false
     * 找到了，值-1
     * 最后检查hash表的所有值是否都是0，只要有一个不为0 返回false
     */
    public static boolean isAnagram1(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        //放入到hash表
        for(int i = 0 ; i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        //将t字符串在哈希表中找
        for(int j = 0; j<t.length();j++){
            if(!map.containsKey(t.charAt(j))){
                return false;
            }
            if(map.containsKey(t.charAt(j))){
                map.put(t.charAt(j),map.get(t.charAt(j))-1);
            }
        }
        //检查hash表的所有值
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() != 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 日期：2021-03-24
     * 解题思路2：排序
     * 我们可以将字符串按照字母的顺序排序，然后比较两个字符串是否相等
     * 这个代码十分的简洁
     * 在我的观点上看，它的空间复杂度明显高于思路1
     * 并且两个数组都要排序，但是执行效率反而要优于思路1
     */
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sc = s.toCharArray();
        char[] tc = s.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return Arrays.equals(sc,tc);
    }

    public static void main(String[] args) {
        String s="saar";
        String t="asrs";
        System.out.println(isAnagram1(s,t));
    }
}
