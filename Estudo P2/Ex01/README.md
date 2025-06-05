# EXERCÍCIOS PARA PRÁTICA DA TEORIA:

## Exercício - Gerenciador de Playlist com Lista Duplamente Ligada

Você foi contratado para desenvolver um **Gerenciador de Playlist de Músicas.**
Cada música da playlist possui as seguintes informações:
- Título (String)
- Artista (String)
- Duração (em segundos) (int)

A playlist deve ser implementada utilizando uma **Lista duplamente ligada**,
permitindo as seguintes operações:
1. Adicionar uma música no final da playlist.
2. Remover uma música pelo título.
3. Exibir todas as músicas na ordem atual da playlist.
4. Exibir todas as músicas na ordem inversa da playlist.
5. Buscar uma música pelo título e exibir suas informações.
6. Avançar para a próxima música ou retroceder para a anterior a partir de uma
música atual.

Implemente: 
- A classe **Musica**, que representa uma música com os atributos mencionados.
- A classe **NoDuplo**, que representa o nó da lista (contendo a música, refêrencia para o próximo e o anterior).
- A classe **Playlist**, com os métodos para realizar as operações descritas.