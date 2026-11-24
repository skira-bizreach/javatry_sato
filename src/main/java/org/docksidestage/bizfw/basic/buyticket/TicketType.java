package org.docksidestage.bizfw.basic.buyticket;

import java.time.LocalTime;

public enum TicketType {
    ALL_DAY(LocalTime.of(9, 0)), NIGHT_ONLY(LocalTime.of(17, 0));

    private final LocalTime entryAvailableTime;

    private TicketType(LocalTime entryAvailableTime) {
        this.entryAvailableTime = entryAvailableTime;
    }
}

