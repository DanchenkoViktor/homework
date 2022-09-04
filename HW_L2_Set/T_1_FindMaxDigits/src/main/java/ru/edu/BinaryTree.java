package ru.edu;

public class BinaryTree {

    private Node root;

    public boolean add(int value) {

        Node previous = null;
        Node tmp = root;
        int cmp = 0;

        while (tmp != null) {
            cmp = Integer.compare(value, tmp.value);
            if (cmp == 0) {
                return false;
            }
            previous = tmp;
            if (cmp < 0) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        Node newNode = new Node(value);
        if (previous == null) {
            root = newNode;
        } else {
            if (cmp < 0) {
                previous.left = newNode;
            } else {
                previous.right = newNode;
            }
        }
        newNode.parent = previous;
        return true;
    }

    /**
     * Find maximum elements not greater than upper bound.
     * Returns array with maximum elements.
     *
     * @param count      - count of maximums
     * @param upperBound - upper bound of maximums
     */
    public int[] findMaxDigits(int count, int upperBound) {
        throw new RuntimeException("Not implemented");
    }

    public void print() {
        System.out.print("Tree:");
        print(root);
        System.out.println();
    }

    private void print(Node node) {
        if (node != null) {
            print(node.left);
            System.out.print(" " + node.value);
            print(node.right);
        }
    }
}