import java.util.Scanner;

public class exercicio07 {

    static int contarVogais(String a) {
        char vetor[] = a.toCharArray();
        int contador = 0;
        char vogais[] = {'a', 'e', 'i', 'o', 'u'};

        for (int c = 0; c < a.length(); c++) {
            for (int i = 0; i < 5; i++) {
                if (vetor[c] == vogais[i]) {
                    contador += 1;
                }
            }
        }
        return contador;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Escreva uma palavra: ");
        String palavra = input.next();

        System.out.println("\nNúmero de vogais: " + contarVogais(palavra));
    }
}
