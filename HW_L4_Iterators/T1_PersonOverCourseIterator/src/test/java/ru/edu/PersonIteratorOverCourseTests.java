package ru.edu;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PersonIteratorOverCourseTests {

    @Test
    public void simpleTest() {

        SchoolJournal journal = new SchoolJournal();

        journal.addPerson(new Person("1", "", 1));
        journal.addPerson(new Person("2", "", 1));
        journal.addPerson(new Person("3", "", 1));
        journal.addPerson(new Person("4", "", 1));

        Iterator<Person> it = journal.courseIterator(1);

        Person person = it.next();

        Assert.assertTrue(it.hasNext());
        Assert.assertEquals("1", person.getFirstName());
        Assert.assertEquals(1, person.getCourse());

        person = it.next();

        Assert.assertTrue(it.hasNext());
        Assert.assertEquals("2", person.getFirstName());
        Assert.assertEquals(1, person.getCourse());

        person = it.next();

        Assert.assertTrue(it.hasNext());
        Assert.assertEquals("3", person.getFirstName());
        Assert.assertEquals(1, person.getCourse());

        person = it.next();

        Assert.assertEquals("4", person.getFirstName());
        Assert.assertEquals(1, person.getCourse());

        Assert.assertFalse(it.hasNext());
        try {
            it.next();
            Assert.fail();
        } catch (NoSuchElementException ex) {
        }
    }

    @Test
    public void severalTest() {

        SchoolJournal journal = new SchoolJournal();

        journal.addPerson(new Person("1", "", 1));
        journal.addPerson(new Person("2", "", 2));
        journal.addPerson(new Person("3", "", 2));
        journal.addPerson(new Person("4", "", 1));

        Iterator<Person> it = journal.courseIterator(1);

        Person person = it.next();

        Assert.assertTrue(it.hasNext());
        Assert.assertEquals("1", person.getFirstName());
        Assert.assertEquals(1, person.getCourse());

        person = it.next();

        Assert.assertEquals("4", person.getFirstName());
        Assert.assertEquals(1, person.getCourse());

        Assert.assertFalse(it.hasNext());
        try {
            it.next();
            Assert.fail();
        } catch (NoSuchElementException ex) {
        }
    }

    @Test
    public void noElementsTest() {

        SchoolJournal journal = new SchoolJournal();

        journal.addPerson(new Person("1", "", 2));
        journal.addPerson(new Person("2", "", 2));
        journal.addPerson(new Person("3", "", 2));
        journal.addPerson(new Person("4", "", 2));

        Iterator<Person> it = journal.courseIterator(1);

        Assert.assertFalse(it.hasNext());
        try {
            it.next();
            Assert.fail();
        } catch (NoSuchElementException ex) {
        }
    }

    @Test
    public void removeTest() {

        SchoolJournal journal = new SchoolJournal();

        Iterator<Person> it = journal.courseIterator(1);

        Assert.assertFalse(it.hasNext());
        try {
            it.remove();
            Assert.fail();
        } catch (IllegalStateException ex) {
        }

        journal.addPerson(new Person("1", "", 1));
        journal.addPerson(new Person("2", "", 2));
        journal.addPerson(new Person("3", "", 2));
        journal.addPerson(new Person("4", "", 1));

        it = journal.courseIterator(1);

        Person person = it.next();

        Assert.assertTrue(it.hasNext());
        Assert.assertEquals("1", person.getFirstName());
        Assert.assertEquals(1, person.getCourse());

        it.remove();

        person = it.next();

        Assert.assertEquals("4", person.getFirstName());
        Assert.assertEquals(1, person.getCourse());

        Assert.assertFalse(it.hasNext());

        it = journal.courseIterator(1);
        Assert.assertTrue(it.hasNext());

        person = it.next();

        Assert.assertEquals("4", person.getFirstName());
        Assert.assertEquals(1, person.getCourse());

        Assert.assertFalse(it.hasNext());

        it.remove();
        Assert.assertFalse(journal.courseIterator(1).hasNext());
        try {
            it.remove();
            Assert.fail();
        } catch (IllegalStateException ex) {
        }
    }
}
