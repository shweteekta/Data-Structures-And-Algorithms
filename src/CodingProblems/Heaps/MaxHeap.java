package Heaps;

import java.util.*;

public class MaxHeap {
    private int[] heap;
    private int capacity;
    private int size;

    public MaxHeap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    public void insert(int value){
        if (size == capacity){
            System.out.println("Heap is full");
        }
        heap[size] = value;
        heapifyUp(size);
        size++;
    }
    // Heapify Up (or Bubble Up):
    // Purpose: Ensures that the element at a given index (usually the last element in the heap after insertion) is in the correct position to maintain the heap property.
    // Direction: It moves the element up the heap, comparing it with its parent and swapping if necessary until the heap property is satisfied.
    // Typical Use Case: After inserting an element at the end of the heap.
    private void heapifyUp(int index) {
        int parentIndex = (index-1)/2;
        while (index > 0 && heap[index] > heap[parentIndex]){
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index-1)/2;
        }
    }

    private int extractMax(){
        if (size == 0) {
            System.out.println("Heap is empty. Cannot extract max element.");
            return -1; // or throw an exception
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        heapifyDown(0);
        size--;
        return max;
    }

//    Heapify Down (or Bubble Down or Heapify Top-Down):
//    Purpose: Ensures that the element at a given index (usually the root after removal or replacement) is in the correct position to maintain the heap property.
//    Direction: It moves the element down the heap, comparing it with its children and swapping with the larger (for max heap) or smaller (for min heap) child until the heap property is satisfied.
//    Typical Use Case: After removing the root element or replacing it with another element.
    private void heapifyDown(int index){
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        if (left < size && heap[left] > heap[index]){
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]){
            largest = right;
        }
        if (largest != index){
            swap(largest, index);
            heapifyDown(largest);
        }
    }

    private void swap(int index, int index2) {
        int temp = heap[index];
        heap[index] = heap[index2];
        heap[index2] = temp;
    }

    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOfRange(heap, 0, size)));
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);

        maxHeap.insert(3);
        maxHeap.insert(1);
        maxHeap.insert(4);
        maxHeap.insert(2);

        System.out.print("Max Heap: ");
        maxHeap.printHeap(); // Outputs: [4, 2, 3, 1]

        System.out.println("Extracted Max: " + maxHeap.extractMax()); // Outputs: 4

        System.out.print("Max Heap after extraction: ");
        maxHeap.printHeap(); // Outputs: [3, 2, 1]
    }
}
