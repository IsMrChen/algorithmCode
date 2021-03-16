package com.interview.xiecheng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @program: algorithmCode
 * @description: 笔试
 * @packagename: PACKAGE_NAME
 * @author: Squirrel
 * @date: 2021-03-04 19:09
 **/
public class test {

    public static int calculator(List<Object> org){
        //符号 并定优先级
        HashMap<String,Integer> map = new HashMap<>();
        map.put("-",1);
        map.put("+",2);
        map.put("*",3);
        map.put("(",4);
        map.put(")",5);

        //放数字
        Stack<Integer> num = new Stack<>();
        //放符号
        Stack<String> symbol = new Stack<>();

        for(int i=0 ; i<org.size() ; i++){
            if(map.containsKey(org.get(i).toString())){
                symbol.add(org.get(i).toString());
            }else{
                num.add((Integer) org.get(i));
            }
        }

        while (!symbol.isEmpty() && num.size()>1){
            if(map.get(symbol.peek())>3){
                symbol.pop();
            }else{
                Integer result=cal(symbol.pop(),num.pop(),num.pop());
                num.add(result);
            }
        }
        return num.pop();
    }

    public static Integer cal(String symbol,Integer a,Integer b){
        switch (symbol){
            case "+": return a+b;
            case "-": return a-b;
            case "*": return a*b;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Object> org = new ArrayList<>();
        org.add("(");
        org.add("-");
        org.add("(");
        org.add("*");
        org.add(4);
        org.add(5);
        org.add(")");
        org.add(4);
        org.add(5);
        org.add(")");

        System.out.println(calculator(org));

    }
}
