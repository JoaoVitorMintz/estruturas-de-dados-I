import java.util.Scanner;

public class exercicio06 {
    static float mulComAdicao(float n1, int n2) {
		float resultado = 0.0f;
		
		for (int i = 0; i < n2; i++) {
			resultado += n1;
		}
		
		return resultado;
		
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		float a = 3.5f;
		int b = 4;
		float r = mulComAdicao(a, b);
		System.out.println(a + " * " + b + " = " + r);
	}

}