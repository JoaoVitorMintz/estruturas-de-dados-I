public class Main
{
	public static void main(String[] args) {
	    
		// OBJETO DA CLASSE:
	    Cachorro meuPet = new Cachorro("Totó", 2025, "Labrador", "chocolate", true, 15, 0.5, 5);
		//Cachorro meuPet2 = new Cachorro();
	    //Cachorro meuPet3 = new Cachorro("Lulu", 2024, "Pit", "branca", true, 20, 0.8, 5);
	    
		System.out.println(meuPet);
		System.out.println("------------------");
		/*
		System.out.println("Dados do meuPet:\n");
		System.out.println("Nome = " + meuPet.nome);
		System.out.println("Raça = " + meuPet.raca);
		System.out.println("Nascimento = " + meuPet.nascimento);
		System.out.println("Energia = " + meuPet.energia);
		System.out.println("Acordado = " + meuPet.acordado); 
		*/
		meuPet.setEnergia(80);
		
		System.out.println("Energia = " + meuPet.getEnergia());
		
		
		
		
	}
}