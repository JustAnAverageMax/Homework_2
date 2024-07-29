package Model;

public class Admin extends User{
    @Override
    public void print(){

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
