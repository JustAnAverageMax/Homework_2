import java.time.Instant;

public class TicketService {
    public static void main(String[] args) {
        long currentTime = Instant.now().getEpochSecond();
        Ticket emptyTicket = new Ticket();
        Ticket limitedTicket = new Ticket("Concert Hall №3", currentTime, 123);
        Ticket fullTicket = new Ticket("3jfjgh32", "Concert Hall №3", 345,
                currentTime, true, 'B', 2.5f);

        System.out.println("Empty Ticket: " + emptyTicket + "\nLimited Ticket" + limitedTicket +
                "\nFull Ticket: " + fullTicket);
        System.out.println("Empty creation time: " + emptyTicket.getCreationTime());
        fullTicket.setPrice(-4.0f);
        System.out.println(fullTicket.getPrice());
        fullTicket.setPrice(15.0f);
        System.out.println(fullTicket.getPrice());
    }
}