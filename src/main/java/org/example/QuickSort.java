package org.example;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr) {
        System.out.println("Start:          " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int pivot = arr[end]; // Pick pivot point
        int pivotIndex = partition(arr, start, end, pivot);

        quickSort(arr, start, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, end);
    }

    static int partition(int[] arr, int start, int end, int pivot) {
        System.out.println("Pick pivot:     " + pivot);

        int smallerIndex = start - 1;

        for (int currentIndex = start; currentIndex < end; currentIndex++) {
            var current = arr[currentIndex];
            if (current < pivot) {
                smallerIndex++;
                swap(arr, smallerIndex, currentIndex);
            }
        }

        System.out.println("Before pivot:   " + Arrays.toString(Arrays.copyOfRange(arr, start, end)));
        swap(arr, smallerIndex + 1, end); // Move pivot to correct position
        System.out.println("After pivot:    " + Arrays.toString(Arrays.copyOfRange(arr, start, end)));
        return smallerIndex + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
