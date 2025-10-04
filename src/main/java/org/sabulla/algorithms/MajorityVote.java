package org.sabulla.algorithms;

import org.sabulla.metrics.PerformanceTracker;

import java.util.NoSuchElementException;

/**
 * Implements the Boyer–Moore Majority Vote algorithm.
 * Finds the element that appears more than n/2 times in an array.
 * Time complexity: O(n), Space complexity: O(1).
 */

public class MajorityVote {
    /**
     * Finds the majority element in the given array.
     *
     * @param arr     the input array
     * @param tracker the performance tracker for metrics
     * @return the majority element
     * @throws NoSuchElementException if no majority element is found or array is empty
     */

    public int findMajority(int[] arr, PerformanceTracker tracker) {
        tracker.reset();
        tracker.start();

        if (arr.length == 0) {
            throw new NoSuchElementException("Array is empty");
        } else if (arr.length == 1) {
            return arr[0];
        }

        int candidate = findCandidate(arr, tracker);
        boolean check = checkCandidate(arr, candidate, tracker);

        tracker.stop();

        if (!check) {
            throw new NoSuchElementException("No majority element found");
        } else {
            return candidate;
        }
    }

    private int findCandidate(int[] arr, PerformanceTracker tracker) {
        int candidate = 0;
        int count = 0;

        for (int j : arr) {
            tracker.addArrayAccesses();
            tracker.addComparisons();
            if (count == 0) {
                candidate = j;
                count = 1;
            } else if (j == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    private boolean checkCandidate(int[] arr, int candidate, PerformanceTracker tracker) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            tracker.addArrayAccesses();
            if (count + (arr.length - i) < arr.length / 2) {
                break;
            }

            tracker.addComparisons();
            if (arr[i] == candidate) {
                count++;
            }
        }

        return count > (arr.length / 2);
    }
}
