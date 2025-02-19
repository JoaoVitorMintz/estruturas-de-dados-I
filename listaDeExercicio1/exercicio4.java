import java.util.Scanner;

public class exercicio4 {
    public static void main (String[] arg) {
        Scanner input = new Scanner(System.in);

        int vetor[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int c = 0; c < 10; c++) {
            System.out.print("Indique o valor de número " + (c+1) + ": ");
            vetor[c] = input.nextInt();
        }

        for (int d = 9; d >= 0; d--) {
            System.out.print(vetor[d] + " ");
        }
    }

}
 