public class stackGeneric<T> {

    private T p[];
    private int topo;


    // Método construtor da classe que recebe o tamanho que define o tamanho do Array.
    public stackGeneric(int tam) {
        topo = -1;
        p = (T[])new Object[tam];
    }
    

    // Inserir valor no topo da pilha.
    public boolean push(T value) {
        if (isFull()) {
            return false;
        }

        topo++;
        p[topo] = value;

        return true;
    }

    // Retorna o item no topo da pilha e, em seguida, o remove.
    public stackGenericResult<T> pop() {
        if (isEmpty()) {
            return new stackGenericResult<T>(false, null);
        }


        T topoPilha = p[topo];
        p[topo] = null;
        topo--;

        return new stackGenericResult<T>(true, topoPilha);
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


}
