package com.example.ds.list;

public class BasicLinkedList<X> {
    private Node first;
    private Node last;
    private int nodeCount;

    public BasicLinkedList() {
        first = null;
        last = null;
        nodeCount = 0;
    }

    public void add(X item) {
        if (first == null) {
            first = new Node(item);
            last = first;
        } else {
            Node newLastNode = new Node(item);
            last.setNextNode(newLastNode);
            last = newLastNode;
        }
        nodeCount++;
    }

    public X remove() {
        if (first == null) throw new IllegalStateException("Linked list is empty!");
        X nodeItem = first.nodeItem;
        first = first.getNextNode();
        nodeCount--;
        return nodeItem;
    }

    // Insert after a given position
    public void insert(X item, int position) {
        if (position > size() || position < 1) throw new IllegalStateException("Invalid insertion attempt.");

        Node currentNode = first;
        for (int i = 1; i < position && currentNode != null; i++)
            currentNode = currentNode.getNextNode();

        Node newNode = new Node(item);
        newNode.setNextNode(currentNode.getNextNode());
        currentNode.setNextNode(newNode);
        nodeCount++;
    }

    public X removeAt(int position) {
        if (size() == 0 || position < 1) throw new IllegalStateException("Can't remove. Linked list is empty.");

        Node currentNode = first;
        Node prevNode = first;

        for (int i = 1; i < position && currentNode != null; i++) {
            prevNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

        X nodeItem = currentNode.nodeItem;
        prevNode.setNextNode(currentNode.getNextNode());
        nodeCount--;
        return nodeItem;
    }

    public X get(int position) {
        if (size() == 0) throw new IllegalStateException("Empty Linked list");
        if (size() < position || position < 1) return null; //throw new IllegalStateException("Invalid position");

        Node currentNode = first;

        for (int i = 1; i < position && currentNode != null; i++)
            currentNode = currentNode.getNextNode();

        return currentNode.nodeItem;
    }

    public int find(X item) {
        if (size() == 0) throw new IllegalStateException("Can not find in an empty Linked list.");

        Node currentNode = first;

        for (int i = 1; i <= size() && currentNode != null; i++) {
            if (currentNode.getNodeItem().equals(item)) return i;

            currentNode = currentNode.getNextNode();
        }

        return -1;
    }

    public String toString() {
        StringBuffer contents = new StringBuffer();
        Node curNode = first;

        while(curNode!=null) {
            contents.append((curNode.getNodeItem()));
            curNode = curNode.getNextNode();

            if(curNode != null) {
                contents.append(", ");
            }
        }
        return contents.toString();
    }

    public int size() {
        return nodeCount;
    }


    // Node class
    private class Node {
        private Node nextNode;
        private X nodeItem;

        public Node(X item) {
            this.nextNode = null;
            this.nodeItem = item;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node getNextNode() {
            return this.nextNode;
        }

        public X getNodeItem() {
            return this.nodeItem;
        }
    }
}
