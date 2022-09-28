package ru.edu;

public class TreeHelper {

    /**
     * Check if tree is a valid binary search tree.
     * Tree presented as array.
     * > Root at index 0.
     * > LeftChild(i) = 2 * i + 1
     * > RightChild(i) = LeftChild(i) + 1 = 2 * i + 2
     * > Null for empty child
     *
     * @param array - array that contains tree.
     */
    public static boolean isValidBSTTree(Integer[] array) {
        return isValidBSTTree(array, 0);
    }

    private static boolean isValidBSTTree(Integer[] data, int parent) {
        if (data[parent] == null)
            return true;

        if (data.length == 1) {
            return true;
        }

        if (leftChild(parent) < data.length && data[leftChild(parent)] != null && data[leftChild(parent)] > data[parent]) {
            return false;
        }
        if (rightChild(parent) < data.length && data[rightChild(parent)] != null && data[rightChild(parent)] < data[parent]) {
            return false;
        }

        if (leftChild(parent) < data.length && !isValidBSTTree(data, leftChild(parent))
                || rightChild(parent) < data.length && !isValidBSTTree(data, rightChild(parent))) {
            return false;
        }

        return true;
    }

    private static int leftChild(int i) {
        return (2 * i) + 1;
    }

    private static int rightChild(int i) {
        return leftChild(i) + 1;
    }
}
