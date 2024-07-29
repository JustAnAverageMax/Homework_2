package Service;

import Model.Ticket;
import constants.ConcertHall;
import constants.StadiumSector;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicketService {
    private static List<Ticket> storage;

    public static void main(String[] args) {
        String definitelyNotMyNumber = "+375-44-703-73-19";
        String definitelyNotMyEmail = "maximkrutalevich@gmail.com";
        StadiumSector[] sectors = StadiumSector.values();
        ConcertHall[] halls = ConcertHall.values();

        Random random = new Random();
        storage = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            BigDecimal randomPrice = BigDecimal
                    .valueOf(10 + (100 - 10) * random.nextDouble());
            BigDecimal randomMaxBackpackWeight = BigDecimal
                    .valueOf(5 + (20 - 5) * random.nextDouble());
            StadiumSector randomStadiumSector = sectors[random.nextInt(sectors.length)];
            ConcertHall randomConcertHall = halls[random.nextInt(halls.length)];
            boolean isPromo = random.nextBoolean();
            String randomEventCode = String.valueOf(random.nextInt(900) + 100);
            Ticket currentTicket = new Ticket()
                    .withPrice(randomPrice)
                    .withStadiumSector(randomStadiumSector)
                    .withPromo(isPromo)
                    .withMaxBackpackWeight(randomMaxBackpackWeight)
                    .withEventCode(randomEventCode)
                    .withConcertHall(randomConcertHall)
                    .withTime(LocalDateTime.now()
                            .plusMonths(random.nextInt(5))
                            .plusDays(random.nextInt(30))
                            .plusHours(random.nextInt(24))
                            .withMinute(random.nextInt(12) * 5)
                    );
            currentTicket.print();
            storage.add(currentTicket);
        }
        int randomId = random.nextInt(storage.size());
        Ticket randomTicket = getTicketById(randomId);
        System.out.println("Ticket with id #" + randomId + ":");
        randomTicket.print();
        randomTicket.share(definitelyNotMyNumber);
        randomTicket.share(definitelyNotMyNumber, definitelyNotMyEmail);
    }

    public static Ticket getTicketById(int ID) {
        Ticket result = new Ticket();
        for (Ticket t : storage)
            if (t.getID() == ID) result = t;

        return result;
    }
}