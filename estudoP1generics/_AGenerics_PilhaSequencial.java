import java.util.Scanner;

public class _AGenerics_PilhaSequencial {
    Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try {
            pilhaGenerics<Integer> p = new pilhaGenerics<>();
            int n, resto, nSalvo;
            System.out.print("\nDigite um numero inteiro em decimal: ");
            n = s.nextInt();
            nSalvo = n;

            do {
                resto = n % 2;
                p.push(resto);
                n = n / 2;
            } while (n != 0);
            System.out.println("\nTotal de elementos na pilha: " + p.sizeElements());
            System.out.println("\nO correspondente binario do valor " + nSalvo + " e: ");
            while(!p.isEmpty()) {
                System.out.print(p.pop());
            }


        } catch(Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        s.close();
    }
}