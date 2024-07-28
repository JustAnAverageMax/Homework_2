import java.time.Instant;
import java.util.Arrays;

public class Ticket {
    private int id;
    private String concertHall;
    private String eventCode;
    private long time;
    private final long creationTime;
    private boolean isPromo;
    private char stadiumSector;
    private float maxBackpackWeight;
    private float price;

    private static int counter = 0;

    private void initID(){
        this.id = counter;
        counter++;
    }

    public Ticket() {
        initID();
        this.creationTime = Instant.now().getEpochSecond();
    }

    public Ticket(String concertHall, long time, String eventCode) {
        initID();
        setConcertHall(concertHall);
        setTime(time);
        setEventCode(eventCode);

        this.creationTime = Instant.now().getEpochSecond();
    }

    public Ticket(String concertHall, String eventCode, long time, boolean isPromo, char stadiumSector, float maxBackpackWeight, float price) {
        initID();
        setConcertHall(concertHall);
        setEventCode(eventCode);
        setTime(time);
        setPromo(isPromo);
        setStadiumSector(stadiumSector);
        setMaxBackpackWeight(maxBackpackWeight);
        setPrice(price);

        this.creationTime = Instant.now().getEpochSecond();
    }

    public void setConcertHall(String concertHall) {
        if (concertHall.length() <= 10) this.concertHall = concertHall;
    }

    public void setEventCode(String eventCode) {
        if (eventCode.length() == 3 && eventCode.chars().allMatch(Character::isDigit)) this.eventCode = eventCode;
    }

    public void setTime(long time) {
        if (time >= 0) this.time = time;
    }

    public void setPromo(boolean promo) {
        this.isPromo = promo;
    }

    public void setStadiumSector(char stadiumSector) {
        if (Arrays.asList('A', 'B', 'C').contains(stadiumSector)) this.stadiumSector = stadiumSector;
    }

    public void setPrice(float price) {
        if (price > 0.0f) {
            this.price = price;
        }
    }

    public void setMaxBackpackWeight(float maxBackpackWeight) {
        if (maxBackpackWeight >= 0.0f) this.maxBackpackWeight = maxBackpackWeight;
    }

    public long getCreationTime() {
        return this.creationTime;
    }

    public float getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id='" + this.id + '\'' + ", concertHall='" + this.concertHall + '\'' + ", eventCode='" + this.eventCode + '\'' + ", time=" + this.time + ", creationTime=" + this.creationTime + ", isPromo=" + this.isPromo + ", stadiumSector=" + this.stadiumSector + ", maxBackpackWeight=" + this.maxBackpackWeight + ", price=" + this.price + '}';
    }
}
