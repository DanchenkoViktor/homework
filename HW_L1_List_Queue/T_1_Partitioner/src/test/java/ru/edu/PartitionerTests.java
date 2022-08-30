package ru.edu;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Predicate;

public class PartitionerTests {

    @Test
    public void commonTest() {

        Predicate<Integer> pred = v -> v % 2 == 0;

        Node<Integer> list = new Node<>(1);
        list.next = new Node<>(2);
        list.next.next = new Node<>(3);
        list.next.next.next = new Node<>(4);
        list.next.next.next.next = new Node<>(5);

        int pos = Helper.partitionBy(list, pred);
        Assert.assertEquals(2, pos);

        Node<Integer> tmp = list;
        for (int i = 0; i < pos; ++i) {
            Assert.assertTrue(pred.test(tmp.value));
            tmp = tmp.next;
        }
        while (tmp != null) {
            Assert.assertFalse(pred.test(tmp.value));
            tmp = tmp.next;
        }
    }

    @Test
    public void noFalseItemTest() {

        Predicate<Integer> pred = v -> v < 10;

        Node<Integer> list = new Node<>(1);
        list.next = new Node<>(2);
        list.next.next = new Node<>(3);
        list.next.next.next = new Node<>(4);
        list.next.next.next.next = new Node<>(5);

        int pos = Helper.partitionBy(list, pred);
        Assert.assertEquals(5, pos);

        Node<Integer> tmp = list;
        while (tmp != null) {
            Assert.assertTrue(pred.test(tmp.value));
            tmp = tmp.next;
        }
    }

    @Test
    public void noTrueItemTest() {

        Predicate<Integer> pred = v -> v > 10;

        Node<Integer> list = new Node<>(1);
        list.next = new Node<>(2);
        list.next.next = new Node<>(3);
        list.next.next.next = new Node<>(4);
        list.next.next.next.next = new Node<>(5);

        int pos = Helper.partitionBy(list, pred);
        Assert.assertEquals(0, pos);

        Node<Integer> tmp = list;
        while (tmp != null) {
            Assert.assertFalse(pred.test(tmp.value));
            tmp = tmp.next;
        }
    }

    @Test
    public void emptyTest() {

        Node<Integer> list = null;
        Assert.assertEquals(0, Helper.partitionBy(list, v -> v % 2 == 0));
    }
}
