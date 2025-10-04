package org.sabulla.benchmark;

import org.openjdk.jmh.annotations.*;
import org.sabulla.algorithms.MajorityVote;
import org.sabulla.metrics.PerformanceTracker;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)

public class MajorityVoteBenchmark {

    @Param({"100", "1000", "10000", "100000"})
    int size;
    int[] arr;
    MajorityVote algorithm = new MajorityVote();
    PerformanceTracker tracker = new PerformanceTracker();

    @Setup
    public void setup() {
        arr = new Random().ints(size, 0, 2).toArray();
    }

    @Benchmark
    public int run() {
        return algorithm.findMajority(arr, tracker);
    }
}