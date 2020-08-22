package com.example.ds.queue;

public class BasicQueue<X> {

    private X[] data;
    private int front;
    private int end;

    public BasicQueue() {
        this(1000);
    }

    public BasicQueue(int size) {
        front = -1;
        end = -1;
        data = (X[]) new Object[size];
    }

    public int size() {
        if (front == -1 && end == -1) return 0;
        else if (end >= front) return end - front + 1;
        else return data.length + end - front + 1;
    }

    public void enQueue(X item) {
        // Empty queue
        if (size() == 0) {
            end++;
            front++;
            data[end] = item;
        }
        // Queue full
        else if ((end + 1) % data.length == front) {
            // Not throwing exception
            System.out.println("Queue full!");
        } else {
            end= (end + 1) % data.length;
            data[end] = item;
        }
    }

    public X deQueue() {
        X item = null;
        if (size() == 0) throw new IllegalStateException("No more items in the queue.");
        else if (size() == 1) {
            item = data[front];
            data[front] = null;
            front = end = -1;
        } else {
            item = data[front];
            data[front] = null;
            front= (front + 1) % data.length;
        }
        return item;
    }

    public boolean contains(X item) {
        boolean found = false;
        if (size() == 0) return found;

        if(end>=front) {
            for (int i = front; i < end; i++) {
                if (data[i].equals(item)) {
                    found = true;
                    break;
                }
            }
        }
        else {
            for (int i = front; i < end + data.length; i++) {
                if (data[i % data.length].equals(item)) {
                    found = true;
                    break;
                }
            }
        }

        return found;
    }

    public X access(int position) {
        if (size() == 0 || position > size()) {
            throw new IllegalArgumentException("No items in the queue or the position is greater than queue size.");
        }
        int trueIndex = 0;
        if(end>=front) {
            for (int i = front; i <= end; i++) {
                if (trueIndex == position) return data[i];
                trueIndex++;
            }
        }
        else {
            for (int i = front; i <= end+ data.length; i++) {
                if (trueIndex == position) return data[i % data.length];
                trueIndex++;
            }
        }


        throw new IllegalArgumentException("No items in the queue at position: " + position);
    }
}
