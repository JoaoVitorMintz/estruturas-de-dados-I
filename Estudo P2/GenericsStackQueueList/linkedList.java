import java.util.NoSuchElementException;

public class linkedList<T> {
    
    private node<T> head;
    private node<T> tail;


    // Constructor:
    public linkedList() {
        this.head = null;
        this.tail = null;
    }
    

    // Methods:

    public void insert(T value) {
        node<T> n = new node<>(head, null, value);
        if (head != null) {
            head.setPrev(n);
        }
        head = n;

        if (tail == null) {
            tail = head;
        }
    }

    public void append(T value) {
        if (isEmpty()) {
            insert(value);
            return;
        }

        node<T> n = new node<>(null, tail, value);
        tail.setNext(n);
        tail = n;
    }

    public node<T> remove(T value) {
        if (isEmpty()) {
            return null;
        }

        node<T> current = head;

        while (current != null) {
            if (current.getValue().equals(value)) {
                if (current.getPrev() != null) {
                    current.getPrev().setNext(current.getNext());
                } else {
                    head = current.getNext();
                    if (head != null) {
                        head.setPrev(null);
                    }
                }
                if (current.getNext() != null) {
                    current.getNext().setPrev(current.getPrev());
                } else {
                    tail = current.getPrev();
                    if (tail != null) {
                        tail.setNext(null);
                    }
                }
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public node<T> getFirst() {
        return head;
    }

    public node<T> getLast() {
        return tail;
    }

    public node<T> removeFirst() {
        if (isEmpty()) {
            return null;
        }

        node<T> removedFirst = head;
        head = head.getNext();

        if (head != null) {
            head.setPrev(null);
        } else {
            tail = null;
        }

        return removedFirst;
    }

    public int size() {
        int count = 0;
        node<T> current = head;
        
        while (current != null) {
            count++;
            current = current.getNext();
        }

        return count;
    }

    public T central() {
    if (head == null) {
        throw new NoSuchElementException("Lista vazia");
    }
    
    node<T> slow = head;  // Ponteiro lento (avança 1 por vez)
    node<T> fast = head;  // Ponteiro rápido (avança 2 por vez)
    
    while (fast != null && fast.getNext() != null) {
        slow = slow.getNext();              // Avança 1 passo
        fast = fast.getNext().getNext();    // Avança 2 passos
    }
    
    return slow.getValue();  // Retorna o dado do nó do meio
    }

    public int countOccurrences(T value) {
    int count = 0;
    node<T> current = head;
    
    while (current != null) {
        if (current.getValue().equals(value)) {
            count++;
        }
        current = current.getNext();
    }
    
    return count;
    }

}

 