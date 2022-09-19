package ru.edu;

import org.junit.Assert;
import org.junit.Test;

import java.time.OffsetDateTime;

public class TicketManagerTests {

    private final TicketManager ticketManager = new TicketManagerImpl();

    @Test
    public void simpleTest() {

        OffsetDateTime now = OffsetDateTime.now();
        ticketManager.add(new Ticket("t4", "fin", now.plusSeconds(1)));
        ticketManager.add(new Ticket("t1", "fin", now));
        ticketManager.add(new Ticket("t2", "fin", now.minusSeconds(1)));
        ticketManager.add(new Ticket("t3", "fin", now.minusMinutes(1)));

        Assert.assertEquals("t3", ticketManager.next().getId());
        Assert.assertEquals("t2", ticketManager.next().getId());
        Assert.assertEquals("t1", ticketManager.next().getId());
        Assert.assertEquals("t4", ticketManager.next().getId());
        Assert.assertNull(ticketManager.next());
    }

    @Test
    public void priorityOpTest() {

        OffsetDateTime now = OffsetDateTime.now();
        ticketManager.add(new Ticket("t4", "pension", now.plusSeconds(1)));
        ticketManager.add(new Ticket("t1", "pension", now));
        ticketManager.add(new Ticket("t2", "pension", now.minusSeconds(1)));
        ticketManager.add(new Ticket("t3", "pension", now.minusMinutes(1)));

        Assert.assertEquals("t3", ticketManager.next().getId());
        Assert.assertEquals("t2", ticketManager.next().getId());
        Assert.assertEquals("t1", ticketManager.next().getId());
        Assert.assertEquals("t4", ticketManager.next().getId());
        Assert.assertNull(ticketManager.next());
    }

    @Test
    public void mixedTest() {

        OffsetDateTime now = OffsetDateTime.now();
        ticketManager.add(new Ticket("t4", "fin", now));
        ticketManager.add(new Ticket("t1", "pension", now.plusSeconds(1)));
        ticketManager.add(new Ticket("t2", "info", now.plusSeconds(2)));
        ticketManager.add(new Ticket("t3", "pension", now.plusSeconds(3)));

        Assert.assertEquals("t1", ticketManager.next().getId());
        Assert.assertEquals("t3", ticketManager.next().getId());
        Assert.assertEquals("t4", ticketManager.next().getId());
        Assert.assertEquals("t2", ticketManager.next().getId());
        Assert.assertNull(ticketManager.next());
    }
}
