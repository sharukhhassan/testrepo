package com.example.ds.stack;

import java.util.ArrayList;

public class ListStack<X> implements Stack<X> {

    private final ArrayList<X> data = new ArrayList<X>();
    private final int maxSize;
    private int stackPointer;

    public ListStack(int size) {
        maxSize = size;
        stackPointer = 0;
    }

    public void push(X item) {
        if (size() == maxSize) {
            System.out.println("Stack overflow!");
            return;
        }

        data.add(item);
        stackPointer++;
    }

    public X pop() {
        if (size() == 0)
            throw new IllegalStateException("No more items on the stack.");
        X item = data.get(--stackPointer);
        data.remove(stackPointer);
        return item;
    }

    public boolean contains(X item) {
        boolean found = false;
        for (int i = 0; i < stackPointer; i++) {
            if (data.get(i).equals(item)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public X access(X item) {
        while (size() > 0) {
            X tempItem = pop();
            if (item.equals(tempItem)) {
                return item;
            }
        }
        throw new IllegalArgumentException("Could not find the item on the stack: " + item);
    }

    public int size() {
        return stackPointer;
    }
}
