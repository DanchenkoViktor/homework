package ru.edu;

import java.time.OffsetDateTime;

public class Ticket {

    private String id;
    private String operationId;
    private OffsetDateTime registerTime;

    public Ticket(String id, String operationId, OffsetDateTime registerTime) {
        this.id = id;
        this.operationId = operationId;
        this.registerTime = registerTime;
    }

    public String getId() {
        return id;
    }

    public OffsetDateTime getRegisterTime() {
        return registerTime;
    }

    public String getOperationId() {
        return operationId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                " operationId='" + operationId +
                " registerTime=" + registerTime +
                '}';
    }
}
