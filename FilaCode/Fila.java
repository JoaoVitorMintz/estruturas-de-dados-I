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

    // this. é usado para se referenciar ao objeto atributo do construtor, porém, this() pode ser usado dentro de um outro construtor
    //para se referência a um construtor feito anteriormente:
    /*
    EXEMPLO:
    public class Pessoa {
    private String nome;
    private int idade;
    
    // Construtor principal
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    
    // Construtor secundário que chama o principal usando this()
    public Pessoa(String nome) {
        this(nome, 0); // Chama o construtor Pessoa(String nome, int idade)
        }
    }
    */
    
    // Construtor:
    public Fila(int tamanho) {
        f = new int[tamanho]; 
        inicio = 0;
        fim = -1;
        qtdElementos = 0;
    }
    
    // Métodos:
    public boolean inserir(int valor) {
        if(filaCheia()) {
            return false;
        } else {
            this.fim = (this.fim + 1) % f.length; // Esse this se refere ao objeto/atributo do construtor fim e, nesse caso, é desnecessário.
            f[this.fim] = valor;
            qtdElementos++;
            return true;
        }

    }
    
    public int remover() {
        int valor;

        if(filaVazia()){
            return -1;
        } else {
            valor = f[this.inicio];
            this.inicio = ((this.inicio + 1) % f.length);// Esse this é inútil, seria necessário caso tivesse mais de uma variável de mesmo nome local.
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
        if(!filaVazia()) {
            return f[inicio];
        } else {
            return -1; // código de erro. Indica fila vazia.
        }
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