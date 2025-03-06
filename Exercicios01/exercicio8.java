import java.util.Scanner;

public class exercicio8 {

    static boolean haColisaoEntreCirculos(float x1, float y1, float r1, float x2, float y2, float r2) {
        float difX = x2 - x1;
        float difY = y2 - y1;
        double distCirc = Math.sqrt(Math.pow(difX, 2) + Math.pow(difY, 2));
        float somaRaios = r1 + r2;

        if (somaRaios >= distCirc) {
            // Colidem/Sobrepõem
            return true;
        } else {
            return false;
        }
    }

    public static void main(String [] args) {

        Scanner input = new Scanner(System.in);
        float x1, x2, y1, y2, r1, r2;

        // Definindo posição dos círculos:
        System.out.print("Indique x1: ");
        x1 = input.nextFloat();
        System.out.print("Indique y1: ");
        y1 = input.nextFloat();
        System.out.print("Indique r1: ");
        r1 = input.nextFloat();
        System.out.print("Indique x2: ");
        x2 = input.nextFloat();
        System.out.print("Indique y2: ");
        y2 = input.nextFloat();
        System.out.print("Indique r2: ");
        r2 = input.nextFloat();

        System.out.print("\nSe colidem/sobrepoem? " + haColisaoEntreCirculos(x1, y1, r1, x2, y2, r2));

    }

}
