package org.sabulla.metrics;

public class PerformanceTracker {
    private long comparisons;
    private int arrayAccesses;
    private int memoryAllocations;
    private long startTime;
    private long time;

    public void addComparisons() {
        comparisons++;
    }

    public void addArrayAccesses() {
        arrayAccesses++;
    }

    public void addMemoryAllocations() {
        memoryAllocations++;
    }

    public void start() {
        startTime = System.nanoTime();
    }

    public void stop() {
        time = System.nanoTime() - startTime;
    }

    public void reset() {
        comparisons = 0;
        arrayAccesses = 0;
        memoryAllocations = 0;
        startTime = 0;
        time = 0;
    }

    public long getComparisons() {
        return comparisons;
    }

    public int getArrayAccesses() {
        return arrayAccesses;
    }

    public int getMemoryAllocations() {
        return memoryAllocations;
    }

    public long getTime() {
        return time;
    }
}
