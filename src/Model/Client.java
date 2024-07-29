package Model;

public class Client extends User{

    private Ticket ticket;

    public Client(){
        this.generateID();
    }

    public Client withTicket(Ticket ticket){
        this.ticket = ticket;
        return this;
    }

    public Ticket getTicket() {
        return this.ticket;
    }

    @Override
    public void print(){
        System.out.println("Client #" + this.ID +
                ":\n*Name - " + this.name +
                "\n*Surname - " + this.surname +
                "\n*Login - " + this.login);
        if(this.ticket != null){
            System.out.println("Has ticket:");
            this.ticket.print();
        }
    }

    @Override
    public void printRole() {
        System.out.println("User #" + this.ID + " is a Client");
    }

    @Override
    protected void generateID() {
        this.ID = IdentifiableEntity.counter++;
    }
}
