package Heaps;

import java.util.*;

public class Heap {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap.add(3);
        minHeap.add(1);
        minHeap.add(4);
        minHeap.add(2);
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll()); // Outputs: 1, 2, 3, 4
        }
    }
}
