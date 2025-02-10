package org.example.sort.mergesort;

import java.util.Arrays;

public class RecursiveMergeSort {

    public static int[] sort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        splitAndSort(array, 0, array.length - 1);
        return array;
    }

    private static void splitAndSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        splitAndSort(array, left, mid);
        splitAndSort(array, mid + 1, right);

        mergeSortedHalves(array, left, mid, right);
    }

    private static void mergeSortedHalves(int[] array, int left, int mid, int right) {
        int[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);

        int leftIndex = 0, rightIndex = 0, mergedIndex = left;

        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                array[mergedIndex++] = leftArray[leftIndex++];
            } else {
                array[mergedIndex++] = rightArray[rightIndex++];
            }
        }

        copyRemainingElements(leftArray, leftIndex, array, mergedIndex);
        // The right half doesn't need to be copied because it's already there.
    }

    private static void copyRemainingElements(int[] input, int inputIndex, int[] output, int outputIndex) {
        while (inputIndex < input.length) {
            output[outputIndex++] = input[inputIndex++];
        }
    }

}
