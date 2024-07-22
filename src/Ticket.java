import java.time.Instant;
import java.util.Arrays;

public class Ticket {
    private String id;
    private String concertHall;
    private String eventCode;
    private long time;
    private final long creationTime;
    private boolean isPromo;
    private char stadiumSector;
    private float maxBackpackWeight;
    private float price;

    public Ticket(){
       this.creationTime = Instant.now().getEpochSecond();
    }

    public Ticket(String concertHall, long time, String eventCode) {
        setConcertHall(concertHall);
        setTime(time);
        setEventCode(eventCode);

        this.creationTime = Instant.now().getEpochSecond();
    }

    public Ticket(String id, String concertHall, String eventCode, long time, boolean isPromo, char stadiumSector, float maxBackpackWeight, float price) {
        setId(id);
        setConcertHall(concertHall);
        setEventCode(eventCode);
        setTime(time);
        setPromo(isPromo);
        setStadiumSector(stadiumSector);
        setMaxBackpackWeight(maxBackpackWeight);
        setPrice(price);

        this.creationTime = Instant.now().getEpochSecond();
    }

    public void setId(String id) {
        if(id.matches("[a-zA-Z0-9]{4}"))
            this.id = id;
    }

    public void setConcertHall(String concertHall) {
        if(concertHall.length() <= 10)
            this.concertHall = concertHall;
    }

    public void setEventCode(String eventCode) {
        if(eventCode.length() == 3 && eventCode.chars().allMatch(Character::isDigit))
            this.eventCode = eventCode;
    }

    public void setTime(long time) {
        if(time >= 0)
            this.time = time;
    }

    public void setPromo(boolean promo) {
        isPromo = promo;
    }

    public void setStadiumSector(char stadiumSector) {
        if(Arrays.asList('A', 'B', 'C').contains(stadiumSector))
            this.stadiumSector = stadiumSector;
    }

    public void setPrice(float price){
        if(price > 0.0f){
            this.price = price;
        }
    }

    public void setMaxBackpackWeight(float maxBackpackWeight) {
        if(maxBackpackWeight >= 0.0f)
            this.maxBackpackWeight = maxBackpackWeight;
    }

    public long getCreationTime(){
        return creationTime;
    }

    public float getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", concertHall='" + concertHall + '\'' +
                ", eventCode='" + eventCode + '\'' +
                ", time=" + time +
                ", creationTime=" + creationTime +
                ", isPromo=" + isPromo +
                ", stadiumSector=" + stadiumSector +
                ", maxBackpackWeight=" + maxBackpackWeight +
                ", price=" + price +
                '}';
    }
}
