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


    @Test
    public void customTest() {
        OffsetDateTime now = OffsetDateTime.now();
        ticketManager.add(new Ticket("t0", "fin", now));
        ticketManager.add(new Ticket("t1", "pension", now.plusSeconds(1)));
        ticketManager.add(new Ticket("t2", "info", now.plusSeconds(2)));
        ticketManager.add(new Ticket("t3", "fin", now.plusSeconds(3)));
        ticketManager.add(new Ticket("t4", "info", now.plusSeconds(3)));
        ticketManager.add(new Ticket("t5", "pension", now.minusSeconds(3)));
        ticketManager.add(new Ticket("t6", "fin", now.plusSeconds(3)));
        ticketManager.add(new Ticket("t7", "info", now.minusSeconds(3)));
        ticketManager.add(new Ticket("t8", "pension", now.plusSeconds(3)));
        ticketManager.add(new Ticket("t9", "info", now.minusSeconds(3)));
        ticketManager.add(new Ticket("t10", "fin", now.minusSeconds(3)));
        ticketManager.add(new Ticket("t11", "pension", now.minusSeconds(3)));
        ticketManager.add(new Ticket("t12", "info", now.minusSeconds(3)));
        ticketManager.add(new Ticket("t13", "pension", now.minusSeconds(3)));
        ticketManager.add(new Ticket("t14", "fin", now.minusSeconds(3)));

        Assert.assertEquals("t5", ticketManager.next().getId());  // pension
        Assert.assertEquals("t11", ticketManager.next().getId());  // pension
        Assert.assertEquals("t13", ticketManager.next().getId());  // pension
        Assert.assertEquals("t1", ticketManager.next().getId());  // pension
        Assert.assertEquals("t8", ticketManager.next().getId());  // pension
        Assert.assertEquals("t10", ticketManager.next().getId());  // fin
        Assert.assertEquals("t14", ticketManager.next().getId());  // fin
        Assert.assertEquals("t0", ticketManager.next().getId());  // fin
        Assert.assertEquals("t3", ticketManager.next().getId());  // fin
        Assert.assertEquals("t6", ticketManager.next().getId());  // fin
        Assert.assertEquals("t7", ticketManager.next().getId());   // info
        Assert.assertEquals("t9", ticketManager.next().getId());   // info
        Assert.assertEquals("t12", ticketManager.next().getId());   // info
        Assert.assertEquals("t2", ticketManager.next().getId());   // info
        Assert.assertEquals("t4", ticketManager.next().getId());   // info
        Assert.assertNull(ticketManager.next()); // null
    }
}
