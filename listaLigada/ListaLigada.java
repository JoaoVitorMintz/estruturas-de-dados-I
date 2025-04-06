public class ListaLigada {
    
    private Node header; // Inicio da lista ligada
    private Node trailer; // Fim da lista ligada
    private int size; // Quantidade de elementos na lista ligada

    // Construtor:
    public ListaLigada() {
        header = null;
        trailer = null;
        size = 0;
    }

    // Métodos:
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Node first() {
        return header;
    }

    public Node last() {
        return trailer;
    }

    public void addFirst(Node novoAnimal) {
        if(isEmpty()) {
            header = novoAnimal;
            trailer = novoAnimal;
        } else {
            novoAnimal.next = header;
            header = novoAnimal;
        }
        size++;
    }

}
