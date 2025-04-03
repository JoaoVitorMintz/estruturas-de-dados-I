public class pilhaGenerics <T> {
    private static final int TAM_DEFAULT = 100;
    private int topo;
    private T p[];
    private T temp[];

    // Construtor que recebe parâmetros do usuário:
    public pilhaGenerics(int tamanho) {
        this.p = (T[]) new Object[tamanho];
        this.temp = (T[]) new Object[tamanho];
        this.topo = -1;
    }

    // Construtor que caso o usuário não insira parâmetro tamanho, ele usa o this() para passar o parâmetro no construtor de cima:
    public pilhaGenerics() {
        this(TAM_DEFAULT);
    }
    
    public boolean isEmpty() {
        return this.topo == -1; // mesmo que usar if(this.topo == -1) return true
    }

    public boolean isFull() {
        return this.topo == this.p.length - 1;
    }

    public void push(T e) throws Exception{
        if (!this.isFull()) {
            this.p[++this.topo] = e;
        } else {
            throw new Exception("Overflow - Estouro de Pilha");
        }
    }

    public T pop() throws Exception{
        if (!this.isEmpty()) {
            return this.p[this.topo--];
        } else {
            throw new Exception("Underflow - Esvaziamento de Pilha");
        }
    }

    public T topo() throws Exception{
        if (!isEmpty()) {
            return this.p[this.topo];
        } else {
            throw new Exception("Underflow - Esvaziamento de Pilha");
        }
    }

    public int sizeElements() {
        return topo+1;
    }

    public void popNTop(int n) throws Exception {
        if(topo < n) {
            throw new Exception("Valor inserido maior que a quantidade da pilha");
        } else {
            for(int i = 0; i < n; i++) {
                pop();
            }
        }
    }

    public void invert() {
        int auxTopo = -1;
        System.out.println("\nNumeros antes de inverter na pilha:");
        while(!isEmpty()) {
            try {
                T elemento = this.pop();
                System.out.print(elemento + " ");
                this.temp[++auxTopo] = elemento;
            } catch (Exception e) {
                System.out.println("\nErro ao inverter: " + e.getMessage());
            }
        }
        System.out.println("\nNumeros depois de inverter na pilha:");
        while(auxTopo >= 0) {
            System.out.print(this.temp[auxTopo] + " ");
            T elemento = this.temp[auxTopo--];
            try {
                this.push(elemento);
            } catch (Exception e) {
                System.out.println("\nErro ao desinverter: " + e.getMessage());
            }
        }
    }

    public void popNBase(int n) throws Exception {
        int auxTopo = -1;
        if(topo < n) {
            throw new Exception("Valor inserido maior que a quantidade da pilha");
        } else {
            while(!isEmpty()) {
                try {
                    T elemento = this.pop();
                    this.temp[++auxTopo] = elemento;
                } catch (Exception e) {
                    System.out.println("\nErro ao inverter: " + e.getMessage());
                }
            }

            for(int i = 0; i < n; i++) {
                T elemento = this.temp[auxTopo--];
            }
            while(auxTopo >= 0) {
                T elemento = this.temp[auxTopo--];
                try {
                    this.push(elemento);
                } catch (Exception e) {
                    System.out.println("\nErro ao desinverter: " + e.getMessage());
                }
            }

            while(!isEmpty()) {
                T elemento = this.pop();
                System.out.print(elemento + " ");
            }
        }
    }

}
