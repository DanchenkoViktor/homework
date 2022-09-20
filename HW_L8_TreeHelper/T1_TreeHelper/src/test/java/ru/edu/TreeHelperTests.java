package ru.edu;

import org.junit.Assert;
import org.junit.Test;

public class TreeHelperTests {

    @Test
    public void helperTest() {

        Assert.assertEquals(5, TreeHelper.getLevelSum(new Integer[]{5}, 0));
        Assert.assertEquals(5, TreeHelper.getLevelSum(new Integer[]{5, 1, null}, 0));
        Assert.assertEquals(1, TreeHelper.getLevelSum(new Integer[]{5, 1, null}, 1));
        Assert.assertEquals(10, TreeHelper.getLevelSum(new Integer[]{5, null, 10}, 1));
        Assert.assertEquals(22, TreeHelper.getLevelSum(new Integer[]{10, 2, 20, 1, null, 15}, 1));
        Assert.assertEquals(16, TreeHelper.getLevelSum(new Integer[]{10, 2, 20, 1, null, 15}, 2));
        Assert.assertEquals(1, TreeHelper.getLevelSum(new Integer[]{1, 5, 15, 2, 8, 10, 20, null, null, null, 27, null}, 0));
        Assert.assertEquals(20, TreeHelper.getLevelSum(new Integer[]{1, 5, 15, 2, 8, 10, 20, null, null, null, 27, null}, 1));
        Assert.assertEquals(40, TreeHelper.getLevelSum(new Integer[]{1, 5, 15, 2, 8, 10, 20, null, null, null, 27, null}, 2));
        Assert.assertEquals(9, TreeHelper.getLevelSum(new Integer[]{1, 5, 15, 2, 8, 10, 20, null, null, null, 9, null}, 3));

        Assert.assertEquals(1, TreeHelper.getLevelSum(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 0));
        Assert.assertEquals(5, TreeHelper.getLevelSum(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 1));
        Assert.assertEquals(22, TreeHelper.getLevelSum(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 2));
        Assert.assertEquals(50, TreeHelper.getLevelSum(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 3));
        Assert.assertEquals(1, TreeHelper.getLevelSum(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, null, 0, 23, 0, 1}, 4));
    }
}