package ru.edu;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTests {

    private final StringUtils utils = new StringUtils();

    @Test
    public void simpleTest() {

        Assert.assertNull(utils.findMaxSubstring(""));
        Assert.assertNull(utils.findMaxSubstring(null));

        Assert.assertEquals("anto", utils.findMaxSubstring("anton"));
        Assert.assertEquals("vera", utils.findMaxSubstring("vera"));
        Assert.assertEquals("an", utils.findMaxSubstring("anna"));
        Assert.assertEquals("dqwerty", utils.findMaxSubstring("abcddqwertyw"));
        Assert.assertEquals("abc", utils.findMaxSubstring("abcabcabc"));
        Assert.assertEquals("abc", utils.findMaxSubstring("abcbcddec"));
        Assert.assertEquals("abcde", utils.findMaxSubstring("abcabcdecx"));
        Assert.assertEquals("a", utils.findMaxSubstring("a"));
        Assert.assertEquals("bac", utils.findMaxSubstring("abbac"));
        Assert.assertEquals("bax", utils.findMaxSubstring("abbaxac"));
    }
}