package com.example.ds.tree;

import com.example.ds.queue.BasicQueue;

public class BasicBinaryTree<X extends Comparable<X>> {
    private Node root;
    private int size;

    public BasicBinaryTree() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void add(X item) {
        Node newNode = new Node(item);

        if (root == null) {
            this.root = newNode;
            System.out.println("Set root: " + item);
            this.size++;
        } else {
            insert(this.root, newNode);
        }
    }

    public boolean delete(X item) {
        boolean deleted = false;

        if (this.root == null)
            return false;

        Node currentNode = getNode(item);
        if (currentNode != null) {
            // for leaf node
            if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                unlink(currentNode, null);
                this.size--;
                deleted = true;
            }
            // only has right child
            else if (currentNode.getLeft() == null && currentNode.getRight() != null) {
                unlink(currentNode, currentNode.getRight());
                this.size--;
                deleted = true;
            }
            // only has left child
            else if (currentNode.getLeft() != null && currentNode.getRight() == null) {
                unlink(currentNode, currentNode.getLeft());
                this.size--;
                deleted = true;
            } else {
                Node child = currentNode.getLeft();

                while (child.getRight() != null) {
                    child = child.getRight();
                }
                // we have the right most node. We can replace the current node with this node.
                if (child.getLeft() != null) {
                    child.getParent().setRight(child.getLeft());
                } else {
                    child.getParent().setRight(null);
                }
                child.setLeft(currentNode.getLeft());
                child.setRight(currentNode.getRight());

                unlink(currentNode, child);
                this.size--;
                deleted = true;
            }
        }

        return deleted;
    }

    private void unlink(Node currentNode, Node newNode) {
        if (currentNode == this.root) {
            newNode.setLeft(currentNode.getLeft());
            newNode.setRight(currentNode.getRight());
            this.root = newNode;
        } else if (currentNode.getParent().getRight() == currentNode) {
            currentNode.getParent().setRight(newNode);
        } else {
            currentNode.getParent().setLeft(newNode);
        }
    }

    private Node getNode(X item) {
        Node currentNode = root;
        while (currentNode != null) {
            int val = item.compareTo(currentNode.getItem());
            if (val == 0)
                return currentNode;
            else if (val < 0)
                currentNode = currentNode.getLeft();
            else
                currentNode = currentNode.getRight();
        }
        return null;
    }

    public boolean contains(X item) {

        Node currentNode = root;
        while (currentNode != null) {
            int val = item.compareTo(currentNode.getItem());
            if (val == 0)
                return true;
            else if (val < 0)
                currentNode = currentNode.getLeft();
            else
                currentNode = currentNode.getRight();
        }
        return false;

    }

    private void insert(Node parent, Node child) {
        // if the child is less than the parent it goes to left
        if (child.getItem().compareTo(parent.getItem()) < 0) {
            if (parent.getLeft() == null) {
                parent.setLeft(child);
                child.setParent(parent);
                this.size++;
            } else {
                insert(parent.getLeft(), child);
            }
        } else if (child.getItem().compareTo(parent.getItem()) > 0) {
            if (parent.getRight() == null) {
                parent.setRight(child);
                child.setParent(parent);
                this.size++;
            } else {
                insert(parent.getRight(), child);
            }
        } else {
            // do nothing
            System.out.println("Item already added.");
        }
    }

    public void breadthFirstSearch() {
        BasicQueue<Node> q = new BasicQueue<Node>();
        if (this.root == null) return;

        q.enQueue(root);
        bfsTraverse(q);
    }

    private void bfsTraverse(BasicQueue<Node> q) {
        if (q.size() == 0) return;
        Node visitedNode = q.deQueue();
        System.out.println(visitedNode.getItem().toString());
        if (visitedNode.getLeft() != null) q.enQueue(visitedNode.getLeft());
        if (visitedNode.getRight() != null) q.enQueue(visitedNode.getRight());
        bfsTraverse(q);
    }

    private class Node {
        private Node left;
        private Node right;
        private Node parent;
        private X item;

        public Node(X item) {
            this.item = item;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public X getItem() {
            return item;
        }

        public void setItem(X item) {
            this.item = item;
        }
    }

}
