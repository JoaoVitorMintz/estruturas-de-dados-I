/*
ALUNO: João Vitor Garcia Aguiar Mintz
RA: 10440421
TURMA: 03G
 */

import java.util.Scanner;
public class Main
{
	public static void main(String[] args) { 
	    Fila minhaFila = new Fila(10);
	    // definido pela classe Fila
	    int opcao;
	    Scanner sc = new Scanner(System.in);

	    do {
	        System.out.println("\n1 - inserir");
	        System.out.println("2 - remover");
	        System.out.println("3 - exibir início");
	        System.out.println("4 - reiniciar");
	        System.out.println("5 - sair");
	        System.out.print("\nDigite uma opçao válida: ");
	        opcao = sc.nextInt(); // input do java para inteiros
	        
	        // inserir switch ... case
			switch(opcao) {
				case 1:
					System.out.print("\nValor a ser inserido: ");
					int valor1 = sc.nextInt();

					if(minhaFila.inserir(valor1) == false) {
						System.out.println("\nValor não inserido, fila cheia!");
					} else {
						System.out.println("\nValor adicionado na fila!");
					}
					break;
				case 2:
					int receba = minhaFila.remover();
					if(receba == -1) {
						System.out.println("\nPilha vazia, nao tem o que remover.");
					} else { 
						System.out.println("\nValor " + receba + " removido com sucesso!");
					}
					break;
				case 3:
					if(minhaFila.mostrarInicio() == -1) {
						System.out.println("\nPilha vazia, nao tem o que mostrar.\n");
					} else {
						System.out.println("\nValor de inicio da fila: " + minhaFila.mostrarInicio());
					}
					break;
				case 4:
					minhaFila.reiniciar();
					System.out.println("\nFila reiniciada!\n");
					break;
				}
			} while(opcao != 5);
			System.out.print("\nPrograma finalizado...\n");
		}
	}

