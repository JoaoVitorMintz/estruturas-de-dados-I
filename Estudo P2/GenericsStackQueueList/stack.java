public class stack<T> {

    private linkedList<T> list;

    // Constrcutor:
    public stack() {
        this.list = new linkedList<>();
    }

    // Methods:

    public void push(T value) {
        list.insert(value);
    }

    public T pop() {
        node<T> n = list.removeFirst();
        if (n == null) {
            return null;
        } else {
            return n.getValue();
        }
        // IF == return node != null ? node.getValue() : null;
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
