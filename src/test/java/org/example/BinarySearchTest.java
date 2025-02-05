package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {

    @Test
    public void GivenEmptyArray_ShouldReturnMinusOne() {
        int[] emptyArray = {};
        int result = BinarySearch.binarySearch(emptyArray, 5);
        assertEquals(-1, result);
    }

    @ParameterizedTest
    @CsvSource({
            "7, 3",  // Best case: target in the middle
            "1, 0",  // First element
            "15, 7", // Last element
            "8, -1", // Element not found
            "5, 2"   // Middle-left element
    })
    public void GivenSortedArray_ShouldReturnCorrectIndex(int target, int expected) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15};
        int result = BinarySearch.binarySearch(sortedArray, target);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "42, 0",  // Element found
            "50, -1", // Element not found
    })
    public void GivenSingleElementArray_ShouldReturnCorrectIndex(int target, int expected) {
        int[] singleElementArray = {42};
        int result = BinarySearch.binarySearch(singleElementArray, target);
        assertEquals(expected, result);
    }
}
