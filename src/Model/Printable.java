package Model;

public interface Printable {
    default void print(){
        System.out.println(this);
    }
}
