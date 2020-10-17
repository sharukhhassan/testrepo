package com.example.algo;

import java.util.Scanner;

/**
 * Input : arr[] = {4, -10, 4, 4, 4}
 * <p>
 * Output: 7
 * <p>
 * Suppose initially we have energy = 0, now at 1st
 * checkpoint, we get 4. At 2nd checkpoint, energy gets
 * reduced by -10 so we have 4 + (-10) = -6 but at any
 * checkpoint value of energy can not less than equals
 * to 0. So initial energy must be at least 7 because
 * having 7 as initial energy value at 1st checkpoint
 * our energy will be = 7+4 = 11 and then we can cross
 * 2nd checkpoint successfully. Now after 2nd checkpoint,
 * all checkpoint have positive value so we can cross
 * street successfully with 7 initial energy.
 * <p>
 * Input : arr[] = {3, 5, 2, 6, 1}
 * <p>
 * Output: 1
 * <p>
 * We need at least 1 initial energy to reach first
 * checkpoint
 * <p>
 * Input : arr[] = {-1, -5, -9}
 * Output: 16
 * <p>
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 100
 * -500 ≤ A[i] ≤ 500
 */
public class MinimumInitialEnergy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] n = new int[100];
        int[][] input = new int[100][100];
        for (int i = 0; i < t; i++) {
            n[i] = sc.nextInt();
            for (int j = 0; j < n[i]; j++) {
                input[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < t; i++) {
            int leastNegative = 0;
            int sum = 0;
            for (int j = 0; j < n[i]; j++) {
                sum += input[i][j];
                if (sum < leastNegative) leastNegative = sum;
            }
            System.out.println(1 - leastNegative);
        }
    }
}
