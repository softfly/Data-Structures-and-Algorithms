package org.example;

import java.util.Arrays;

public class HoareQuickSort {

    public static void quickSort(int[] arr) {
        System.out.println("Start:          " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        //Hoare’s partition does not return the pivot's final position like Lomuto does.
        int pivotIndex = hoarePartition(arr, start, end);
        quickSort(arr, start, pivotIndex);
        quickSort(arr, pivotIndex + 1, end);
    }

    static int hoarePartition(int[] arr, int start, int end) {
        int pivot = arr[start]; // Choose the first element as pivot
        System.out.println("Pivot: " + pivot);
        System.out.println("Hoare Partition Start: " + Arrays.toString(Arrays.copyOfRange(arr, start, end + 1)));
        int left = start - 1, right = end + 1;

        while (true) {
            // Move right until we find an element ≥ pivot
            do {
                left++;
            } while (arr[left] < pivot);

            // Move left until we find an element ≤ pivot
            do {
                right--;
            } while (arr[right] > pivot);

            // If pointers cross, return j (partition index)
            if (left >= right) {
                return right;
            }

            // Swap arr[i] and arr[j]
            swap(arr, left, right);
            System.out.println("Hoare Partition:       " + Arrays.toString(Arrays.copyOfRange(arr, start, end + 1)));
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
