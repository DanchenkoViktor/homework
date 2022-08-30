package ru.edu;

import org.junit.Assert;
import org.junit.Test;

public class NthChildTests {

    @Test
    public void commonTest() {

        Node<Integer> list = new Node<>(1);
        list.next = new Node<>(2);
        list.next.next = new Node<>(3);
        list.next.next.next = new Node<>(4);
        list.next.next.next.next = new Node<>(5);

        Assert.assertNull(Helper.<Integer>findNthElement(null, 1));
        Assert.assertEquals(5, Helper.findNthElement(list, 1).intValue());
        Assert.assertEquals(4, Helper.findNthElement(list, 2).intValue());
        Assert.assertEquals(3, Helper.findNthElement(list, 3).intValue());
        Assert.assertEquals(2, Helper.findNthElement(list, 4).intValue());
        Assert.assertEquals(1, Helper.findNthElement(list, 5).intValue());
        Assert.assertNull(Helper.findNthElement(list, 6));
        Assert.assertNull(Helper.findNthElement(list, 100));
    }
}
