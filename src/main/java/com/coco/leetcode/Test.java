package com.coco.leetcode;

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
        
    }

}
