public class Node<T> {
	
	private T data;
	private Node<T> next;
	
	// Costrutores:
	public Node(T data) {
		this.data = data;
		this.next = null;
	}
	
	public Node() {
		this(null);
	}
	
	// Métodos:
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public Node<T> getNext() {
		return next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "data: " + data + " next: " + (next!=null?next.getData():"null"); 
	}
}
