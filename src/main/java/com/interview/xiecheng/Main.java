package com.interview.xiecheng;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

     static boolean check(int[] nums, int x, int m) {
        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > x) {
                cnt++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return cnt <= m;
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static int maxAmount(int[] packets, int n) {
        int left = 0, right = 0;
        for (int i = 0; i < packets.length; i++) {
            right += packets[i];
            if (left < packets[i]) {
                left = packets[i];
            }
        }
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (check(packets, mid, n+1)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /******************************结束写代码******************************/

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int[] packets = stringToIntegerArray(in.nextLine().trim());
        int n = Integer.parseInt(in.nextLine().trim());
        //int[] packets = {1,2,3,4,5,6,7,8,9};
        System.out.println(maxAmount(packets,5));
    }

    public static int[] stringToIntegerArray(String in) {
        in = in.trim();
        in = in.substring(1, in.length() - 1);
        if (in.length() == 0) {
            return new int[0];
        }

        String[] arr = in.split(",");
        int[] out = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            out[i] = Integer.parseInt(arr[i].trim());
        }
        return out;
    }
}

