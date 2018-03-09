package com.coco.leetcode.test;

import java.util.Calendar;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
        String s = "b";
        switch (s) {
            case "a":
                System.out.println("a");
            case "b":
            case "c":
                System.out.println("c");
                break;
            default:
                break;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, 2);// 两分钟后
        System.out.println(calendar.getTime());
        System.out.println(calendar.getTime().getTime() / 1000);// 秒

        Integer num1 = new Integer(0);
        Integer num2 = new Integer(0);
        System.out.println(num1 == num2);

        Integer num3 = new Integer(1);
        Integer num4 = 1;
        System.out.println(num3 == num4);

        Integer num5 = 2;
        int num6 = 2;
        System.err.println(num5 == num6);

        String s3 = "kvill|";
        String s1 = new String("kvill|");
        String s2 = s1.intern();
        System.out.println(s2 == s3);
        System.out.println(s1 + " " + s2);
        System.out.println(s2 == s1.intern());

        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");

        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
    }

}
