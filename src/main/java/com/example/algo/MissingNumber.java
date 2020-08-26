package com.example.algo;

/**
 * Given an array C of size N-1 and given that there are numbers from 1 to N with one element missing, the missing number is to be found.
 * <p>
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. For each test case first line contains N(size of array). The subsequent line contains N-1 array elements.
 * <p>
 * Output:
 * Print the missing number in array.
 * <p>
 * Constraints:
 * 1 ≤ T ≤ 200
 * 1 ≤ N ≤ 107
 * 1 ≤ C[i] ≤ 107
 * <p>
 * Example:
 * Input:
 * 2
 * <p>
 * 5
 * <p>
 * 1 2 3 5
 * <p>
 * 10
 * <p>
 * 1 2 3 4 5 6 7 8 10
 * <p>
 * Output:
 * 4
 * <p>
 * 9
 * <p>
 * Explanation:
 * Testcase 1: Given array : 1 2 3 5. Missing element is 4.
 */
public class MissingNumber {
    public static void main(String[] args) {
        int n = 10;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 10};
        int i = 0;
        int j = arr.length - 1;
        try {
            int missingNumber = findMissing(arr, i, j);
            System.out.println("Missing number: " + missingNumber);
        } catch (IllegalStateException ex) {
            System.out.println("ERROR: "+ ex.getMessage());
        }
    }

    private static int findMissing(int[] arr, int i, int j) {
        // single/target element
        if (i == j) {
            if (arr[i] != i + 1) return i + 1;
            else throw new IllegalStateException("No item missing!");
        } else {
            int mid = (i + j) / 2;
            if (arr[mid] == mid + 1) i = mid + 1;
            else j = mid;
            return findMissing(arr, i, j);
        }
    }
}
