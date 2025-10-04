package org.sabulla.algorithms;

import org.junit.jupiter.api.Test;
import org.sabulla.metrics.PerformanceTracker;

import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class MajorityVoteTest {
    MajorityVote majorityVote = new MajorityVote();

    @Test
    void testEmptyArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        int[] arr = {};
        assertThrows(NoSuchElementException.class, () -> majorityVote.findMajority(arr, tracker));
        assertEquals(0, tracker.getComparisons());
        assertEquals(0, tracker.getArrayAccesses());
        assertEquals(0, tracker.getMemoryAllocations());
        assertEquals(0, tracker.getTime());
    }

    @Test
    void testOneElementArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        int[] arr = {5};
        int result = majorityVote.findMajority(arr, tracker);
        assertEquals(arr[0], result);
        assertTrue(tracker.getComparisons() >= 0);
        assertTrue(tracker.getArrayAccesses() >= 0);
        assertEquals(0, tracker.getMemoryAllocations());
        assertTrue(tracker.getTime() >= 0);
    }

    @Test
    void testNoMajorityArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        int[] arr = {1, 2, 2, 3};
        assertThrows(NoSuchElementException.class, () -> majorityVote.findMajority(arr, tracker));
        assertTrue(tracker.getComparisons() > 0);
        assertTrue(tracker.getArrayAccesses() > 0);
        assertEquals(0, tracker.getMemoryAllocations());
        assertTrue(tracker.getTime() > 0);
    }

    @Test
    void testDuplicateArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        int[] arr = {5, 5, 5, 5, 5, 5};
        int result = majorityVote.findMajority(arr, tracker);
        assertEquals(5, result);
        assertTrue(tracker.getComparisons() > 0);
        assertTrue(tracker.getArrayAccesses() > 0);
        assertEquals(0, tracker.getMemoryAllocations());
        assertTrue(tracker.getTime() > 0);
    }

    @Test
    void testArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        int[] arr = {2, 2, 1, 2, 3, 2, 2, 3, 1};
        int result = majorityVote.findMajority(arr, tracker);
        assertEquals(2, result);
        assertTrue(tracker.getComparisons() > 0);
        assertTrue(tracker.getArrayAccesses() > 0);
        assertEquals(0, tracker.getMemoryAllocations());
        assertTrue(tracker.getTime() > 0);
    }

    @Test
    void testBigArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        int[] arr = new int[100000];
        for (int i = 0; i < 50001; i++) {
            arr[i] = 5;
        }
        for (int i = 50001; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        int result = majorityVote.findMajority(arr, tracker);
        assertEquals(5, result);
        assertTrue(tracker.getComparisons() > 0);
        assertTrue(tracker.getArrayAccesses() > 0);
        assertEquals(0, tracker.getMemoryAllocations());
        assertTrue(tracker.getTime() >= 0 && tracker.getTime() < 100000000);
    }
}
