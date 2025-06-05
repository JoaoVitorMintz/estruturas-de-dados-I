public class Deque <T> {
    
    private T[] deque;
    private int start;
    private int end;
    private int numElements;

    public Deque(int size) {
        this.deque = (T[]) new Object[size];
        this.start = 0;
        this.end = 0;
        this.numElements = 0;
    }

    public Deque() {
        this(5);
    }

    public boolean insertFirst(T value) {
        if(isFull()) {
            removeLast();
        }
        start = (start - 1 + deque.length) % deque.length;
        deque[start] = value;
        numElements++;
        return true;
    }

    public boolean insertLast(T value) {
        if(!isFull()) {
            deque[end] = value;
            end = (end - 1) % deque.length;
            numElements++;
            return true;
        }
        return false;
    }

    public T removeFirst() {
        T value;
        if (!isEmpty()) {
            value = deque[start];
            start = (start + 1) % deque.length;
            numElements--;
            return value;
        }
        return null;
    }

    public T removeLast() {
        T value;
        if (!isEmpty()) {
            end = (end - 1 + deque.length) % deque.length;
            value = deque[end];
            numElements--;
            return value;
        }
        return null;
    }

    public T peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return deque[start];
    }

    public T peekLast() {
        if (isEmpty()) {
            return null;
        }
        return deque[(end - 1 + deque.length) % deque.length];
    }

    public void clean() {
        start = 0;
        end = 0;
        numElements = 0;
    }

    public T start() {
        if(!isEmpty()) {
            return deque[start];
        }
        return null;
    }

    private boolean isFull() {
        return numElements == deque.length;
    }
    

    private boolean isEmpty() {
        return numElements == 0;
    }

    public String element() {
        String elementos = "";
         int indice = this.start;
         
        if(this.isEmpty())
            return "\nFila está fazia!\n";
        for(int i = 0; i < this.numElements; i++) {
            elementos = elementos + " " + this.deque[indice];
            indice = (indice + 1) % deque.length;
        }
        return elementos;
    }

}
