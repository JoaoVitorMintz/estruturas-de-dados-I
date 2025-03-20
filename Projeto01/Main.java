import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String data;
        char[] vars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        double[] varValue = new double[26];
        int indice;
        
        stackGeneric<Integer> s1 = new stackGeneric<>(50);
        stackGeneric<Character> s2 = new stackGeneric<>(50);

        do {
            

            System.out.print(">>> ");
            data = sc.nextLine().trim().toUpperCase();
            
            if(data.contains("=")) {
                verificarVariavel(vars, varValue, data);
            }

            if(data.contains("+") || data.contains("-") || data.contains("*") || data.contains("/") || data.contains("(") || data.contains(")")) {
                System.out.println("Expressão infixa: " + expreInfixa(data, vars, varValue));
            }

            
            

        } while(!data.equalsIgnoreCase("EXIT"));

        sc.close();

    }

    static void verificarVariavel(char[] var, double[] value, String resp) {
        int indice = 0;
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
            }
        }
    }

    static String expreInfixa(String expres, char[] vars, double[] varValue) {
        for(int i = 0; i < expres.length(); i++) {
            char c = expres.charAt(i);
              

            if(c == '*') {

            }
        }
        return "a";
    }
    
}


/*
  ~Referências: 
    .split: https://codegym.cc/pt/groups/posts/pt.512.metodo-java-string-split-

 */
