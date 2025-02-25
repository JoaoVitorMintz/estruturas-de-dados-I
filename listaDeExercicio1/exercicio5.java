import java.util.Scanner;

public class exercicio5 {
    static int min(int a, int b) {
		if (a < b) {
			return a;
		} else {
			return b;
		}
		
	}
	
	static int max(int a, int b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}
	
	public static void main(String[] args) {
		int a, b;
		Scanner input = new Scanner(System.in);
		System.out.print("Escreva o número A: ");
		a = input.nextInt();
		System.out.print("\nEscreva o número B: ");
		b = input.nextInt();
		
		System.out.println("O menor valor é: " + min(a,b));
		
		System.out.println("O maior valor é: " + max(a,b));
		
		
	}
}
