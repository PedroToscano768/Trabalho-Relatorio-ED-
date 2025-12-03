import utils.GeradorDados;
import testes.TesteInsercao;
import testes.TesteOrdenacao;

public class Main {
    public static void main(String[] args) {
        GeradorDados gerador = new GeradorDados();
        TesteInsercao testeInsercao = new TesteInsercao();
        TesteOrdenacao testeOrdenacao = new TesteOrdenacao();

        int[] tamanhos = {100, 1000, 10000};
        
        System.out.println("=== INÍCIO DA ANÁLISE DE DESEMPENHO ===\n");

        for (int tam : tamanhos) {
            System.out.println("--- Tamanho do Conjunto: " + tam + " ---");
            
            // Gerar dados
            int[] ordenado = gerador.gerarOrdenado(tam);
            int[] inverso = gerador.gerarInversamenteOrdenado(tam);
            int[] aleatorio = gerador.gerarAleatorio(tam);

            // 1. Testes de Inserção
            System.out.println("\n[Inserção]");
            testeInsercao.executarTeste(ordenado, "Ordenado " + tam);
            testeInsercao.executarTeste(inverso, "Inverso " + tam);
            testeInsercao.executarTeste(aleatorio, "Aleatório " + tam);

            // 2. Testes de Ordenação (Apenas Vetores)
            System.out.println("\n[Ordenação]");
            testeOrdenacao.executarTeste(ordenado, "Ordenado");
            testeOrdenacao.executarTeste(inverso, "Inverso");
            testeOrdenacao.executarTeste(aleatorio, "Aleatório");
            
            System.out.println("----------------------------------------\n");
        }
    }
}