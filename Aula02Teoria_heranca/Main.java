public class Main {
    public static void main(String[] args) {
        Cachorro meuDog = new Cachorro("Totó", 2025, "Labrador", "chocolate", true, 15, 0.5, 5);
        Gato meuGato = new Gato("Mimi", 2024, "Siamês", "cinza", true, 10, 0.4, 3);
        
        System.out.println(meuDog);
        System.out.println("------------------");
        System.out.println(meuGato);
        
        meuDog.setEnergia(-10);
        System.out.println("Energia do dog = " + meuDog.getEnergia());
        meuGato.setEnergia(50);
        System.out.println("Energia do gato = " + meuGato.getEnergia());
        
        meuDog.som();
        meuGato.som();
        
        // Exemplo de polimorfismo
        Animal animalGenerico = new Cachorro();
        animalGenerico.som(); // Vai latir, mesmo sendo declarado como Animal

		Animal animalGenerico2 = new Gato();
		animalGenerico2.som();
    }
}