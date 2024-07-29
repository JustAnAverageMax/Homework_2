package Model;

public class Client extends User{

    private Ticket ticket;

    public Client(){
        generateID();
    }

    public Client withName(String name){
        this.name = name;
        return this;
    }

    public Client withSurname(String surname){
        this.surname = surname;
        return this;
    }

    public Client withLogin(String login){
        this.login = login;
        return this;
    }

    public Client withTicket(Ticket ticket){
        this.ticket = ticket;
        return this;
    }

    public Ticket getTicket() {
        return ticket;
    }

    @Override
    public void print(){
        System.out.println("Client #" + this.ID);
        ticket.print();
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
