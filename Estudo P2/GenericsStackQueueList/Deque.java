public class Deque {
    private String[] deque;
    private int inicio;
    private int fim;
    private int tamanho;
    private int capacidade;

    public Deque(int capacidade) {
        this.capacidade = capacidade;
        deque = new String[capacidade];
        inicio = 0;
        fim = -1;
        tamanho = 0;
    }

    public boolean estaVazio() {
        return tamanho == 0;
    }

    public boolean estaCheio() {
        return tamanho == capacidade;
    }

    // Inserir no final
    public void insereFinal(String acao) {
        if (estaCheio()) {
            System.out.println("Deque cheio! Não é possível adicionar no final.");
            return;
        }
        fim = (fim + 1) % capacidade;
        deque[fim] = acao;
        tamanho++;
    }

    // Inserir no início
    public void insereInicio(String acao) {
        if (estaCheio()) {
            System.out.println("Deque cheio! Não é possível adicionar no início.");
            return;
        }
        inicio = (inicio - 1 + capacidade) % capacidade;
        deque[inicio] = acao;
        tamanho++;
    }

    // Remover do final
    public String removeFinal() {
        if (estaVazio()) {
            System.out.println("Deque vazio! Nada para remover do final.");
            return null;
        }
        String acao = deque[fim];
        fim = (fim - 1 + capacidade) % capacidade;
        tamanho--;
        return acao;
    }

    // Remover do início
    public String removeInicio() {
        if (estaVazio()) {
            System.out.println("Deque vazio! Nada para remover do início.");
            return null;
        }
        String acao = deque[inicio];
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        return acao;
    }

    public void exibir() {
        System.out.print("Deque: ");
        for (int i = 0; i < tamanho; i++) {
            int index = (inicio + i) % capacidade;
            System.out.print(deque[index] + " ");
        }
        System.out.println();
    }
}