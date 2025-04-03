import java.util.Scanner;

public class ExercicioGenerics {
    public static void main(String[] args) {
        pilhaGenerics<Integer> p = new pilhaGenerics<Integer>(200);
        int n;
        int count = 0;
        char resp;
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
        s.close();

        pilhaGenerics<Integer> temp = new pilhaGenerics<>(200);
        
        while(!p.isEmpty()) {
            try {
                int elemento = p.pop();
                if (elemento % 15 != 0) {
                    temp.push(elemento);
                }
            } catch (Exception e) {
                System.out.print("\nERRO:" + e.getMessage());
            }
        }
        while(!temp.isEmpty()) {
            try {
                p.push(temp.pop());
            } catch (Exception e) {
                System.out.print("\nERRO:" + e.getMessage());
            }
        }

        while(!p.isEmpty()) {
            try {
                System.out.print(p.pop() + " ");
            } catch (Exception e) {
                System.out.print("\nERRO:" + e.getMessage());
            }
        }
            
    }

}
