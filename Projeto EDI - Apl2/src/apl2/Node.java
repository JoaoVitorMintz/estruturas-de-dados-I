// arquivo: src/apl2/Node.java

// Nome: Enzo Ferrari de Moura Sampaio         RA: 10440331
// Nome: Giovanni Barreto Garitano de Castro   RA: 10435745
// Nome: João Vitor Garcia Aguiar Mintz        RA: 10440421
// Nome: Yan Andreotti dos Santos              RA: 10439766

package apl2;

// -- A classe Node (que pertence ao pacote apl2) deve conter os atributos que
// representam a nova versão dos dados de uma pessoa, conforme descrito no
// enunciado da atividade Apl2.
// -- A classe deve conter os construtores apropriados, assim como os métodos
// getters e setters.
// -- A classe também representa um nó que é usado na implementação da lista
// duplamente encadeada (classe DLinkedList).
// -- A classe deve sobrescrever (override) o método public String toString()
// {...}, retornando uma string com os valores dos atributos da classe.

public class Node {

    //Implementar a classe conforme o enunciado da atividade Apl2.
    private String ID;
    private String nome;
    private float nota;
    private Node next;
    private Node prev;

    public Node() {
        this( "-1", "", 0, null, null);
    }

    public Node(String ID, String nome, float nota, Node next, Node prev) {
        this.ID = ID;
        this.nome = nome;
        this.nota = nota;
        this.next = next;
        this.prev = prev;
    }

    // GETTERS SEPARADOS:
    public String getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public float getNota() {
        return nota;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    // SETTERS SEPARADOS:
    public void setID(String ID) {
        this.ID = ID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "(" + ID + "; " + nome + "; " + String.format("%.1f", nota).replace(",", ".") + ")";
    }
}
