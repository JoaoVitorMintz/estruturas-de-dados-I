import java.util.Scanner;

public class exercicio1 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Indique um valor: ");
		int valor1 = input.nextInt();
		System.out.print("Indique outro valor: ");
		int valor2 = input.nextInt();
		
		int aux;
		aux = valor1;
		valor1 = valor2;
		valor2 = aux;
		
		System.out.println("Valor da variavel 1 é: " + valor1 + " Valor da variável 2 é: " + valor2);
	}

}