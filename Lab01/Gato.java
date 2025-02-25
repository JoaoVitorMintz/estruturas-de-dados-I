public class Gato extends Animal {

    //construtor
    public Gato(String nome, int nasc, String raca, String cor, 
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
    
    public Gato() {
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
		+ "\nAcordado = " + this.acordado
        + "\nAssustado = " + this.assustado;
		
		return s;
    }
    
    public void setEnergia(int valor) {
        if(valor >= 0)
           this.energia = valor;
    }
    
    public int getEnergia() {
        return this.energia;
    }

    public int getNascimento() {
        return this.nascimento;
    }

    public String getRaca() {
        return this.raca;
    }

    public String getNome() {
        return this.nome;
    }
    
    public String getCor() {
        return this.cor;
    }

    public boolean getAcordado() {
        return this.acordado;
    }

    public int getTamanho() {
        return this.tamanho;
    }
    
    public double getPeso() {
        return this.peso;
    }

    public boolean getAssustado() {
        return this.assustado;
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
    public void miar() {
        System.out.println("Miau");
    }
}