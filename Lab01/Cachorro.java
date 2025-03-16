public class Cachorro extends Animal {
   
    //construtor
    public Cachorro(String nome, int nasc, String raca, String cor, 
                   boolean acordado, int tamanho, double peso, int energia) {
        super(nome, nasc, raca, cor, acordado, tamanho, peso, energia);
    }
    
    public Cachorro() {
        super();
        
    }
    
    public void som() {
        System.out.println("Au Au!!");
    }
}