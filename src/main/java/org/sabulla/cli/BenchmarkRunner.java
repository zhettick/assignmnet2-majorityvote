package org.sabulla.cli;

import org.sabulla.algorithms.MajorityVote;
import org.sabulla.metrics.PerformanceTracker;

import java.util.Random;
import java.util.NoSuchElementException;

public class BenchmarkRunner {

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000};
        MajorityVote algorithm = new MajorityVote();

        System.out.println("Boyer-Moore Majority Vote Benchmark:");

        for (int size : sizes) {
            int[] arr = generateArray(size);
            PerformanceTracker tracker = new PerformanceTracker();

            try {
                int result = algorithm.findMajority(arr, tracker);
                System.out.println("Array size: " + size + " → Majority element: " + result);
            } catch (NoSuchElementException e) {
                System.out.println("Array size: " + size + " → No majority element found");
            }

            System.out.println("Comparisons: " + tracker.getComparisons());
            System.out.println("Array accesses: " + tracker.getArrayAccesses());
            System.out.println("Time: " + tracker.getTime() / 1000000.0 + " ms");
            System.out.println("------------------------------------------");

            tracker.exportToCSV("docs/performance-plots/benchmark-results.csv");
        }
    }

    private static int[] generateArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }
}