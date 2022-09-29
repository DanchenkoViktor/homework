package ru.edu;

public class TreeHelper {

    /**
     * Get elements sum located on specific level in tree (COMMON TREE).
     * Tree presented as array.
     * > Root at index 0.
     * > LeftChild(i) = 2 * i + 1
     * > RightChild(i) = LeftChild(i) + 1 = 2 * i + 2
     * > Null for empty child
     *
     * @param array - array that contains tree.
     */
    public static int getLevelSum(Integer[] array, int level) {
        int[] sum = new int[getHeight(array) + 1];
        int index = 0;

        while (index < array.length) {
            for (int i = 0; i < (getHeight(array) + 1); i++) {
                int iter = 0;
                while (iter < getCountElementFromLevel(i) && index < array.length) {
                    int delta = array[index] == null ? 0 : array[index];
                    sum[i] += delta;
                    index++;
                    iter++;
                }
            }
            if (index < getCountElementFromLevel(index))
                break;
        }

        return sum[level];
    }

    private static int getCountElementFromLevel(int level) {
        return (int) Math.pow(2, level);
    }

    private static int getHeight(Integer[] data) {
        return (int) Math.round(Math.log(data.length + 1) / Math.log(2) + 1);
    }
}