package com.algorithm.string;

/**
 * @program: algorithmCode
 * @description: 整数反转
 * @packagename: com.algorithm.string
 * @author: Squirrel
 * @date: 2021-03-23 09:12
 **/
public class IntegerInversion {
    /**
     * 日期：2021-03-23
     * 解题思路1：
     * 例如123 变成321
     * 就是每一次循环数除以10取余，然后下一次循环这个数要*10
     * 123
     * 第一次循环取余为3  num=3
     * 第二次循环取余为2  num=3*10+2=32
     * 第三次循环取余为1  num=32*10+1=321
     *
     * 那么这里还需要注意的一点是 如果是-123我们要变成-321
     * 那么就需要判断，如果数字为负值，我们要将符号先放一边，按照正数去翻转，然后再用结果*符号
     *
     * int最大值是2147483647，最小值是-2147483648
     * 因此我们需要判断是否溢出的问题
     * 判断溢出，实际上我们只需要判断最后一次循环前num的值是否溢出就可以了，因为最后一次加法肯定不会进位
     */
    public static int reverse1(int x) {
        if(x==0){
            return 0;
        }
        int symbol = 1; //符号
        if(x<0){
            x=-x;
            symbol = -1;//符号为负
        }
        int num = 0;
        int p =0;
        while(x>0){
            //判断溢出
            if((num*10)/10!=num){
                num = 0;
                break;
            }
            p=x%10;
            x=x/10;
            num=num*10+p;
        }
        return symbol*num;//符号为负
    }
    public static void main(String[] args) {
        int x = -1534236469;
        System.out.println(reverse1(x));
    }
}
