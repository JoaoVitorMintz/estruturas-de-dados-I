import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Deque <Integer> minhaFila = new Deque<>();
        Integer valor;
        int opcao;
        Scanner sc = new Scanner(System.in);
        
        // completar com menu para o usuário
        do {
            System.out.println("1 - inserir");
            System.out.println("2 - remover");
            System.out.println("3 - exibir fila");
            System.out.println("4 - limpar");
            System.out.println("5 - sair");
            System.out.print("Escolha uma opcao valida: ");
            opcao = sc.nextInt(); // input do Java
            switch (opcao) {
                case 1:
                    System.out.print("\nDigite um elemento a ser inserido na fila: ");
                    valor = sc.nextInt();
                    if(minhaFila.insertFirst(valor))
                        System.out.println("\nValor inserido com sucesso!\n");
                    else
                        System.out.println("\nNao foi possível inserir, fila ja esta cheia!\n");
                    break;
                case 2:
                    valor = minhaFila.removeFirst();
                    if(valor == null)
                        System.out.println("\nFila vazia, nao ha elemento a ser removido!\n");
                    else
                        System.out.println("\nValor removido = " + valor + "\n");
                    break;
                case 3:
                    System.out.println(minhaFila.element());
                    break;
                case 4:
                    minhaFila.clean();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Opçao invalida!!");
            } 
        } while (opcao != 5);
        sc.close();
    }
}