import java.util.Scanner;

public class Main {
    
    private static stackGeneric<Character> s = new stackGeneric<>(50);

    public static void main(String args[]) {
        

        Scanner sc = new Scanner(System.in);
        String data;

        
        System.out.println("Calculadora Infixa:");
        // Loop que rodará enquanto o usuário não digitar "EXIT": 
        do {
            
            // Trecho que indica onde será digitado:
            System.out.print("\n>>> ");
            data = sc.nextLine().trim().toUpperCase();

            // Criando um if para, caso o dado fornecido seja a escrita "EXIT", o programa é finalizado.
            if(data.equalsIgnoreCase("EXIT")) {
                break;
            }

            if(data.contains("(") && data.contains(")")) {
                continue;
            } else if (!data.contains("(") && data.contains(")") || data.contains("(") && !data.contains(")")){
                System.out.println("Erro: expressão inválida.");
                System.out.print("\n>>> ");
                data = sc.nextLine().trim().toUpperCase();
            }
            
            // IF que recebe os dados e transforma em expressão infixa:
            if(data.contains("+") || data.contains("-") || data.contains("*") || data.contains("/") || data.contains("(") || data.contains(")")) {
                System.out.println("\n~Expressao pós-fixa:\n-> " + exprePosfixa(data));
                System.out.println("~Cálculo da expressao pos-fixa: " + calculoPosfixa(exprePosfixa(data)));
            }

            

        } while(true);

        sc.close();
        System.out.println("\nPROGRAMA FINALIZADO!");
    }

    // Função que constrói em uma String a expressão pós-fixa e a devolve para visualização:
    static String exprePosfixa(String expres) {
        char[] auxAfixo = new char[expres.length()];
        char[] auxPosfixo = new char[expres.length() * 2];
        boolean digitoAnterior = false;
        int indice = 0;

        // Copia a expressão para um vetor que representa a expressão afixa cada caractér presente:
        for(int i = 0; i < expres.length(); i++) {
            char c = expres.charAt(i);
            auxAfixo[i] = c;
        }

        // Passa para um outro vetor agora a expressão em pós-fixo, sempre comparando os caractéres em cada posição do vetor:
        for(int d = 0; d < expres.length(); d++) {
            if(Character.isDigit(auxAfixo[d])) {
                auxPosfixo[indice++] = auxAfixo[d]; 
                digitoAnterior = true; 
            } else {
            if(digitoAnterior) { // Caso o digito anteriror seja true, da um espaço para inserir o operador ou o parênteses.
                auxPosfixo[indice++] = ' '; 
                digitoAnterior = false;
            } // Após inserir o espaço, verifica se abre parênteses ou não.
            if(auxAfixo[d] == '(') {
                s.push(auxAfixo[d]); // Caso abra, envia para a pilha.
            } else if(auxAfixo[d] == ')') { // Analisa se fecha parênteses e da pop() em todos os valores dentro do parênteses.
                while(!s.isEmpty() && s.top() != null && s.top() != '(') { // Verifica se a pilha não está vazia, topo está vazio e se o topo é diferente do parênteses inicial (MUITOS ERROS DE COMPILAÇÃO AAAAAAAAAAAA).
                    auxPosfixo[indice++] = s.pop();
                    auxPosfixo[indice++] = ' ';
                }
                s.pop();
            } else if(auxAfixo[d] == '+' || auxAfixo[d] == '-' || auxAfixo[d] == '*' || auxAfixo[d] == '/') { // Verifica se é um símbolo
                while(!s.isEmpty() && importancia(s.top()) >= importancia(auxAfixo[d])) { // Verifica o grau de importância do símbolo é maior que o que será inserido e, caso seja, realiza o pop() para devolver o de maior valor.
                        auxPosfixo[indice++] = s.pop(); // Devolve o simbolo da pilha para o vetor que constrói a expressão Pósfixa.
                        auxPosfixo[indice++] = ' ';
                    }   
                    s.push(auxAfixo[d]); // Símbolos são enviados para a pilha por aqui
                }
           
            }
        }
        // Retorna o restante de valores ainda presentes na pilha
        while(!s.isEmpty()) {
            auxPosfixo[indice++] = ' ';
            auxPosfixo[indice++] = s.pop();
        }
        // Retorna uma String à qual está escrita a expressão pós-fixa
        return new String(auxPosfixo).trim();
    }


    // Função que atribui importância à cada simbolo, tornando * e / mais importante que + e -
    private static int importancia(char simbolo) {
        if (simbolo == '*' || simbolo == '/') {
            return 2;
        } else if (simbolo == '+' || simbolo == '-') {
            return 1;
        }
        return 0;
    }

    // Função que calcula a expressão pós-fixa construída anteriormente:
    static double calculoPosfixa(String expresPosfixa) {
        return 0.3;
    }

}

/*
  ~Referências: 
    .split: https://codegym.cc/pt/groups/posts/pt.512.metodo-java-string-split-
    método character: https://www.devmedia.com.br/metodos-da-classe-character-string-em-java-parte-3/21811
    Java string: https://www.ionos.com/pt-br/digitalguide/sites-de-internet/desenvolvimento-web/java-strings/
 */

 