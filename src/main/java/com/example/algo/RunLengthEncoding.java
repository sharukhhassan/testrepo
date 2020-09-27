package com.example.algo;

/**
 * Given an input string, write a function that returns the Run Length Encoded string for the input string.
 * For example, if the input string is “wwwwaaadexxxxxx”, then the function should return “w4a3d1e1x6”.
 */
public class RunLengthEncoding {
    public static void main(String[] args) {
        String str = "wwwwaaadexxxxxx";
        System.out.println(encode(str));
    }

    public static String encode(String str) {
        int len = str.length();
        if(len == 0) return "";
        StringBuilder out = new StringBuilder();
        char tempChar = str.charAt(0);
        int tempCount = 1;
        for(int i=1; i < len ; i++) {
            if(str.charAt(i) == tempChar) {
                tempCount++;
                tempChar = str.charAt(i);
            }
            else {
                out.append(tempChar);
                out.append(tempCount);
                tempChar = str.charAt(i);
                tempCount = 1;
            }
        }
        out.append(tempChar);
        out.append(tempCount);
        return out.toString();
    }
}
