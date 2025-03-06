import java.util.Scanner;

public class exercicio2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Escreva uma letra: ");
		String letra = input.next();
		char a = letra.charAt(0);
		
		int valor = 0;
		
		
		char vogais[] = {'a', 'e', 'i', 'o', 'u'};
		
		for (int c = 0; c < 5; c++) {
			if (vogais[c] == a) {
				valor += 1;
			}
		}
		
		if (valor >= 1) {
			System.out.print("É vogal!");
		} else {
			System.out.print("Não é vogal...");
		}
	}
		
}