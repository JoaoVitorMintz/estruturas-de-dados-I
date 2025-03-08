/*
ALUNO: João Vitor Garcia Aguiar Mintz
RA: 10440421
TURMA: 03G
 */

class Fila {
    int []f;
    int qtdElementos;
    int inicio;
    int fim;
    
    // construtor
    public Fila(int tamanho) {
        f = new int[tamanho]; 
        inicio = 0;
        fim = -1;
        qtdElementos = 0;
    }
    
    public boolean inserir(int valor) {
        if(filaCheia())
            return false;
        this.fim = (this.fim + 1) % f.length;
        f[this.fim] = valor;
        qtdElementos++;
        return true;
    }
    
    public int remover() {
        int valor;

        if(filaVazia()){
            return -1;
        } else {
            valor = f[inicio];
            inicio = ((inicio + 1) % f.length);
            qtdElementos--;
            return valor;
        }

    }
    
    private boolean filaVazia() {
        if(this.qtdElementos == 0) {
            return true;
        } else {
            return false;
        }
    }
    private boolean filaCheia() {
        if(this.qtdElementos == f.length) {
            return true;
        } else {
            return false;
        }
    }
    int mostrarInicio() {
        if(!filaVazia()) 
            return f[inicio];
        return -1; // código de erro. Indica fila vazia.
    }

    public void exibirElementos() {
        int ini, qtd;
        ini = inicio;
        qtd = qtdElementos;

        if(filaVazia()) {
            System.out.println("Fila vazia!");
        } else {
            while (qtd-- != 0) {
                ini = ((ini + 1) % f.length);
                System.out.print(f[ini] + " ");
            }
        }
    }

    public void reiniciar() {
        inicio = 0;
        fim = -1;
        qtdElementos = 0;
    }
}