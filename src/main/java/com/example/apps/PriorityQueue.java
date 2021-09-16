package com.example.apps;

import com.example.ds.heap.BinaryHeap;

public class PriorityQueue {
    public static void main(String[] args) {
        BinaryHeap<Integer> heap = new BinaryHeap<>(7);
        heap.add(6);
        heap.add(2);
        heap.add(4);
        heap.add(1);
        heap.add(3);
        heap.add(2);

        System.out.println(heap);
        //heap.add(2);
        heap.poll();
        System.out.println("heap:\n" + heap);
        heap.poll();
        System.out.println("heap:\n" + heap);
        heap.poll();
        System.out.println("heap:\n" + heap);
        heap.poll();
        System.out.println("heap:\n" + heap);
        heap.poll();
        System.out.println("heap:\n" + heap);
        heap.poll();

    }
}
