package com.example.apps;

import com.example.ds.queue.BasicQueue;
import com.example.ds.tree.BasicBinaryTree;

public class BreadthFirstSearch {


    public static void main(String[] args) {
        BasicBinaryTree<Integer> tree = new BasicBinaryTree<Integer>();

        tree.add(4);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        tree.add(5);
        tree.add(6);

        tree.breadthFirstSearch();

    }
}
