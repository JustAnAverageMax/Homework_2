package Model;

import constants.ConcertHall;
import constants.Formatters;
import constants.StadiumSector;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class Ticket {
    private static int counter = 0;

    private int id;
    private ConcertHall concertHall;
    private String eventCode;
    private LocalDateTime time;
    private final LocalDateTime creationTime;
    private boolean isPromo;
    private StadiumSector stadiumSector;
    private BigDecimal maxBackpackWeight;
    private BigDecimal price;


    private void initID(){
        this.id = counter;
        counter++;
    }

    public Ticket() {
        initID();
        this.creationTime = LocalDateTime.now();
    }

    public Ticket withConcertHall(ConcertHall concertHall) {
        this.concertHall = concertHall;
        return this;
    }

    public Ticket withEventCode(String eventCode) {
        if (eventCode.length() == 3 && eventCode.chars().allMatch(Character::isDigit)) this.eventCode = eventCode;
        return this;
    }

    public Ticket withTime(LocalDateTime time) {
        if (time.isAfter(LocalDateTime.now())) this.time = time;
        return this;
    }

    public Ticket withPromo(boolean promo) {
        this.isPromo = promo;
        return this;
    }

    public Ticket withStadiumSector(StadiumSector stadiumSector) {
        this.stadiumSector = stadiumSector;
        return this;
    }

    public Ticket withPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) > 0) this.price = price;
        this.price = this.price.setScale(2, RoundingMode.HALF_UP);
        return this;
    }

    public Ticket withMaxBackpackWeight(BigDecimal maxBackpackWeight) {
        if (maxBackpackWeight.compareTo(BigDecimal.ZERO) >= 0) this.maxBackpackWeight = maxBackpackWeight;
        this.maxBackpackWeight = this.maxBackpackWeight.setScale(3, RoundingMode.HALF_UP);
        return this;
    }

    public int getId() {
        return id;
    }

    public ConcertHall getConcertHall() {
        return concertHall;
    }

    public String getEventCode() {
        return eventCode;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public boolean isPromo() {
        return isPromo;
    }

    public StadiumSector getStadiumSector() {
        return stadiumSector;
    }

    public BigDecimal getMaxBackpackWeight() {
        return maxBackpackWeight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", concertHall='" + concertHall + '\'' +
                ", eventCode='" + eventCode + '\'' +
                ", time=" + time.format(Formatters.dateTimeFormatter) +
                ", creationTime=" + creationTime.format(Formatters.dateTimeFormatter) +
                ", isPromo=" + isPromo +
                ", stadiumSector=" + stadiumSector +
                ", maxBackpackWeight=" + maxBackpackWeight +
                ", price=" + price +
                '}';
    }
}
