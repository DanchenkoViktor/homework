package ru.edu;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TicketManagerImpl implements TicketManager {
    private static final Map<String, Integer> PRIORITY = new HashMap<>();
    private final int MAX_SIZE = 1_000;
    private final Ticket[] ticketArray;
    private int currentSize;

    private final Comparator<Ticket> operationIdComparator = Comparator
            .comparing(Ticket::getOperationId, Comparator.comparing(PRIORITY::get))
            .thenComparing(Ticket::getRegisterTime, Comparator.reverseOrder());

    static {
        PRIORITY.put("pension", 3);
        PRIORITY.put("fin", 2);
        PRIORITY.put("info", 1);
    }

    public TicketManagerImpl() {
        ticketArray = new Ticket[MAX_SIZE];
        currentSize = -1;
    }

    /**
     * Append ticket to queue.
     * <p>
     * * @param ticket - ticket.
     **/
    @Override
    public void add(Ticket ticket) {
        ++currentSize;
        ticketArray[currentSize] = ticket;
        siftUp(currentSize);
    }

    /**
     * Get next ticket or null if queue is empty.
     **/
    @Override
    public Ticket next() {
        return remove(0);
    }

    private void siftUp(int i) {
        while (i > 0 && operationIdComparator.compare(ticketArray[i], ticketArray[parent(i)]) > 0) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    private void swap(int i, int j) {
        Ticket tmp = ticketArray[i];
        ticketArray[i] = ticketArray[j];
        ticketArray[j] = tmp;
    }

    private Ticket remove(int i) {
        if (currentSize < 0) {
            return null;
        }
        Ticket ticket = ticketArray[0];
        ticketArray[0] = ticketArray[currentSize];
        ticketArray[currentSize] = null;
        siftDown(0);
        currentSize--;

        return ticket;
    }

    private void siftDown(int i) {
        while (true) {
            int left = leftChild(i);
            int right = rightChild(i);
            int largest = i;
            if (left < currentSize && operationIdComparator.compare(ticketArray[left], ticketArray[largest]) > 0) {
                largest = left;
            }
            if (right < currentSize && operationIdComparator.compare(ticketArray[right], ticketArray[largest]) > 0) {
                largest = right;
            }
            if (largest == i) {
                break;
            }
            swap(i, largest);
            i = largest;
        }
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return (2 * i) + 1;
    }

    private int rightChild(int i) {
        return leftChild(i) + 1;
    }
}
