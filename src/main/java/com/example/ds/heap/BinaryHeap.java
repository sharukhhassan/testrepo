package com.example.ds.heap;

public class BinaryHeap<X extends Comparable<X>> {
    private final X[] arr;
    private int count = 0;

    public BinaryHeap(int size) {
        arr = (X[]) new Comparable[size];
    }

    public void add(X item) {
        if (count == arr.length) {
            throw new ArrayStoreException("Heap capacity reached.");
        } else {
            arr[count] = item;
            swim(count);
            count++;
        }
    }

    public X poll() {
        if (count == 0) throw new IllegalStateException("Heap empty.");
        X item = arr[0];
        remove(item);
        return item;
    }

    public void remove(X item) {
        int i = 0;
        while (i < count) {
            if (arr[i].equals(item)) {
                arr[i] = arr[count - 1];
                arr[--count] = null;
                sink(i);
                swim(i);
                return;
            }
            i++;
        }
        System.out.println("Item not found.");
    }

    private void swim(int pos) {
        while (pos > 0) {
            if (less(pos, (pos - 1) / 2)) {
                swap(pos, (pos - 1) / 2);
            } else {
                break;
            }
            pos = (pos - 1) / 2;
        }

    }

    private void sink(int pos) {
        while (pos < count) {
            if (((2 * pos + 1 >= count) || (2 * pos + 1 < count && less(pos, 2 * pos + 1))) &&
                    ((2 * pos + 2 >= count) || (2 * pos + 2 < count && less(pos, 2 * pos + 2)))) {
                return;
            } else {
                if (arr[2 * pos + 1].equals(arr[2 * pos + 2])) {
                    swap(pos, 2 * pos + 1);
                } else {
                    int swapPos = (less(2 * pos + 1, 2 * pos + 2)) ? 2 * pos + 1 : 2 * pos + 2;
                    swap(pos, swapPos);

                }

            }
            pos++;
        }

    }

    // Tests if the value of node i <= node j
    // This method assumes i & j are valid indices, O(1)
    private boolean less(int i, int j) {
        X node1 = arr[i];
        X node2 = arr[j];
        return node1.compareTo(node2) <= 0;
    }

    private void swap(int i, int j) {
        X temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public String toString() {
        if (count == 0) return "";
        StringBuilder s = new StringBuilder();
        int i = 0;
        int l = 0;
        while (i < count) {
            for (int j = i; j < i + Math.pow(2, l) && j < count; j++) {
                s.append(arr[j]).append(" ");
            }
            s.append("\n");

            i += Math.pow(2, l);
            l++;
        }

        return s.toString();
    }
}


