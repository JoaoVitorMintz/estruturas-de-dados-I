// arquivo: src/apl2/DLinkedList.java

// Nome: Enzo Ferrari de Moura Sampaio         RA: 10440331
// Nome: Giovanni Barreto Garitano de Castro   RA: 10435745
// Nome: João Vitor Garcia Aguiar Mintz        RA: 10440421
// Nome: Yan Andreotti dos Santos              RA: 10439766

package apl2;

// -- A classe DLinkedList (que pertence ao pacote apl2) deve implementar uma
// lista duplamente encadeada. Os nós dessa lista são do tipo [da classe] Node.
// -- A classe deve possuir dois nós especiais, head e tail, que são
// referências para o primeiro e último nó da lista, respectivamente.
// -- A classe deve possuir um contador de quantos nós existem na lista.
// -- A classe deve sobrescrever (override) o método public String toString()
// {...}, retornando uma string com o conteúdo da lista.
// -- A classe deve implementar as operações a seguir, respeitando o
// comportamento descrito em cada operação.

public class DLinkedList {
	
	// TODO: Implementar a classe conforme o enunciado da atividade Apl2.
	private Node head;
	private Node tail;
	private int count;

// OPERAÇÃO:		Método construtor
// COMPORTAMENTO:	Cria uma lista vazia.
	public DLinkedList() {
		head = null;
		tail = null;
		count = 0;
	}


// OPERAÇÃO:		insert(<dados da pessoa>)
// COMPORTAMENTO:	Aloca um Node que contém os <dados da pessoa> e insere o
//					novo nó no início da lista.
	public void insert(String ID, String nome, float nota) {
		Node node = new Node(ID, nome, nota, head, null);
		head = node;
		++count;

		if (tail == null) {
			tail = head;
		}
	}


// OPERAÇÃO:		append(<dados da pessoa>)
// COMPORTAMENTO:	Aloca um Node que contém os <dados da pessoa> e insere o
//					novo nó no final da lista.
	public void append(String ID, String nome, float nota) {
		if (isEmpty()) {
			insert(ID, nome, nota);
			return;
		}

		Node node = new Node(ID, nome, nota, tail, null);
		tail.setNext(node);
		tail = node;
		++count;
	}


// OPERAÇÃO: 		removeHead()
// COMPORTAMENTO:	Remove o nó do início da lista e retorna a referência do
//					nó removido.
//					Ou retorna null caso a lista esteja vazia.
	public Node removeHead() {
		if (isEmpty()) {
			return null;
		}

		Node removed = head;
		head = head.getNext();
		removed.setNext(null);
		--count;

		if (isEmpty()) {
			tail = null;
		}

		return removed;
	}


// OPERAÇÃO:		removeTail()
// COMPORTAMENTO:	Remove o nó do final da lista e retorna a referência do
//					nó removido.
//					Ou retorna null caso a lista esteja vazia.
	public Node removeTail() {
		if (isEmpty()) {
			return null;
		}

		Node removed = tail;
		
		if (head == tail) {
			head = null;
			tail = null;
		} else {
			tail = tail.getPrev();
			tail.setNext(null);
			removed.setPrev(null);
		}
		--count;
		return removed;
	}


// OPERAÇÃO:		removeNode(<ID da pessoa>)
// COMPORTAMENTO:	Remove o nó que contém o <ID da pessoa> da lista e retorna
//					a referência do nó removido.
//					Ou retorna null caso não exista um nó com <ID da pessoa>.
	public Node removeNode(String id) { // Código completamente baseado no código do prof Jefferson da aula do dia 08-05-25
		Node node = head;
		while (node != null) {
			if (node.getID().equals(id)) {
				if (node.getPrev() != null) {
					node.getPrev().setNext(node.getNext());
				} else {
					head = node.getNext();
					node.setPrev(null);
				}
				if (node.getNext() != null) {
					node.getNext().setPrev(node.getPrev());
				} else {
					tail = node.getPrev();
					tail.setNext(null);
				}
				--count;
				return node;
			}
			node = node.getNext();
		}
		return null;
	}


// OPERAÇÃO:		getHead()
// COMPORTAMENTO:	Retorna uma referência para o nó do início da lista.
//					Ou retorna null caso a lista esteja vazia.
	public Node getHead() {
		return head;
	}


// OPERAÇÃO:		getTail()
// COMPORTAMENTO:	Retorna uma referência para o nó do final da lista.
//					Ou retorna null caso a lista esteja vazia.
	public Node getTail() {
		return tail;
	}


// OPERAÇÃO:		getNode(<ID da pessoa>)
// COMPORTAMENTO:	Retorna uma referência para o nó que contém o <ID da pessoa>
//					da lista.
//					Ou retorna null caso não exista um nó com <ID da pessoa>.
	public Node getNode(String id) {
		Node node = head;
		while (node != null) {
			if (node.getID() == id) {
				return node;
			}
			node = node.getNext();
		}
		return null;
	}


// OPERAÇÃO:		count()
// COMPORTAMENTO:	Retorna a quantidade de nós da lista.
	public int count() {
		return count;
	}


// OPERAÇÃO:		isEmpty()
// COMPORTAMENTO:	Retorna true se a lista estiver vazia ou false, caso contrário.
	public boolean isEmpty() {
		return head == null;
	}


// OPERAÇÃO:		clear()
// COMPORTAMENTO:	Esvazia a lista, liberando a memória de todos os nós da lista.
	public void clear() {
		while (!isEmpty()) {
			removeHead();
		}
	}


// OPERAÇÃO:		toString()
// COMPORTAMENTO:	Retorna uma string com o conteúdo da lista (caso queira, use o
//					exemplo do método toString() da classe LinkedListOriginal).
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("(" + count + ")  \n");

		Node node = head;
		while (node != null) {
			sb.append("25.S" + count % 2 + "-") // Adicionar um random? (perguntar pro prof se pode...) e perguntar se coloca time para ver o ano...
			.append(node.getID())
			.append(";")
			.append(node.getNome())
			.append(";")
			.append(node.getNota());
			node = node.getNext();
		}
		sb.append("null.");

		return sb.toString();
	}

}