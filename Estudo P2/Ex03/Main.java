public class Main {
    public static void main(String[] args) {
        // Cria o deque com capacidade para 5 páginas
        Deque historico = new Deque(5);
        Deque avancos = new Deque(5); // Para armazenar páginas para avançar
        
        System.out.println("=== SIMULADOR DE NAVEGADOR ===");
        
        // Visitar páginas
        System.out.println("\nVisitando paginas:");
        visitarPagina(historico, avancos, "A");
        visitarPagina(historico, avancos, "B");
        visitarPagina(historico, avancos, "C");
        
        imprimirEstado(historico, avancos);
        
        // Voltar uma página
        System.out.println("\nVoltando uma pagina:");
        voltarPagina(historico, avancos);
        imprimirEstado(historico, avancos);
        
        // Visitar nova página (deve substituir o avanço)
        System.out.println("\nVisitando nova pagina D:");
        visitarPagina(historico, avancos, "D");
        imprimirEstado(historico, avancos);
        
        // Testar voltar e avançar
        System.out.println("\nVoltando para A:");
        voltarPagina(historico, avancos); // Volta para B
        voltarPagina(historico, avancos); // Volta para A
        imprimirEstado(historico, avancos);
        
        System.out.println("\nAvançando para B e D:");
        avancarPagina(historico, avancos); // Avança para B
        avancarPagina(historico, avancos); // Avança para D
        imprimirEstado(historico, avancos);
    }
    
    // Métodos auxiliares para simular o navegador
    public static void visitarPagina(Deque historico, Deque avancos, String pagina) {
        historico.inserirTras(pagina);
        // Limpa o histórico de avanços quando visita nova página
        while (!avancos.vazio()) {
            avancos.removerFrente();
        }
        System.out.println("Visitando: " + pagina);
    }
    
    public static void voltarPagina(Deque historico, Deque avancos) {
        if (historico.tamanho() <= 1) {
            System.out.println("Não há páginas anteriores para voltar.");
            return;
        }
        String atual = historico.removerTras();
        avancos.inserirFrente(atual);
        System.out.println("Voltando para: " + historico.tras());
    }
    
    public static void avancarPagina(Deque historico, Deque avancos) {
        if (avancos.vazio()) {
            System.out.println("Não há páginas para avançar.");
            return;
        }
        String proxima = avancos.removerFrente();
        historico.inserirTras(proxima);
        System.out.println("Avançando para: " + proxima);
    }
    
    public static void imprimirEstado(Deque historico, Deque avancos) {
        System.out.println("\nEstado atual:");
        System.out.println("Histórico: " + historico.toString());
        System.out.println("Página atual: " + (historico.vazio() ? "Nenhuma" : historico.tras()));
        System.out.println("Páginas para avançar: " + avancos.toString());
    }
}