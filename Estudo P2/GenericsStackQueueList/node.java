// Creating node class with generic:

public class node<T> {
    
    private node<T> next;
    private node<T> prev;
    private T value;

    public node() {
        this(null, null, null);
    }

    public node(node<T> next, node<T> prev, T value) {
        this.next = next;
        this.prev = prev;
        this.value = value;
    }

    // Getters:
    public T getValue() {
        return value;
    }

    public node<T> getNext() {
        return next;
    }

    public node<T> getPrev() {
        return prev;
    }

    // Setters:
    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(node<T> next) {
        this.next = next;
    }

    public void setPrev(node<T> prev) {
        this.prev = prev;
    }

    

}
