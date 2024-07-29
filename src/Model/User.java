package Model;

public abstract class User extends IdentifiableEntity implements Printable {
    protected String name;
    protected String surname;
    protected String login;

    public User withName(String name) {
        if (this.isNameValid(name))
            this.name = name;
        return this;
    }

    public User withSurname(String surname) {
        if (this.isSurnameValid(surname))
            this.surname = surname;
        return this;
    }

    public User withLogin(String login) {
        if (this.isLoginValid(login))
            this.login = login;
        return this;
    }

    public boolean isNameValid(String name) {
        return name != null;
    }

    public boolean isSurnameValid(String surname) {
        return name != null;
    }

    public boolean isLoginValid(String login) {
        return login != null && login.length() >= 4;
    }

    public abstract void printRole();
}
