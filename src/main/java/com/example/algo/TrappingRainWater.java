package com.example.algo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * <p>
 * We can trap 2 units of water in the middle gap.
 * <p>
 * Input: arr[]   = {3, 0, 2, 0, 4}
 * <p>
 * Output: 7
 * <p>
 * Explanation:
 * <p>
 * We can trap "3 units" of water between 3 and 2,<p>
 * "1 unit" on top of bar 2 and "3 units" between 2<p>
 * and 4.
 */
public class TrappingRainWater {
    public static void main(String[] args) {

        //int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        ArrayList<Integer> n = new ArrayList<Integer>(); // Length of each test array
        ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>(); // Input array with t inputs
        for (int i = 0; i < t; i++) {
            n.add(sc.nextInt());
            ArrayList<Integer> tempArray = new ArrayList<Integer>();
            for (int j = 0; j < n.get(i); j++) {
                tempArray.add(sc.nextInt());
            }
            input.add(tempArray);
        }

        for (int i = 0; i < t; i++) {
            System.out.println(trap(input.get(i).toArray(new Integer[0]), n.get(i)));
        }

    }

    public static int trap(Integer[] arr, int len) {
        int p1 = 0, p2 = 0; // set two pointers at the first element
        int trapSum = 0;
        int tempSum = 0;
        // Traverse from left to right to get the amount trapped in left side
        while (p2 < len) {
            if (arr[p2] < arr[p1]) {
                tempSum += arr[p1] - arr[p2];
            } else {
                if (p2 - p1 > 1) {
                    trapSum += tempSum;
                    tempSum = 0;
                }
                p1 = p2;
            }
            p2++;
        }

        int p3 = p1;
        tempSum = 0;
        p1 = p2 = len - 1;

        while (p2 >= p3) {
            if (arr[p2] < arr[p1]) {
                tempSum += arr[p1] - arr[p2];
            } else {
                if (p1 - p2 > 1) {
                    trapSum += tempSum;
                    tempSum = 0;
                }
                p1 = p2;
            }
            p2--;
        }

        return trapSum;
    }
}
/* Scope for optimization */