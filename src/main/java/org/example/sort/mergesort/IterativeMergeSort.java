package org.example.sort.mergesort;

import java.util.Arrays;

public class IterativeMergeSort {

    public static int[] sort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }

        int n = array.length;
        int[] temp = Arrays.copyOf(array, n);

        for (int size = 1; size < n; size *= 2) {
            int mergedSize = 2 * size;

            for (int left = 0; left < n - size; left += mergedSize) {

                int mid = left + size - 1;
                int right = Math.min(left + mergedSize - 1, n - 1);

                System.out.printf("[%d,%d][%d,%d] ", left, mid, mid+1, right);
                mergeSortedHalves(array, temp, left, mid, right);
            }
            System.out.println();
        }

        return array;
    }

    static void mergeSortedHalves(
            int[] array,
            int[] temp,
            int left,
            int mid,
            int right
    ) {
        int mergedIndex = left;
        int leftArrayIndex = left;
        int rightArrayIndex = mid + 1;

        // Merge two sorted halves into the temp array
        while (leftArrayIndex <= mid && rightArrayIndex <= right) {
            int leftValue = array[leftArrayIndex];
            int rightValue = array[rightArrayIndex];

            if (leftValue < rightValue) {
                temp[mergedIndex] = leftValue;
                leftArrayIndex++;
            } else {
                temp[mergedIndex] = rightValue;
                rightArrayIndex++;
            }
            mergedIndex++;
        }

        // Copy remaining elements from the left half
        while (leftArrayIndex <= mid) {
            temp[mergedIndex] = array[leftArrayIndex];
            leftArrayIndex++;
            mergedIndex++;
        }

        /*
        // It won't fail for single‐thread scenario.
        // Copy remaining elements from the right half
        while (rightArrayIndex <= right) {
            temp[mergedIndex] = array[rightArrayIndex];
            rightArrayIndex++;
            mergedIndex++;
        }*/

        // Copy sorted elements back to the original array
        for (int x = left; x <= right; x++) {
            array[x] = temp[x];
        }
    }
}
