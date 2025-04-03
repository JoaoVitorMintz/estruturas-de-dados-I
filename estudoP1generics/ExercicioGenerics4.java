import java.util.Scanner;

public class ExercicioGenerics4 {
    public static void main(String[] args) {
        pilhaGenerics<Integer> p = new pilhaGenerics<Integer>(200);
        int n;
        int count = 0;
        char resp;
        int qtd;
        Scanner s = new Scanner(System.in);
        do {
            System.out.print("Deseja fornecer um numero? (S/N): ");
            resp = s.next().toUpperCase().charAt(0);
            if (resp == 'S') {
                System.out.print("Forneça o " + ++count + "o numero: ");
                n = s.nextInt();
                try {
                    p.push(n);
                } catch (Exception e) {
                    System.out.print("\nERRO:" + e.getMessage());
                }
            }
        } while((resp == 'S') && (count < 200));

        System.out.print("\nIndique quantos numeros deseja eliminar: ");
        qtd = s.nextInt();

        try {
            p.popNBase(qtd);
        } catch (Exception e) {
            System.out.print("\nERRO:" + e.getMessage());
        }


        s.close();
    }

}


