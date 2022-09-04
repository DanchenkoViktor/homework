package ru.edu;

import org.junit.Assert;
import org.junit.Test;

public class FindMaxDigits {

    @Test
    public void simpleTest() {

        BinaryTree tree = new BinaryTree();
        for (int i = 1; i < 10; ++i) {
            tree.add(i);
        }
        tree.print();

        int[] actualResult = tree.findMaxDigits(3, 5);
        Assert.assertEquals(3, actualResult.length);
        Assert.assertArrayEquals(new int[]{3, 4, 5}, actualResult);

        actualResult = tree.findMaxDigits(4, 15);
        Assert.assertEquals(4, actualResult.length);
        Assert.assertArrayEquals(new int[]{6, 7, 8, 9}, actualResult);

        actualResult = tree.findMaxDigits(4, 2);
        Assert.assertEquals(2, actualResult.length);
        Assert.assertArrayEquals(new int[]{1, 2}, actualResult);

        actualResult = tree.findMaxDigits(4, 0);
        Assert.assertEquals(0, actualResult.length);
    }
}
