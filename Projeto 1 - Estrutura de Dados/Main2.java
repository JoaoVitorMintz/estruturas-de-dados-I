/*
 Nome: João Vitor Garcia Aguiar Mintz        RA: 10440421
 Nome: Yan Adreotti dos Santos               RA: 10439766
 Nome: Giovanni Barreto Garitano de Castro   RA: 10435745
 Nome: Enzo Ferrari de Moura Sampaio         RA: 10440331
 */

 import java.util.Scanner;

 
 public class Main2 {
     private static stackGeneric<Character> s = new stackGeneric<>(50);
     private static stackGeneric<Float> s2 = new stackGeneric<>(50);
 
     public static void main(String args[]) {
         Scanner scanner = new Scanner(System.in);
         String entrada;
         char[] variaveis = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
         double[] valoresVariaveis = new double[26];
         System.out.println("Calculadora Infixa:");
 
         do {
             System.out.print("\n>>> ");
             entrada = scanner.nextLine().trim().toUpperCase();
 
             if(entrada.equalsIgnoreCase("EXIT")) {
                 break;
             }
 
             // Comando para listar todas as variáveis definidas
             if(entrada.equalsIgnoreCase("VARS")) {
                 boolean temVariaveis = false;
                 for(int i = 0; i < variaveis.length; i++) {
                     if(valoresVariaveis[i] != 0) {
                         System.out.println(variaveis[i] + " = " + valoresVariaveis[i]);
                         temVariaveis = true;
                     }
                 }
                 if(!temVariaveis) {
                     System.out.println("Nenhuma variável definida.");
                 }
                 continue;
             }
 
             // Comando para resetar todas as variáveis
             if(entrada.equalsIgnoreCase("RESET")) {
                 for(int i = 0; i < valoresVariaveis.length; i++) {
                     valoresVariaveis[i] = 0;
                 }
                 System.out.println("Variáveis reiniciadas.");
                 continue;
             }
 
             // Verifica se é uma atribuição de variável (ex: A=5)
             if(entrada.contains("=")) {
                 processarAtribuicaoVariavel(variaveis, valoresVariaveis, entrada);
                 continue;
             }
 
             // Verifica parênteses desbalanceados
             if((!entrada.contains("(") && entrada.contains(")")) || (entrada.contains("(") && !entrada.contains(")"))) {
                 System.out.println("Erro: expressão inválida.");
                 continue;
             }
 
             // Processa expressões matemáticas
             if(entrada.matches(".*[+\\-*/()].*")) {
                 try {
                     String posfixa = exprePosfixa(entrada);
                     System.out.println("\n~Expressao pós-fixa:\n-> " + posfixa);
                     System.out.println("~Cálculo da expressao pos-fixa: " + calcularPosfixa(posfixa, variaveis, valoresVariaveis));
                 } catch (Exception e) {
                     System.out.println("Erro ao processar expressão: " + e.getMessage());
                 }
             }
 
         } while(true);
 
         scanner.close();
         System.out.println("\nPROGRAMA FINALIZADO!");
     }
 
     // Converte expressão infixa para posfixa (notação polonesa reversa)
     static String exprePosfixa(String expres) {
        // Criando variáveis auxiliares para manejo da string:
         char[] auxAfixo = expres.toCharArray();
         char[] auxPosfixo = new char[expres.length() * 2];
         boolean digitoAnterior = false; // Variável que auxília saber se o número tinha mais de um dígito ou se era digito único ou se era uma variável
         int indice = 0;
         
         // Inicia um loop passando por cada carácter presente no array auxAfixo para construir o array auxPosfixo:
         for(int d = 0; d < expres.length(); d++) {
             if(Character.isDigit(auxAfixo[d]) || Character.isLetter(auxAfixo[d])) { // Analisa se é um número ou uma letra que funciona como variável
                 auxPosfixo[indice++] = auxAfixo[d];
                 digitoAnterior = true;
             } else {
                 if(digitoAnterior) {
                     auxPosfixo[indice++] = ' ';
                     digitoAnterior = false;
                 }
                 if(auxAfixo[d] == '(') { // Verifica no caso de '(' para controle do pop em variáveis dentro do parênteses
                     s.push(auxAfixo[d]);
                 } else if(auxAfixo[d] == ')') {
                     while(!s.isEmpty() && s.top() != '(') {
                         auxPosfixo[indice++] = s.pop();
                         auxPosfixo[indice++] = ' ';
                     }
                     if(!s.isEmpty()) s.pop(); // Remove o '(' quando não mais necessário
                     // Desempilha os de maior ou igual importância antes de empilhar o atual de menor importância, comparando-os numéricamente:
                 } else if(auxAfixo[d] == '+' || auxAfixo[d] == '-' || auxAfixo[d] == '*' || auxAfixo[d] == '/') {
                     while(!s.isEmpty() && importancia(s.top()) >= importancia(auxAfixo[d])) {
                         auxPosfixo[indice++] = s.pop();
                         auxPosfixo[indice++] = ' ';
                     }
                     s.push(auxAfixo[d]); // Ao comparar os símbolos, caso o simbolo presente na lista seja de maior importância que o símbolo do topo
                                          //topo da pilha, o simbolo é enviado para a pilha.
                 }
             }
         }
         // Desempilha qualquer operador restante ainda presente na pilha:
         while(!s.isEmpty()) {
             auxPosfixo[indice++] = ' ';
             auxPosfixo[indice++] = s.pop();
         }
         // Retorna para a main a expressão pós-fixa finalizada:
         return new String(auxPosfixo).trim();
     }
     
     // Função que indica o nível de importância dos símbolos com base em valores numéricos:
     private static int importancia(char simbolo) {
         if (simbolo == '*' || simbolo == '/') {
             return 2;
         } else if (simbolo == '+' || simbolo == '-') {
             return 1;
         }
         return 0;
     }
 
     // Calcula o valor de uma expressão na notação posfixa
     static float calcularPosfixa(String expressaoPosfixa, char[] variaveis, double[] valoresVariaveis) {
         String[] tokens = expressaoPosfixa.split("\\s+");
 
         for (String token : tokens) {
             if (token.isEmpty()) continue; //Checa se a pilha está vazia
 
             if (token.matches("\\d+")) {  // Se for número
                 s2.push(Float.parseFloat(token));
             }
             else if (token.matches("[A-Z]")) {  // Se for variável
                 char variavel = token.charAt(0);
                 float valor = 0;
                 for(int i = 0; i < variaveis.length; i++) {
                     if(variaveis[i] == variavel) {
                         valor = (float)valoresVariaveis[i];
                         break;
                     }
                 }
                 s2.push(valor);
             }
             //checa se o índice é soma
             else if (token.equals("+")) {
                 s2.push(s2.pop() + s2.pop()); //Coloca na pilha o resultado do valor da soma
             }
             
             //checa se o índice é subtracao
             else if (token.equals("-")) {
                 float subtraendo = s2.pop();
                 s2.push(s2.pop() - subtraendo); //Coloca na pilha o resultado do valor da subtracap
             }
             
             //checa se o índice é multiplicacao
             else if (token.equals("*")) {
                 s2.push(s2.pop() * s2.pop()); //Coloca na pilha o resultado do valor da multiplicacao
             }
             
             //checa se o índice é divisao
             else if (token.equals("/")) {
                 float divisor = s2.pop();
                 s2.push(s2.pop() / divisor); //Coloca na pilha o resultado do valor da divisao
             }
         }
         
         return s2.pop(); //tira o resultado da fila para imprimir o valor
     }
 
     // Processa a atribuição de valor a uma variável (ex: A=5)
     static void processarAtribuicaoVariavel(char[] variaveis, double[] valoresVariaveis, String entrada) {
         String[] partes = entrada.split("="); // Divide a string no sinal de igual
         if(partes.length != 2) { // Verifica se a entrada tem exatamente duas partes (variável e valor)
             System.out.println("Formato inválido. Use: VARIAVEL=VALOR");
             return;
         }
  // Obtém e formata o nome da variável (remove espaços e converte para maiúsculo)
         String nomeVariavel = partes[0].trim().toUpperCase();
         String valorStr = partes[1].trim();
 
    // Valida se o nome da variável tem exatamente 1 caractere e é uma letra
         if(nomeVariavel.length() != 1 || !Character.isLetter(nomeVariavel.charAt(0))) {
             System.out.println("Nome de variável inválido. Deve ser uma única letra de A-Z");
             return;
         }
 
         try {
            // Tenta converter o valor para double
             double valor = Double.parseDouble(valorStr);
             boolean encontrou = false;
 
             // Percorre o array de variáveis para encontrar a correspondente
             for(int i = 0; i < variaveis.length; i++) {
                 if(nomeVariavel.equals(String.valueOf(variaveis[i]))) {
                     valoresVariaveis[i] = valor;
                     System.out.println("Variável " + variaveis[i] + " definida como " + valor);
                     encontrou = true;
                     break;
                 }
             }
 
             if(!encontrou) {
                 System.out.println("Variável não encontrada no array de variáveis");
             }
         } catch (NumberFormatException e) {
             System.out.println("Valor inválido após o =. Deve ser um número");
         }
     }
 }
  /*
    ~Referências:
      .split: https://codegym.cc/pt/groups/posts/pt.512.metodo-java-string-split-
      método character: https://www.devmedia.com.br/metodos-da-classe-character-string-em-java-parte-3/21811
      Java string: https://www.ionos.com/pt-br/digitalguide/sites-de-internet/desenvolvimento-web/java-strings/
      Java Regex:  https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
      Stack Overflow - Generic Array: https://stackoverflow.com/questions/529085/how-to-create-a-generic-array-in-java
      //d+: https://www.codementor.io/@nehavaidya/java-regex-tutorial-regular-expressions-in-java-x5d8cx3xt
   */