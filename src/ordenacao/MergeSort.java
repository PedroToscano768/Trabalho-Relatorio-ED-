package ordenacao;

public class MergeSort {
    public void ordenar(int[] vetor) {
        if (vetor.length < 2) return;
        dividir(vetor, 0, vetor.length - 1);
    }

    private void dividir(int[] vetor, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;
            dividir(vetor, esquerda, meio);
            dividir(vetor, meio + 1, direita);
            intercalar(vetor, esquerda, meio, direita);
        }
    }

    private void intercalar(int[] vetor, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) L[i] = vetor[esquerda + i];
        for (int j = 0; j < n2; ++j) R[j] = vetor[meio + 1 + j];

        int i = 0, j = 0;
        int k = esquerda;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                vetor[k] = L[i];
                i++;
            } else {
                vetor[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            vetor[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            vetor[k] = R[j];
            j++;
            k++;
        }
    }
}