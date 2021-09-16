package com.example.algo;

import java.util.HashSet;

public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {102, 4, 101, 1, 100, 3, 2};
        System.out.println(findMax(nums));
    }

    public static int findMax(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        System.out.println(set);
        int max = 0;
        int c = 0;
        for(int i = 0; i< nums.length; i++) {
            System.out.println(set.contains(nums[i] -1));
            if (!set.contains(nums[i] - 1)) {
                int temp = nums[i];
                while(set.contains(temp)) {
                    System.out.println("c = " + c + "; temp = " + temp);
                    c++;
                    temp++;
                }

            }
            if(c > max) max = c;
            c=0;
        }
        return max;

    }
}
