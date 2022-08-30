package ru.edu;

import java.util.function.Predicate;

public class Helper {

    /**
     * Partition list by predicate.
     * Returns position pos of first item where predicate is false.
     * For elements in (0, pos) predicate is true. For elements in [pos, end) predicate is false.
     * <p>
     * Example:
     * <p>
     * IN: list = 1 -> 2 -> 3 -> 4 -> 5
     * <p>
     * OUT: list = 2 -> 4 -> 1 -> 3 -> 5
     * POS = 2
     *
     * @param list - list
     * @param pred - predicate
     */

    public static <T> int partitionBy(Node<T> list, Predicate<T> pred) {
        throw new RuntimeException("Not implemented");
    }
}
