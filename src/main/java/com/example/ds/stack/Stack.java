package com.example.ds.stack;

public interface Stack<T> {
    void push(T item);

    T pop();

    boolean contains(T item);

    T access(T item);

    int size();
}
