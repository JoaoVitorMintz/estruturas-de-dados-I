import java.util.Scanner;

public class Main {

    static void verificarVariavel(char[] var, double[] value, String resp) {
        if(resp.contains("=")) {
            String[] palavras = resp.split("=");
            if(palavras.length == 2) {
                String letra = palavras[0].trim().toUpperCase();
                double valor = Double.parseDouble(palavras[1]);


                for(int c = 0; c < 26; c++) {
                    if(letra.equalsIgnoreCase(String.valueOf(var[c]))) {
                        value[c] = valor;
                    }
                }
            } else {
                System.out.println("Você não criou uma igualdade.");
            }
        } else {
            System.out.println("Não há '='");
        }
        
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String data;
        char[] vars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        double[] varValue = new double[26];
        

        do {
            

            System.out.print(">>> ");
            data = sc.nextLine().trim().toUpperCase();
            
            if(!data.equalsIgnoreCase("EXIT")) {
                verificarVariavel(vars, varValue, data);
            }

            for(int c = 0; c < 26; c++) {
                System.out.print(varValue[c] + " ");
            }
            System.out.print("\n");

            
            

        } while(!data.equalsIgnoreCase("EXIT"));

        sc.close();

    }

    
}


/*
  ~Referências: 
    .split: https://codegym.cc/pt/groups/posts/pt.512.metodo-java-string-split-


 */
