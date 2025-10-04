# Boyer–Moore Majority Vote Algorithm

This project implements the Boyer–Moore algorithm to find the element that appears more than n/2 times in a linear
array.

## Features

- Implementation of the Boyer–Moore Majority Vote algorithm
- Performance metrics (comparisons, array accesses, execution time)
- Benchmark runner with configurable input sizes
- CSV export for empirical analysis
- Comprehensive unit tests covering edge cases

## Complexity Analysis

- Time complexity: O(n) — single pass for candidate selection + checking
- Space complexity: O(1) — uses constant additional memory
- Works efficiently on large inputs (n up to 10^5)

## Testing

- Unit tests for empty arrays, single element, no majority, duplicates
- Performance tests with input sizes 10² – 10⁵
- Empirical validation via time vs input size plots

## Example

1) Array size: 100 → Majority element: 0
   Comparisons: 200
   Array accesses: 200
   Time: 0.033459 ms

------------------------------------------

2) Array size: 1000 → Majority element: 0
   Comparisons: 2000
   Array accesses: 2000
   Time: 0.295375 ms

------------------------------------------

3) Array size: 10000 → Majority element: 1
   Comparisons: 20000
   Array accesses: 20000
   Time: 1.843959 ms

------------------------------------------

4) Array size: 100000 → Majority element: 0
   Comparisons: 200000
   Array accesses: 200000
   Time: 11.855916 ms

------------------------------------------

## Empirical Analysis

![Time(ms) vs Size.png](docs/performance-plots/Time%28ms%29%20vs%20Size.png)
The chart shows the relationship between the execution time of the Boyer–Moore Majority Vote algorithm and the input
size of the array.
• The horizontal axis (Size) represents the number of elements in the input array.
• The vertical axis (Time(ms)) shows how long the algorithm took to complete for each input size.

From the graph, we can observe the following:
• For small input sizes (100 – 1000), the execution time is extremely low — the algorithm runs almost instantly.
• As the input size grows (10,000 – 100,000), the execution time increases steadily but linearly.
• This confirms the theoretical time complexity of the algorithm: O(n). The execution time grows proportionally with the
size of the input, demonstrating that the algorithm remains efficient and scalable even for large datasets.

## Conclusion

The Boyer–Moore Majority Vote algorithm has proven to be an efficient and reliable method for identifying an element
that occurs in more than half of the elements of an array. Thanks to its single-pass approach and constant memory usage,
it remains stable and high-performing even when processing large volumes of data.

The tests confirmed the theoretical analysis: the execution time of the algorithm grows proportionally
with the size of the input, which corresponds to a linear time complexity of O(n). Its simplicity, scalability, and low
memory requirements make this algorithm a practical solution for real-world tasks related to majority detection — for
example, in information stream analysis, statistical data processing, or user data analysis.

## Project Structure

- src/
    - main/java/
        - org/sabulla/
            - algorithms/MajorityVote.java
            - metrics/PerformanceTracker.java
            - cli/BenchmarkRunner.java
    - test/java/
        - org/sabulla/
            - algorithms/MajorityVoteTest.java
- docs/
  - analysis-report.pdf
  - performance-plots/
      - benchmark-results.csv
      - Time(ms) vs Size.png
    