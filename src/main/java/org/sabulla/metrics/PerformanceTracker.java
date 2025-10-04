package org.sabulla.metrics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Tracks algorithm performance metrics such as comparisons,
 * array accesses, memory allocations, and execution time. Additionally, it provides a method
 * to export collected metrics to a CSV file for further analysis and benchmarking.
 */

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

    /**
     * Exports the collected metrics to a CSV file. If the file does not exist,
     * it creates it and writes a header row. Each call appends a new row.
     *
     * @param fileName the name (or path) of the CSV file to export to
     */

    public void exportToCSV(String fileName) {
        File file = new File(fileName);
        boolean fileExists = file.exists();
        try (FileWriter writer = new FileWriter(fileName, true)) {
            if (!fileExists) {
                writer.write("Comparisons,ArrayAccesses,MemoryAllocations,Time(ms)\n");
            }
            writer.write(comparisons + "," + arrayAccesses + "," + memoryAllocations + "," + time / 1000000.0 + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
