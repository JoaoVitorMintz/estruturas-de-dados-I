public class Cachorro extends Animal {
    
    //construtor
    public Animal(String nome, int nasc, String raca, String cor, boolean acordado, int tamanho, double peso, int energia) {

        super(nome, nasc, raca, cor, acordado, tamanho, peso, energia);

    }

    public Cachorro() {

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

    public int getNascimento() {
        return this.nascimento;
    }

    public String getRaca() {
        return this.raca;
    }

    public String getNome() {
        return this.nome;
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

    public String getCor() {
        return this.cor;
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