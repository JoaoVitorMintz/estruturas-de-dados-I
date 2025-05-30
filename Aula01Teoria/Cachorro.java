public class Cachorro  {
    // atributos
    String nome;
    int nascimento;
    String raca;
    String cor;
    boolean acordado;
    int tamanho; // em centímetros
    double peso;
    private int energia;
    
    //construtor
    public Cachorro(String nome, int nasc, String raca, String cor, 
                   boolean acordado, int tamanho, double peso, int energia) {
        
        this.nome = nome;
        this.nascimento = nasc;
        this.raca = raca;
        this.cor = cor;
        this.acordado = acordado;
        this.tamanho = tamanho;
        this.peso = peso;
        this.energia = energia;
    }
    
    public Cachorro() {
        this.nome = "sem nome";
        this.raca = "não definida";
    }
    
    //métodos
    
    
    public String toString() {
        String s;
        s = "Nome = " + this.nome 
        + "\nRaça = " + this.raca
		+ "\nNascimento = " + this.nascimento
		+ "\nEnergia = " + this.energia
		+ "\nAcordado = " + this.acordado;
		
		return s;
    }
    
    public void setEnergia(int valor) {
        if(valor >= 0)
           this.energia = valor;
    }
    
    public int getEnergia() {
        return this.energia;
    }
    
    public void acordar() {
        acordado = true;
    }
    public void dormir() {
        acordado = false;
    }
    public void comer(int quantidade) {
        energia += quantidade;
    }
    public void andar() {
        energia -= 1;
    }
    public void latir() {
        System.out.println("Au Au!!");
    }
}