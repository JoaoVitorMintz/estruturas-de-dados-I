//*************************** ATENÇÃO! *****************************
// As assinaturas dos métodos desta classe não devem ser alteradas!
//*************************** ATENÇÃO! *****************************
// arquivo: src/apl2/Operation.java

// Nome: Enzo Ferrari de Moura Sampaio         RA: 10440331
// Nome: Giovanni Barreiro Garitano de Castro  RA: 10435745
// Nome: João Vitor Garcia Aguiar Mintz        RA: 10440421
// Nome: Yan Andreotti dos Santos              RA: 10439766

package apl2;

public class Operation {

	/**
	 * <p>Recebe como parâmetro uma lista encadeada do tipo {@code LinkedListOriginal}, sendo que os nós da lista estão
	 * populados com o conteúdo da base de dados original (conteúdo do arquivo dados.txt).</p>
	 * <p>A operação {@code map()} deve mapear os dados originais para uma lista encadeada do tipo {@code DLinkedList} e
	 * retornar a referência da {@code DLinkedList} que possui os dados mapeados para a nova estrutura usada pelo sistema de notas.</p>
	 * 
	 * @param original Base de dados original carregada em uma {@code LinkedListOriginal}.
	 * @return Uma nova {@code DLinkedList} que contém o mapeamento da coleção de dados {@code original} para a nova estrutura usada pelo sistema de notas. 
	 */
	public static DLinkedList map(final LinkedListOriginal original) {
		DLinkedList newList = new DLinkedList();
		NodeOriginal currentOriginal = original.getHead();
		String yearPrefix = "25" + ".S1-";

		while (currentOriginal != null) {
			String originalIdStr = String.format("%03d", currentOriginal.getId());
			String newId = yearPrefix + originalIdStr;
			String nome = currentOriginal.getNome();
			float nota;

			int parteInteira = currentOriginal.getInteiro();
			int parteDecimal = currentOriginal.getDecimo();

			if (parteInteira == -1 || parteDecimal == -1) {
				nota = 99.9f;
			} else {
				nota = parteInteira + (float)parteDecimal / 10.0f;
			}
			// Usa o método append da DLinkedList fornecida
			newList.append(newId, nome, nota);
			currentOriginal = currentOriginal.getNext();
		}
		return newList;
	}

	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code map()}.</p>
	 * <p>A operação {@code filterRemoveNonGraded()} deve filtrar os nós que não possuem notas válidas (caso de "ausência de nota")
	 * e retornar uma nova lista do tipo {@code DLinkedList} contendo apenas os nós com notas válidas.</p>
	 * 
	 * @param data Base de dados mapeada para o formato {@code DLinkedList} (via operação {@code map()}).
	 * @return Uma nova {@code DLinkedList} que contém a coleção de dados ({@code data}) filtrada com nós que possuem apenas pessoas com notas válidas.
	 */
	public static DLinkedList filterRemoveNonGraded(final DLinkedList data) {
		DLinkedList filteredList = new DLinkedList();
		Node current = data.getHead();
		while (current != null) {
			if (current.getNota() != 99.9f) {
				filteredList.append(current.getID(), current.getNome(), current.getNota());
			}
			current = current.getNext();
		}
		return filteredList;
	}

	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code map()}.</p>
	 * <p>A operação {@code filterRemoveGraded()} deve filtrar os nós que possuem notas válidas e retornar uma nova lista do
	 * tipo {@code DLinkedList} contendo apenas os nós com notas inválidas (caso de "ausência de nota").</p>
	 * 
	 * @param data Base de dados mapeada para o formato {@code DLinkedList} (via operação {@code map()}).
	 * @return Uma nova {@code DLinkedList} que contém a coleção de dados ({@code data}) filtrada com nós que possuem apenas pessoas com notas inválidas.
	 */
	public static DLinkedList filterRemoveGraded(final DLinkedList data) {
		DLinkedList filteredList = new DLinkedList();
		Node current = data.getHead();
		while (current != null) {
			if (current.getNota() == 99.9f) {
				filteredList.append(current.getID(), current.getNome(), current.getNota());
			}
			current = current.getNext();
		}
		return filteredList;
	}

	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code filterRemoveNonGraded()}, e a média de notas válidas, calculadas com a
	 * operação {@code reduce()}.</p>
	 * <p>A operação {@code filterRemoveBelowAverage()} deve filtrar os nós que possuem notas abaixo da média e retornar uma
	 * nova lista do tipo {@code DLinkedList} contendo apenas os nós com notas acima da média.
	 * 
	 * @param data Base de dados filtrada com a operação {@code filterRemoveNonGraded()}.
	 * @param average Média de notas válidas calculada com a operação {@code reduce()}.
	 * @return Uma nova {@code DLinkedList} que contém a coleção de dados ({@code data}) filtrada somente com pessoas com notas maiores do que {@code average}.
	 */
	public static DLinkedList filterRemoveBelowAverage(final DLinkedList data, float average) {
		DLinkedList filteredList = new DLinkedList();
		Node current = data.getHead();
		while (current != null) {
			if (current.getNota() >= average) {
				filteredList.append(current.getID(), current.getNome(), current.getNota());
			}
			current = current.getNext();
		}
		return filteredList;
	}

	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code filterRemoveNonGraded()}.</p>
	 * <p>A operação {@code reduce()} deve calcular a média das notas contidas na coleção de dados passada como parâmetro e
	 * retornar a média calculada.
	 * 
	 * @param data Base de dados filtrada com a operação {@code filterRemoveNonGraded()}.
	 * @return Média das notas ({@code float}) contidas na coleção de dados ({@code data}).
	 */
	public static float reduce(final DLinkedList data) {
		if (data.isEmpty()) {
			return 0.0f;
		}
		
		float sum = 0.0f;
		int validCount = 0;
		Node current = data.getHead();
		while (current != null) {
			sum += current.getNota();
			validCount++;
			current = current.getNext();
		}
		return (validCount > 0) ? (sum / validCount) : 0.0f;
	}


	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code map()}.</p>
	 * <p>A operação {@code mapToString()} deve mapear todos os nós da coleção de dados passada como parâmetro para uma única
	 * {@code String}, sendo que cada dado de uma pessoa é separado por ponto-e-vírgula (;) e cada pessoa é separada por uma
	 * quebra de linha.</p>
	 * 
	 * @param data Base de dados mapeada para o formato {@code DLinkedList} (via operação {@code map()}).
	 * @return {@code String} com a coleção de dados separada por ponto-e-vírgula (dados de cada pessoa) e quebras de linha (cada pessoa).
	 */
	public static String mapToString(final DLinkedList data) {
		StringBuilder sb = new StringBuilder();
	    Node current = data.getHead();
	    while (current != null) {
	        sb.append(current.getID())
	          .append(";")
	          .append(current.getNome())
	          .append(";")
	          .append(String.format("%.1f", current.getNota()).replace(",", "."));
	        
	        if (current.getNext() != null) {
	            sb.append("\n"); // Só adiciona quebra de linha se não for o último nó.
	        }
	        current = current.getNext();
	    }
	    return sb.toString();
	}
}
