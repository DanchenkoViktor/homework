package ru.edu;

public interface TicketManager {

    /**
     * Append ticket to queue.      *      * @param ticket - ticket.
     **/
    void add(Ticket ticket);

    /**
     * Get next ticket or null if queue is empty.      *
     **/
    Ticket next();
}