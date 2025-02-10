package org.example.sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.opentest4j.AssertionFailedError;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SelectionSortTest {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testSelectionSort(int[] input, int[] expected) {
        var actual = SelectionSort.sort(input.clone());
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
                Arguments.of(new int[]{}, new int[]{}) // Empty array
        );
    }

}
