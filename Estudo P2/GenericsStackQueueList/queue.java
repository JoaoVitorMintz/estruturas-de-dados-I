public class queue<T> {
    
    private linkedList<T> list;

    public queue() {
        this.list = new linkedList<>();
    }

    public void enqueue(T value) {
        list.append(value);
    }

    public T dequeue() {
        node<T> n = list.removeFirst();
        return n.getValue();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }


    public int size() {
        return list.size();
    }

    public T peek() {
        node<T> n = list.getFirst();
        if (n == null) {
            return null;
        } else {
            return n.getValue();
        }
    }
    
}
