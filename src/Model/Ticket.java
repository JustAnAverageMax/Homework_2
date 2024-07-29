package Model;

import constants.ConcertHall;
import constants.Formatters;
import constants.StadiumSector;
import utils.NullableWarning;
import utils.NullableWarningProcessor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Objects;

public class Ticket extends IdentifiableEntity implements Printable, Sharable {
    private ConcertHall concertHall;
    @NullableWarning
    private String eventCode;
    @NullableWarning
    private LocalDateTime time;
    private final LocalDateTime creationTime;
    private boolean isPromo = false;
    @NullableWarning
    private StadiumSector stadiumSector;
    private BigDecimal maxBackpackWeight;
    private BigDecimal price;

    public Ticket() {
        generateID();
        NullableWarningProcessor.processAnnotation(this);
        this.creationTime = LocalDateTime.now();
    }

    public Ticket withConcertHall(ConcertHall concertHall) {
        this.concertHall = concertHall;
        return this;
    }

    public Ticket withEventCode(String eventCode) {
        if (isEventCodeValid(eventCode)) this.eventCode = eventCode;
        return this;
    }

    public Ticket withTime(LocalDateTime time) {
        if (isTimeValid(time)) this.time = time;
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
        if (isPriceValid(price)) this.price = price;
        this.price = this.price.setScale(2, RoundingMode.HALF_UP);
        return this;
    }

    public Ticket withMaxBackpackWeight(BigDecimal maxBackpackWeight) {
        if (isMaxBackpackWeightValid(maxBackpackWeight)) this.maxBackpackWeight = maxBackpackWeight;
        this.maxBackpackWeight = this.maxBackpackWeight.setScale(3, RoundingMode.HALF_UP);
        return this;
    }

    public boolean isEventCodeValid(String eventCode){
        return eventCode != null && eventCode.length() == 3 && eventCode.chars().allMatch(Character::isDigit);
    }

    public boolean isTimeValid(LocalDateTime time){
        return time != null && time.isAfter(LocalDateTime.now());
    }

    public boolean isPriceValid(BigDecimal price){
        return price != null && price.compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean isMaxBackpackWeightValid(BigDecimal maxBackpackWeight){
        return maxBackpackWeight != null && maxBackpackWeight.compareTo(BigDecimal.ZERO) >= 0;
    }

    public String checkTicket(){
        return "Ticket #" + this.ID +
                "\n*Concert hall is" + (this.concertHall != null ? " " : " not ") + "valid" +
                "\n*Event code is" + (this.isEventCodeValid(this.eventCode) ? " " : " not ") + "valid" +
                "\n*Time is" + (this.isTimeValid(this.time) ? " " : " not ") + "valid" +
                "\n*Stadium sector is" + (this.stadiumSector != null ? " " : " not ") + "valid" +
                "\n*Max backpack weight is" + (this.isMaxBackpackWeightValid(this.maxBackpackWeight) ? " " : " not ") + "valid" +
                "\n*Price is" + (this.isPriceValid(this.price) ? " " : " not ") + "valid"
                ;
    }

    public void setStadiumSector(StadiumSector stadiumSector) {
        this.stadiumSector = stadiumSector;
    }

    public void setTime(LocalDateTime time) {
        if(isTimeValid(time)) this.time = time;
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
    protected void generateID() {
        this.ID = IdentifiableEntity.counter++;
    }

    @Override
    public void print() {
        String message = "\nTicket #" +
                this.ID +
                ":\n*Concert Hall - " +
                this.concertHall +
                "\n*Event code - " +
                this.eventCode +
                "\n*Time - " +
                time.format(Formatters.dateTimeFormatter) +
                "\n*Ticket was created in " +
                creationTime.format(Formatters.dateTimeFormatter) +
                "\n*This ticket is " +
                (isPromo ? "" : "not ") + "promo" +
                "\n*Stadium sector - " +
                stadiumSector +
                "\n*Max backpack weight is " +
                maxBackpackWeight + " kg" +
                "\n*Price - " +
                price + "$\n"
                ;
        System.out.println(message);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return isPromo == ticket.isPromo &&
                concertHall == ticket.concertHall &&
                Objects.equals(eventCode, ticket.eventCode) &&
                Objects.equals(time, ticket.time) &&
                Objects.equals(creationTime, ticket.creationTime) &&
                stadiumSector == ticket.stadiumSector &&
                Objects.equals(maxBackpackWeight, ticket.maxBackpackWeight) &&
                Objects.equals(price, ticket.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(concertHall, eventCode, time, creationTime, isPromo, stadiumSector, maxBackpackWeight, price);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ID=" + ID +
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

    @Override
    public void share(String phoneNumber, String email) {
        System.out.println("Ticket #" + this.ID + " was shared by:\n*Phone number - " + phoneNumber + "\n*Email - " + email);
    }

    @Override
    public void share(String phoneNumber) {
        System.out.println("Ticket #" + this.ID + " was shared by:\n*Phone number - " + phoneNumber);
    }
}
