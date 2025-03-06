import java.util.Scanner;

public class exercicio3 {
    public static void main (String[] arg) {
        Scanner input = new Scanner(System.in);

        float vetor[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int c = 0; c < 10; c++) {
            System.out.print("Indique o valor de número " + (c+1) + ": ");
            vetor[c] = input.nextFloat();
        }

        float maior = 0;
        float menor = 1000;

        for (int d = 0; d < 10; d ++) {
            if (vetor[d] > maior) {
                maior = vetor[d];
            }
            if (vetor[d] < menor) {
                menor = vetor[d];
            }
        }

        System.out.print("\nO maior número é " + maior + " e o menor número é " + menor);

    }
}
