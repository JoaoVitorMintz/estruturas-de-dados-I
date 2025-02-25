public class Animal {

        // atributos encapsulados
        private String nome;
        private int nascimento;
        private String raca;
        private String cor;
        private boolean acordado;
        private int tamanho; // em centímetros
        private double peso;
        private int energia;
        private boolean assustado;
    
        public Animal(String nome, int nasc, String raca, String cor, 
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
}
