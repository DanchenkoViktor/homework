package ru.edu;

import org.junit.Assert;
import org.junit.Test;

public class TreeHelperTests {

    @Test
    public void helperTest() {

        Assert.assertTrue(TreeHelper.isValidBSTTree(new Integer[]{5}));
        Assert.assertTrue(TreeHelper.isValidBSTTree(new Integer[]{5, 1, null}));
        Assert.assertTrue(TreeHelper.isValidBSTTree(new Integer[]{5, null, 10}));
        Assert.assertTrue(TreeHelper.isValidBSTTree(new Integer[]{10, 1, 20, null, null, null}));
        Assert.assertTrue(TreeHelper.isValidBSTTree(new Integer[]{10, 1, 20, null, 5, null, 25, null, null}));
        Assert.assertTrue(TreeHelper.isValidBSTTree(new Integer[]{4, 3, 9, 2, null, 7, null, 1, null, null, null, 6, 8, null, null, 0, null, null, null, null, null, null, null, 5, null}));
        Assert.assertTrue(TreeHelper.isValidBSTTree(new Integer[]{1, 0, 5, null, null, 2, 8, null, null, null, null, null, 4, 7, 9, null, null, null, null, null, null, null, null, null, null, 3, null, 6}));
        Assert.assertTrue(TreeHelper.isValidBSTTree(new Integer[]{5, 5, 5}));

        Assert.assertFalse(TreeHelper.isValidBSTTree(new Integer[]{5, 6, 8}));
        Assert.assertFalse(TreeHelper.isValidBSTTree(new Integer[]{5, 1, 8, 10}));
        Assert.assertFalse(TreeHelper.isValidBSTTree(new Integer[]{5, 2, 8, 1, 0}));
        Assert.assertFalse(TreeHelper.isValidBSTTree(new Integer[]{5, 2, 8, 1, 3, 9, 10}));
        Assert.assertFalse(TreeHelper.isValidBSTTree(new Integer[]{5, 2, 8, 1, 3, 6, 7}));
    }
}