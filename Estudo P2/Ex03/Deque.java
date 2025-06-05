public class Deque {
    private String[] elementos;
    private int frente;
    private int tras;
    private int tamanho;
    private final int capacidade;

    public Deque(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new String[capacidade];
        this.frente = 0;
        this.tras = 0;
        this.tamanho = 0;
    }

    // Insere no início
    public void inserirFrente(String elemento) {
        if (cheio()) {
            removerTras(); // Remove o mais antigo se estiver cheio
        }
        frente = (frente - 1 + capacidade) % capacidade;
        elementos[frente] = elemento;
        tamanho++;
    }

    // Insere no final
    public void inserirTras(String elemento) {
        if (cheio()) {
            removerFrente(); // Remove o mais antigo se estiver cheio
        }
        elementos[tras] = elemento;
        tras = (tras + 1) % capacidade;
        tamanho++;
    }

    // Remove do início
    public String removerFrente() {
        if (vazio()) return null;
        String elemento = elementos[frente];
        frente = (frente + 1) % capacidade;
        tamanho--;
        return elemento;
    }

    // Remove do final
    public String removerTras() {
        if (vazio()) return null;
        tras = (tras - 1 + capacidade) % capacidade;
        String elemento = elementos[tras];
        tamanho--;
        return elemento;
    }

    // Verifica o primeiro elemento
    public String frente() {
        if (vazio()) return null;
        return elementos[frente];
    }

    // Verifica o último elemento
    public String tras() {
        if (vazio()) return null;
        return elementos[(tras - 1 + capacidade) % capacidade];
    }

    public boolean vazio() {
        return tamanho == 0;
    }

    public boolean cheio() {
        return tamanho == capacidade;
    }

    public int tamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        int index = frente;
        for (int i = 0; i < tamanho; i++) {
            sb.append(elementos[index]);
            if (i < tamanho - 1) sb.append(", ");
            index = (index + 1) % capacidade;
        }
        sb.append("]");
        return sb.toString();
    }
}