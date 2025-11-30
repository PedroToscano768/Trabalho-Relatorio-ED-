package utils;

public class GeradorDados {
    
    public int[] gerarOrdenado(int tamanho) {
        int[] dados = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            dados[i] = i;
        }
        return dados;
    }

    public int[] gerarInversamenteOrdenado(int tamanho) {
        int[] dados = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            dados[i] = tamanho - 1 - i;
        }
        return dados;
    }

    public int[] gerarAleatorio(int tamanho) {
        int[] dados = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            // Gera números entre 0 e tamanho*10 para espalhar um pouco os valores
            dados[i] = (int) (Math.random() * (tamanho * 10));
        }
        return dados;
    }
}