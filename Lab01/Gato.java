public class Gato extends Animal {

    
    //construtor
    public Gato(String nome, int nasc, String raca, String cor, 
                   boolean acordado, int tamanho, double peso, int energia) {
        super(nome, nasc, raca, cor, acordado, tamanho, peso, energia);
    }
    
    public Gato() {
        super();
    }
    
    //métodos

    public void som() {
        System.out.println("Miauuuuuuuu!!");
    }
}