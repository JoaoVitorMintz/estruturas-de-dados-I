import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        pilha minhaPilha = new pilha(20);

        int opcao;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("1 - inserir\n2 - remover\n3 - exibir topo\n4 - reiniciar\n5 - sair");
            System.out.print("\nDigite uma opçao valida: ");
            opcao = sc.nextInt();

            if(opcao == 1) {
                System.out.print("Valor a ser inserido: ");
                int valorInserir = sc.nextInt();
                minhaPilha.empilhar(valorInserir);

                if(minhaPilha.empilhar(valorInserir) == true) {
                    System.out.println("\nvalor " + valorInserir + " inserido com sucesso!\n");
                } else {
                    System.out.println("\nValor não inserido: Pilha cheia.\n");
                }

            }
            if(opcao == 2) {
                minhaPilha.desempilhar();

                if(minhaPilha.desempilhar() == -1) {
                    System.out.println("Nao ha valor a ser removido");
                } else {
                    System.out.println("Valore removido com sucesso!");
                }
            }
            if(opcao == 3) {
                System.out.println("Topo da pilha: " + minhaPilha.mostrarTopo());
            }
            if(opcao == 4) {
                minhaPilha.esvaziar();
                System.out.println("Pilha reiniciada com sucesso!");
            }

        } while(opcao != 5);

        System.out.println("\nPrograma finalizado...");
        sc.close();
    }
    
}
