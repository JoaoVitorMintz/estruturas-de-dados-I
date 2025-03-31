public class stackGeneric<T> {

    private T p[];
    private int topo;


    // Método construtor da classe que recebe o tamanho que define o tamanho do Array.
    public stackGeneric(int tam) {
        topo = 0;
        p = (T[])new Object[tam];
    }
    

    // Inserir valor no topo da pilha.
    public boolean push(T value) {
        if (isFull()) {
            return false;
        }

        p[topo++] = value;

        return true;
    }

    // Retorna o item no topo da pilha e, em seguida, o remove.
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        
        T topoPilha = p[--topo];
        p[topo] = null;
        
        return topoPilha;
    }


    // Verifica se a pilha está cheia.
    public boolean isFull() {
        return topo == p.length;
    }

    // Verifica se a pilha está vazia.
    public boolean isEmpty() {
        return topo == 0;
    }

    // Verifica o tamanho da pilha e retorno o valor inteiro.
    public int tam() {
        return p.length;
    }

    // Limpa por completo a pilha, esvaziando-a por completo.
    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }

    // Retorna o valor da base da pilha:
    public T base() {
        return p[0];
    }

    // Verifica qual o topo da pilha, porém, sem removê-lo:
    public T top() {
        if (isEmpty()) {
            return null; // Retorna null diretamente, evitando o uso de stackGenericResult
        }
        return p[topo - 1];
    }

    // Verifica se há um valor em específico na pilha:
    public boolean inStack(T character) {
        for(int c = 0; c <= topo; c++) { 
            if(p[c] == character) {
                return true;
            }
        }
        return false;
    }


}
