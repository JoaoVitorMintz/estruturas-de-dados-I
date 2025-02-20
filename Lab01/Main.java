public class Main
{
	public static void main(String[] args) {
	    
	    Cachorro meuDog = new Cachorro("Totó", 2025, "Labrador", "chocolate", true, 15, 0.5, 5);
		Gato meuGato = new Gato("Mimi", 2025, "Siamês", "Laranja", true, 10, 0.4, 5);
	    
		System.out.println(meuDog);
		System.out.println("------------------");
		System.out.println(meuGato);
		
		System.out.println("Dados dos meus Pets:\n\n");
		System.out.println("Nome = " + meuDog.getNome);
		System.out.println("Raça = " + meuDog.getRaca);
		System.out.println("Nascimento = " + meuDog.getNascimento);
		System.out.println("Energia = " + meuDog.getEnergia);
		System.out.println("Acordado = " + meuDog.getAcordado); 

		System.out.println("Nome = " + meuGato.getNome);
		System.out.println("Raça = " + meuGato.getRaca);
		System.out.println("Nascimento = " + meuGato.getNascimento);
		System.out.println("Energia = " + meuGato.getEnergia);
		System.out.println("Acordado = " + meuGato.getAcordado); 
		System.out.println("Assustado = " + meuGato.getAssustado);
		
		meuDog.setEnergia(-10);
		System.out.println("Energia do cachorro = " + meuDog.getEnergia());

		meuGato.setEnergia(50);
		System.out.println("Energia do Gato = " + meuGato.getEnergia());
		
		
		
		
	}
}