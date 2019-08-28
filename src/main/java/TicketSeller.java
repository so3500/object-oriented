import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TicketSeller {
    private TicketOffice ticketOffice;

    public void sellTo(Audience audience) {
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
    }
}
