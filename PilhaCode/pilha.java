public class pilha {

    private int[] p;
    private int topo = -1;

    public boolean empilhar(int valor) {
        if(pilhaCheia())
            return false;
        topo++;
        p[topo] = valor;
        return true;
    }

    public pilha(int tamanho) {
        p = new int[tamanho];
    }

    public int desempilhar() {
        if(pilhaVazia())
            return -1;
        else
            return p[topo--];
    }

    public int mostrarTopo() {
        return p[topo];
    }

    private boolean pilhaVazia() {
        if(topo == -1)
            return true;
        else
            return false;
    }

    private boolean pilhaCheia() {
        if(topo == p.length - 1)
            return true;
        else
            return false;
    }

    public void esvaziar() {
        topo = -1;
    }
}