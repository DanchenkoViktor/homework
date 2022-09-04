package ru.edu;

/**
 * Tree node info.
 * !!! DO NOT CHANGE
 */
public class Node {

    public int value;

    public Node right;
    public Node left;
    public Node parent;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
