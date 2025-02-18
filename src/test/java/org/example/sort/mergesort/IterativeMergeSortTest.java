package org.example.sort.mergesort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.opentest4j.AssertionFailedError;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class IterativeMergeSortTest {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testIterativeMergeSort(int[] input, int[] expected) {
        var actual = input.clone();
        IterativeMergeSort.sort(actual);
        try {
            assertArrayEquals(expected, actual);
        } catch (AssertionFailedError e) {
            System.out.println("Input:    " + Arrays.toString(input));
            System.out.println("Expected: " + Arrays.toString(expected));
            System.out.println("Actual:   " + Arrays.toString(actual));
            throw e;
        }
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{-3, -2, -1, 0, 1, 2, 3}, new int[]{-3, -2, -1, 0, 1, 2, 3}), // Sorted
                Arguments.of(new int[]{3, 2, 1, 0, -1, -2, -3}, new int[]{-3, -2, -1, 0, 1, 2, 3}), // Reversed
                Arguments.of(new int[]{2, 2, 1, 1, 0, -1, -2, -2}, new int[]{-2, -2, -1, 0, 1, 1, 2, 2}), // Duplicates
                Arguments.of(new int[]{5}, new int[]{5}), // Single element
                Arguments.of(new int[]{}, new int[]{}), // Empty array
                Arguments.of(new int[]{4, 5, 6, 1, 2, 3}, new int[]{1, 2, 3, 4, 5, 6})
        );
    }

    @ParameterizedTest
    @MethodSource("provideMergeSortedHalvesTestCases")
    public void testMergeSortedHalves(int[] input, int[] expected, int mid) {

        var actual = input.clone();
        var temp = input.clone();
        IterativeMergeSort.mergeSortedHalves(actual, temp, 0, mid, actual.length - 1);

        try {
            assertArrayEquals(expected, actual);
        } catch (AssertionFailedError e) {
            System.out.println("Input:    " + Arrays.toString(input));
            System.out.println("Expected: " + Arrays.toString(expected));
            System.out.println("Actual:   " + Arrays.toString(actual));
            throw e;
        }
    }

    private static Stream<Arguments> provideMergeSortedHalvesTestCases() {
        return Stream.of(
                //Arguments.of(new int[]{2,1}, new int[]{1,2}, 0),
                //Arguments.of(new int[]{1,3,2,4}, new int[]{1,2,3,4}, 1),
                //Arguments.of(new int[]{1,3,5,2,4}, new int[]{1,2,3,4,5}, 2) // Left is longer, copy elements from right at the end.
                Arguments.of(new int[]{1,2,3,5,6}, new int[]{1,2,3,5,6}, 2) // Right is longer, copy elements from right at the end.
                //Arguments.of(new int[]{-3, -2, -1, 0, 1, 2, 3}, new int[]{-3, -2, -1, 0, 1, 2, 3}), // Sorted
                //Arguments.of(new int[]{3, 2, 1, 0, -1, -2, -3}, new int[]{-3, -2, -1, 0, 1, 2, 3}), // Reversed
                //Arguments.of(new int[]{2, 2, 1, 1, 0, -1, -2, -2}, new int[]{-2, -2, -1, 0, 1, 1, 2, 2}), // Duplicates
                //Arguments.of(new int[]{5}, new int[]{5}), // Single element
                //Arguments.of(new int[]{}, new int[]{}), // Empty array
                //Arguments.of(new int[]{4, 5, 6, 1, 2, 3}, new int[]{1, 2, 3, 4, 5, 6})
        );
    }

}
