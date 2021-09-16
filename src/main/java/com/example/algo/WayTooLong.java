package com.example.algo;

import java.util.Scanner;
 
public class WayTooLong {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String[] words = new String[n];
        for(int i = 0; i < n; i++) {
            words[i] = s.next();
        }
 
        for(int i = 0; i < n; i++) {
            int len = words[i].length();
            if(len <= 10) {
                System.out.println(words[i]);
            }
            else {
                System.out.println(words[i].charAt(0) + String.valueOf(len-2) + words[i].charAt(len-1));
            }
        }
    }
}