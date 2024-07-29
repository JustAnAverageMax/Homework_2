package Model;

public abstract class User extends IdentifiableEntity implements Printable{
    protected String name;
    protected String surname;
    protected String login;

    public abstract void printRole();
}
