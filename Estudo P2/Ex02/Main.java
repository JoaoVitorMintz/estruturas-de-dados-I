public class Main {
    public static void main(String[] args) {
        Deque editor = new Deque(3);
        
        System.out.println("=== TESTE EDITOR DE TEXTO ===");
        
        // Inserindo ações
        editor.inserir("Digitar 'Olá'");
        editor.inserir("Adicionar negrito");
        editor.inserir("Inserir imagem");
        
        System.out.println("Última ação: " + editor.verUltimaAcao());
        
        // Desfazendo
        String desfeito = editor.desfazer();
        System.out.println("Desfeito: " + desfeito);
        System.out.println("Última ação agora: " + editor.verUltimaAcao());
        
        // Refazendo
        String refeito = editor.refazer();
        System.out.println("Refeito: " + refeito);
        System.out.println("Última ação agora: " + editor.verUltimaAcao());
        
        // Inserindo nova ação (deve resetar o refazer)
        editor.inserir("Alterar fonte");
        System.out.println("\nApós nova ação:");
        System.out.println("Tentando refazer:");
        editor.refazer(); // Deve mostrar "Nada para refazer!"
    }
}