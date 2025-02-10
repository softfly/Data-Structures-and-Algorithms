package org.example;

import java.util.Arrays;

public class IterativeMergeSort {

    public static int[] sort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }

        int n = array.length;
        int[] temp = Arrays.copyOf(array, n);

        for (int size = 1; size < n; size *= 2) {

            for (int left = 0; left < n - size; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);
                System.out.printf("[%d,%d][%d,%d]", left, mid, mid, right);

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
        int i = left, j = mid + 1, k = left;

        // Merge two sorted halves into the temp array
        while (i <= mid && j <= right) {
            temp[k++] = (array[i] <= array[j]) ? array[i++] : array[j++];
        }

        // Copy remaining elements from the left half
        while (i <= mid) temp[k++] = array[i++];

        // Copy remaining elements from the right half
        while (j <= right) temp[k++] = array[j++];

        // Copy sorted elements back to the original array
        for (int x = left; x <= right; x++) {
            array[x] = temp[x];
        }
    }
}
