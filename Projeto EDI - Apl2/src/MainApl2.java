//*************************** ATENÇÃO! ****************************
// O método main() deve ser alterado somente nos comentários TODO.
// Todas as outras instruções devem permanecer intactas e o código
// deve funcionar conforme descrito no enunciado da atividade.
//*************************** ATENÇÃO! ****************************
// arquivo: src/MainApl2.java

// Nome: Enzo Ferrari de Moura Sampaio         RA: 10440331
// Nome: Giovanni Barreto Garitano de Castro   RA: 10435745
// Nome: João Vitor Garcia Aguiar Mintz        RA: 10440421
// Nome: Yan Andreotti dos Santos              RA: 10439766

// Referências:
// - Documentação do projeto EDI-2025.1 - Apl2.pdf
// - Material de aula sobre listas encadeadas.
// - Código do professor Jefferson da aula do dia 08-05-25 (referenciado no DLinkedList.java)

import apl2.DLinkedList;
import apl2.Data;
import apl2.LinkedListOriginal;
import apl2.Node;
import apl2.Operation;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainApl2 {

	public static void main(String[] args) {
		LinkedListOriginal list = new LinkedListOriginal();


		//Carregar o conteúdo do arquivo "dados.txt" e adicionar cada linha como um nó na LinkedListOriginal list.
		try {
			String dadosTxtContent = Data.loadTextFileToString("dados.txt");
			if (dadosTxtContent != null && !dadosTxtContent.isEmpty()) {
				String[] linhas = dadosTxtContent.split("\\r?\\n"); // Handles Windows and Unix line endings
				for (String linha : linhas) {
					if (linha.trim().isEmpty()) continue;
					String[] partes = linha.split("#");
					if (partes.length == 4) {
						try {
							int id = Integer.parseInt(partes[0].trim());
							String nome = partes[1].trim();
							int parteInteira = Integer.parseInt(partes[2].trim());
							int parteDecimal = Integer.parseInt(partes[3].trim());
							list.append(id, nome, parteInteira, parteDecimal); // append from LinkedListOriginal
						} catch (NumberFormatException e) {
							System.err.println("Erro ao converter número na linha: " + linha + " -> " + e.getMessage());
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo dados.txt não encontrado: " + e.getMessage());
			System.err.println("Certifique-se de que 'dados.txt' está na raiz do projeto e o 'Working directory' está configurado corretamente no IntelliJ.");
		} catch (IOException e) {
			System.err.println("Erro de I/O ao ler dados.txt: " + e.getMessage());
		}


		System.out.println(">>>>>>>>>> Dados originais (sistema legado) >>>>>>>>>>");
		System.out.println(list); // Uses LinkedListOriginal.toString()
		System.out.println("<<<<<<<<<< Dados originais (sistema legado) <<<<<<<<<<\n");

		DLinkedList fixedList = Operation.map(list);
		System.out.println(">>>>>>>>>> Dados convertidos para a nova representação dos dados >>>>>>>>>>");
		System.out.println(fixedList); // Uses DLinkedList.toString() from user's file
		System.out.println("<<<<<<<<<< Dados convertidos para a nova representação dos dados <<<<<<<<<<\n");

		DLinkedList filteredGradedList = Operation.filterRemoveNonGraded(fixedList);
		System.out.println(">>>>>>>>>> Lista filtrada (somente notas válidas) >>>>>>>>>>");
		System.out.println(filteredGradedList);
		System.out.println("<<<<<<<<<< Lista filtrada (somente notas válidas) <<<<<<<<<<\n");

		DLinkedList filteredNonGradedList = Operation.filterRemoveGraded(fixedList);
		System.out.println(">>>>>>>>>> Lista filtrada (somente 'ausência de nota') >>>>>>>>>>");
		System.out.println(filteredNonGradedList);
		System.out.println("<<<<<<<<<< Lista filtrada (somente 'ausência de nota') <<<<<<<<<<\n");

		float average = Operation.reduce(filteredGradedList);
		System.out.println(">>>>>>>>>> Média das notas válidas >>>>>>>>>>");
		System.out.println(average);
		System.out.println("<<<<<<<<<< Média das notas válidas <<<<<<<<<<\n");

		DLinkedList aboveAverageList = Operation.filterRemoveBelowAverage(filteredGradedList, average);
		System.out.println(">>>>>>>>>> Lista com notas acima da média >>>>>>>>>>");
		System.out.println(aboveAverageList);
		System.out.println("<<<<<<<<<< Lista com notas acima da média <<<<<<<<<<\n");

		String contents = Operation.mapToString(fixedList);
		System.out.println(">>>>>>>>>> Lista mapeada para uma única string >>>>>>>>>>");
		System.out.println(contents);
		System.out.println("<<<<<<<<<< Lista mapeada para uma única string <<<<<<<<<<\n");


		//Salvar o conteúdo da String contents em um arquivo chamado "dados.csv".
		try {
			Data.saveStringToTextFile("dados.csv", contents);
			System.out.println("Arquivo dados.csv salvo com sucesso.");
		} catch (FileNotFoundException e) {
			System.err.println("Erro ao criar/salvar dados.csv (arquivo não encontrado): " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro de I/O ao salvar dados.csv: " + e.getMessage());
		}

		String currentYearPrefix = "25" + ".S1-";

		Node test1 = fixedList.getNode(currentYearPrefix + "999");
		System.out.println(">>>>>>>>>> test1 >>>>>>>>>>\n" + test1 + "\n<<<<<<<<<< test1 <<<<<<<<<<\n");

		Node test2 = fixedList.removeNode(currentYearPrefix + "999");
		System.out.println(">>>>>>>>>> test2 >>>>>>>>>>\n" + test2 + "\n<<<<<<<<<< test2 <<<<<<<<<<\n");

		Node test3 = fixedList.getNode(currentYearPrefix + "999");
		System.out.println(">>>>>>>>>> test3 >>>>>>>>>>\n" + test3 + "\n<<<<<<<<<< test3 <<<<<<<<<<\n");

		aboveAverageList.clear();
		System.out.println(">>>>>>>>>> aboveAverageList.clear() >>>>>>>>>>\n" + aboveAverageList + "\n<<<<<<<<<< aboveAverageList.clear() <<<<<<<<<<\n");

		DLinkedList testList = new DLinkedList();


		//Inserir um nó no início da lista testList com os dados ("ABC", "John Doe", 4.7f).
		testList.insert("ABC", "John Doe", 4.7f);

		//Inserir um nó no final da lista testList com os dados ("XYZ", "Jane Doe", 9.9f).
		testList.append("XYZ", "Jane Doe", 9.9f);

		//Inserir um nó no início da lista testList com os dados ("321", "Test", 2.3f).
		testList.insert("321", "Test", 2.3f);

		//Inserir um nó no final da lista testList com os dados ("Nothing", "Yada yada yada", 99.9f).
		testList.append("Nothing", "Yada yada yada", 99.9f);


		System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
		System.out.println("testList.getHead(): " + testList.getHead());
		System.out.println("testList.getTail(): " + testList.getTail());
		System.out.println("testList.removeHead(): " + testList.removeHead());
		System.out.println("testList.removeTail(): " + testList.removeTail() + "\n");
		System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
		System.out.println("testList.getHead(): " + testList.getHead());
		System.out.println("testList.getTail(): " + testList.getTail());
		System.out.println("testList.removeNode(\"ABC\"): " + testList.removeNode("ABC") + "\n");
		System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
		System.out.println("testList.getHead(): " + testList.getHead());
		System.out.println("testList.getTail(): " + testList.getTail() + "\n");


		//Inserir um nó no início da lista testList com os dados ("qwerty", "QWERTY", 1.2f).
		testList.insert("qwerty", "QWERTY", 1.2f);

		//Inserir um nó no final da lista testList com os dados ("WASD", "wasd", 3.4f).
		testList.append("WASD", "wasd", 3.4f);

		//Inserir um nó no início da lista testList com os dados ("ijkl", "IJKL", 5.6f).
		testList.insert("ijkl", "IJKL", 5.6f);

		//Inserir um nó no final da lista testList com os dados ("1234", "Um Dois Tres Quatro", 7.8f).
		testList.append("1234", "Um Dois Tres Quatro", 7.8f);


		System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
		testList.clear();
		System.out.println(">>>>>>>>>> testList.clear() >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList.clear() <<<<<<<<<<\n");
	}
}
