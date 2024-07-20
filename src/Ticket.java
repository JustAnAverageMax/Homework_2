import java.time.Instant;

public class Ticket {
    private String id;
    private String concertHall;
    private int eventCode;
    private long time;
    private final long creationTime;
    private boolean isPromo;
    private char stadiumSector;
    private float maxBackpackWeight;
    private float price;

    public Ticket(){
        this.creationTime = Instant.now().getEpochSecond();
    }

    public Ticket(String id, String concertHall, int eventCode, long time, boolean isPromo, char stadiumSector, float maxBackpackWeight) {
        this.id = id;
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = time;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.maxBackpackWeight = maxBackpackWeight;
        this.creationTime = Instant.now().getEpochSecond();
    }

    public Ticket(String concertHall, long time, int eventCode) {
        this.concertHall = concertHall;
        this.time = time;
        this.eventCode = eventCode;
        this.creationTime = Instant.now().getEpochSecond();
    }

    public void setPrice(float price){
        if(price > 0.0f){
            this.price = price;
        }
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
                ", eventCode=" + eventCode +
                ", time=" + time +
                ", creationTime=" + creationTime +
                ", isPromo=" + isPromo +
                ", stadiumSector=" + stadiumSector +
                ", maxBackpackWeight=" + maxBackpackWeight +
                ", price=" + price +
                '}';
    }
}
