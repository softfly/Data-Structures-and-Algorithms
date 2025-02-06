package org.example;

public class SelectionSort {

    public static int[] sort(int[] array) {

        for (int sortedBoundary = 0; sortedBoundary < array.length - 1; sortedBoundary++) {
            int minIndex = findMinIndex(array, sortedBoundary);
            swap(array, sortedBoundary, minIndex);
        }

        return array;
    }

    private static int findMinIndex(int[] array, int startIndex) {
        int minIndex = startIndex;

        for (int i = startIndex + 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }

        return minIndex;
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int previous = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = previous;
    }

}
