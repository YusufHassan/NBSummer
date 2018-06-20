package NB5;

public interface StackInt<E> {
    boolean empty();
    E pop();
    E peek();
    E push(E item);
    int search(Object o);
}
