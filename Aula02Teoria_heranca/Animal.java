public class Animal {
    // Atributos protegidos (acessíveis pelas subclasses)
    protected String nome;
    protected int nascimento;
    protected String raca;
    protected String cor;
    protected boolean acordado;
    protected int tamanho;
    protected double peso;
    protected int energia;

    // Construtor completo
    public Animal(String nome, int nascimento, String raca, String cor, 
                 boolean acordado, int tamanho, double peso, int energia) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.raca = raca;
        this.cor = cor;
        this.acordado = acordado;
        this.tamanho = tamanho;
        this.peso = peso;
        this.energia = energia;
    }

    // Construtor padrão
    public Animal() {
        this.nome = "sem nome";
        this.raca = "não definida";
        this.acordado = false;
        this.energia = 0;
    }

    // Métodos comuns a todos os animais
    public void setEnergia(int valor) {
        if(valor >= 0) {
            this.energia = valor;
        }
    }

    public int getEnergia() {
        return this.energia;
    }

    public void acordar() {
        this.acordado = true;
    }

    public void dormir() {
        this.acordado = false;
    }

    public void comer(int quantidade) {
        this.energia += quantidade;
    }

    public void andar() {
        this.energia -= 1;
    }

    // Método que pode ser sobrescrito pelas subclasses
    public void som() {
        System.out.println("Este animal não faz som definido");
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getNascimento() {
        return nascimento;
    }

    public String getRaca() {
        return raca;
    }

    public String getCor() {
        return cor;
    }

    public boolean getAcordado() {
        return acordado;
    }

    public int getTamanho() {
        return tamanho;
    }

    public double getPeso() {
        return peso;
    }

    // toString para representação textual
    @Override
    public String toString() {
        return "Nome = " + nome +
               "\nRaça = " + raca +
               "\nNascimento = " + nascimento +
               "\nEnergia = " + energia +
               "\nAcordado = " + acordado;
    }
}