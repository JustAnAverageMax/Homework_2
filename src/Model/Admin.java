package Model;

import constants.AccessLevel;

public class Admin extends User{
    private AccessLevel accessLevel;

    public Admin(){
        this.generateID();
    }

    public Admin withAccessLevel(AccessLevel accessLevel){
        this.accessLevel = accessLevel;
        return this;
    }

    public void checkTicket(Ticket ticket){
        System.out.println("Admin #" + this.ID + " report after ticket check:\n" + ticket.checkTicket());
    }

    @Override
    public void print(){
        System.out.println("Admin #" + this.ID +
                ":\n*Name - " + this.name +
                "\n*Surname - " + this.surname +
                "\n*Login - " + this.login +
                "\n*Access Level - " + this.accessLevel);
    }

    @Override
    public void printRole() {
        System.out.println("User #" + this.ID + " is an Admin");
    }

    @Override
    protected void generateID() {
        this.ID = IdentifiableEntity.counter++;
    }
}
