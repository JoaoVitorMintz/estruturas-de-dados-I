/*
 Nome: João Vitor Garcia Aguiar Mintz        RA: 10440421
 Nome: Yan Adreotti dos Santos               RA: 10439766
 Nome: Giovanni Barreto Garitano de Castro   RA: 10435745
 Nome: Enzo Ferrari de Moura Sampaio         RA: 10440331
 */

 import java.util.Scanner;

 public class teste2 {
     private static stackGeneric<Character> s = new stackGeneric<>(50);
     private static stackGeneric<Float> s2 = new stackGeneric<>(50);
 
     public static void main(String args[]) {
         Scanner sc = new Scanner(System.in);
         String data;
         char[] vars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
         double[] varValue = new double[26];
         System.out.println("Calculadora Infixa:");
 
         do {
             System.out.print("\n>>> ");
             data = sc.nextLine().trim().toUpperCase();
 
             if(data.equalsIgnoreCase("EXIT")) {
                 break;
             }
 
             if(data.equalsIgnoreCase("VARS")) {
                 boolean hasVars = false;
                 for(int i = 0; i < vars.length; i++) {
                     if(varValue[i] != 0) {
                         System.out.println(vars[i] + " = " + varValue[i]);
                         hasVars = true;
                     }
                 }
                 if(!hasVars) {
                     System.out.println("Nenhuma variável definida.");
                 }
                 continue;
             }
 
             if(data.equalsIgnoreCase("RESET")) {
                 for(int i = 0; i < varValue.length; i++) {
                     varValue[i] = 0;
                 }
                 System.out.println("Variáveis reiniciadas.");
                 continue;
             }
 
             if(data.contains("=")) {
                 verificarVariavel(vars, varValue, data);
                 continue;
             }
 
             if((!data.contains("(") && data.contains(")")) || (data.contains("(") && !data.contains(")"))) {
                 System.out.println("Erro: expressão inválida.");
                 continue;
             }
 
             if(data.matches(".[+\\-/()].*")) {
                 try {
                     String posfixa = exprePosfixa(data);
                     System.out.println("\n~Expressao pós-fixa:\n-> " + posfixa);
                     System.out.println("~Cálculo da expressao pos-fixa: " + calculoPosfixa(posfixa, vars, varValue));
                 } catch (Exception e) {
                     System.out.println("Erro ao processar expressão: " + e.getMessage());
                 }
             }
 
         } while(true);
 
         sc.close();
         System.out.println("\nPROGRAMA FINALIZADO!");
     }
 
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
 
     static float calculoPosfixa(String expresPosfixa, char[] vars, double[] varValue) {
         String[] tokens = expresPosfixa.split("\\s+");
 
         for (String token : tokens) {
             if (token.isEmpty()) continue;
 
             if (token.matches("\\d+")) {
                 s2.push(Float.parseFloat(token));
             }
             else if (token.matches("[A-Z]")) {
                 char var = token.charAt(0);
                 float value = 0;
                 for(int i = 0; i < vars.length; i++) {
                     if(vars[i] == var) {
                         value = (float)varValue[i];
                         break;
                     }
                 }
                 s2.push(value);
             }
             else if (token.equals("+")) {
                 s2.push(s2.pop() + s2.pop());
             }
             else if (token.equals("-")) {
                 float subtraendo = s2.pop();
                 s2.push(s2.pop() - subtraendo);
             }
             else if (token.equals("*")) {
                 s2.push(s2.pop() * s2.pop());
             }
             else if (token.equals("/")) {
                 float divisor = s2.pop();
                 s2.push(s2.pop() / divisor);
             }
         }
         return s2.pop();
     }
 
     static void verificarVariavel(char[] var, double[] value, String resp) {
         String[] partes = resp.split("=");
         if(partes.length != 2) {
             System.out.println("Formato inválido. Use: VARIAVEL=VALOR");
             return;
         }
 
         String letra = partes[0].trim().toUpperCase();
         String valorStr = partes[1].trim();
 
         if(letra.length() != 1 || !Character.isLetter(letra.charAt(0))) {
             System.out.println("Nome de variável inválido. Deve ser uma única letra de A-Z");
             return;
         }
 
         try {
             double valor = Double.parseDouble(valorStr);
             boolean encontrou = false;
 
             for(int c = 0; c < var.length; c++) {
                 if(letra.equals(String.valueOf(var[c]))) {
                     value[c] = valor;
                     System.out.println("Variável " + var[c] + " definida como " + valor);
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
   */