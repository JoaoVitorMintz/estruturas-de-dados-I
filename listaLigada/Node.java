public class Node {
    String nomeAnimal; // Elemento armazenado no nó
    Node next; // Próximo elemento da lista... que também é do tipo Node

    public Node(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
        next = null;
    }

    public void mostraAnimal() {
        System.out.println("Animal: " + nomeAnimal);
    }
}
