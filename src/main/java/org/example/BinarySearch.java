package org.example;

public class BinarySearch {

    public static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int current = array[mid];

            switch (Integer.compare(current, target)) {
                case 0: // Target found
                    return mid;
                case -1: // Target is greater, move right
                    left = mid + 1;
                    break;
                case 1: // Target is smaller, move left
                    right = mid - 1;
                    break;
            }
        }

        return -1;
    }

}