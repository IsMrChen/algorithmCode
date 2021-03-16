package com.interview.meituan;


/**
 * @program: algorithmCode
 * @description: 美团笔试题 寻找数字
 * @packagename: com.algorithm
 * @author: Squirrel
 * @date: 2021-03-13 16:15
 **/
public class Main2 {

    public static void findNumber(String str){
        //将字符串转换为字符数组
        char[] stringArr = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i<stringArr.length; i++){
            if(isNumber(stringArr[i])){
                stringBuffer.append(stringArr[i]);
            }else{
                if(stringBuffer.length()>0){
                    //输出数字
                    //需要对数字做处理，例如00，00abc这种
                    System.out.println(factorNumber(stringBuffer));
                }
                stringBuffer = new StringBuffer();
            }
        }

    }

    //判断字符是否为数字
    public static boolean isNumber(char charStr){
        if(charStr >=48 && charStr <= 57){
            return true;
        }
        return false;
    }

    //处理字符串
    public static String factorNumber(StringBuffer stringBuffer){
        int k = 0;
        for(int i=0 ;i<stringBuffer.length() ; i++){
            if(stringBuffer.charAt(i)==48){
              k=i+1;
            }
        }
        if(k == stringBuffer.length()){
            //说明全部是0
            return "0";
        }
        return stringBuffer.delete(0,k).toString();
    }

    public static void main(String[] args) {
        String str = "a001234b0012c";
        findNumber(str);
    }
}
