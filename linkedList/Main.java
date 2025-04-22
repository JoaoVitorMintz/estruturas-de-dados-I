public class Main {
	public static void main(String[] args) {
		Node<String> n1 = new Node<>("N1");
		Node<String> n2 = new Node<>("N2");
		
		n1.setNext(n2);
		
		System.out.println(n1);
		System.out.println(n2);
	}
}
