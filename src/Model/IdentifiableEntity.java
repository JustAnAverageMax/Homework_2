package Model;

public abstract class IdentifiableEntity {
    protected static int counter = 0;
    protected int ID;

    private boolean isIDValid(int ID){ return ID >= 0; }
    protected abstract void generateID();

    public int getID(){ return ID; }

    public void setID(int ID){
        if(isIDValid(ID)) this.ID = ID;
    }
}
