package org.example;

public class BubbleSort {

    public static int[] sort(int[] array) {
        for (int passNumber = 0; passNumber < array.length - 1; passNumber++) {
            if (!performPass(array, passNumber)) {
                break;
            }
        }

        return array;
    }

    private static boolean performPass(int[] array, int passNumber) {
        boolean swapped = false;
        int unsortedBoundary = array.length - 1 - passNumber;

        for (int currentIndex = 0; currentIndex < unsortedBoundary; currentIndex++) {
            swapped = swapIfNeeded(array, currentIndex) || swapped;
        }

        return swapped;
    }

    private static boolean swapIfNeeded(int[] array, int currentIndex) {
        boolean swapped = false;
        int previous = array[currentIndex];
        int next = array[currentIndex + 1];

        if (previous > next) {
            swap(array, currentIndex, currentIndex + 1);
            swapped = true;
        }
        return swapped;
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int previous = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = previous;
    }
}
