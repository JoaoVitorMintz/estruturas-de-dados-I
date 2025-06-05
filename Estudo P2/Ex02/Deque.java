public class Deque {
    private int inicio;
    private int fim;
    private int qtdElementos;
    private String[] deque;
    private int ponteiroRefazer; // Novo ponteiro para controlar o refazer

    public Deque(int tam) {
        deque = new String[tam];
        inicio = 0;
        fim = 0;
        qtdElementos = 0;
        ponteiroRefazer = -1; // Inicialmente não há ações para refazer
    }

    public Deque() {
        this(10);
    }

    // Insere uma nova ação no histórico (no final)
    public boolean inserir(String acao) {
        if (cheio()) {
            // Remove a ação mais antiga para fazer espaço
            inicio = (inicio + 1) % deque.length;
            qtdElementos--;
        }
        
        deque[fim] = acao;
        fim = (fim + 1) % deque.length;
        qtdElementos++;
        ponteiroRefazer = -1; // Resetar o ponteiro de refazer após nova ação
        return true;
    }

    // Desfaz a última ação (remove do final)
    public String desfazer() {
        if (vazio()) {
            System.out.println("Nada para desfazer!");
            return null;
        }
        
        fim = (fim - 1 + deque.length) % deque.length;
        String acaoDesfeita = deque[fim];
        qtdElementos--;
        ponteiroRefazer = fim; // Marca onde estávamos para possível refazer
        return acaoDesfeita;
    }

    // Refaz a última ação desfeita
    public String refazer() {
        if (ponteiroRefazer == -1 || ponteiroRefazer == fim) {
            System.out.println("Nada para refazer!");
            return null;
        }
        
        String acaoRefeita = deque[ponteiroRefazer];
        fim = (fim + 1) % deque.length;
        qtdElementos++;
        ponteiroRefazer = (ponteiroRefazer + 1) % deque.length;
        
        // Se chegamos ao fim do histórico, não há mais o que refazer
        if (ponteiroRefazer == fim) {
            ponteiroRefazer = -1;
        }
        
        return acaoRefeita;
    }

    public String verUltimaAcao() {
        if (vazio()) {
            return null;
        }
        return deque[(fim - 1 + deque.length) % deque.length];
    }

    public boolean vazio() {
        return qtdElementos == 0;
    }

    public boolean cheio() {
        return qtdElementos == deque.length;
    }

    public int tamanho() {
        return qtdElementos;
    }
}