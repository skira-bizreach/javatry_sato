package org.docksidestage.bizfw.basic.buyticket;

public class TicketBuyResult {
    private final int displayPrice;
    private int handedMoney;

    public TicketBuyResult(int displayPrice, int money) {
        this.displayPrice = displayPrice;
        this.handedMoney = money;
    }

    public Ticket getTicket() {
        Ticket passport = new Ticket(displayPrice);
        return passport;
    }

    public int getChange() {
        return handedMoney - displayPrice;
    }

}