package estruturas;

public class Vetor {
    private int[] elementos;
    private int tamanho;

    public Vetor(int capacidadeInicial) {
        this.elementos = new int[capacidadeInicial];
        this.tamanho = 0;
    }

    public void inserir(int valor) {
        if (this.tamanho == this.elementos.length) {
            aumentarCapacidade();
        }
        this.elementos[this.tamanho] = valor;
        this.tamanho++;
    }

    // Busca sequencial simples para uso interno se necessário
    public int buscar(int valor) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i] == valor) {
                return i;
            }
        }
        return -1;
    }
    
    // Método para acessar elemento por índice
    public int get(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new RuntimeException("Índice fora dos limites");
        }
        return this.elementos[indice];
    }
    
    public int size() {
        return this.tamanho;
    }
    
    public int[] getArrayInterno() {
        int[] copia = new int[this.tamanho];
        for(int i=0; i<this.tamanho; i++) {
            copia[i] = this.elementos[i];
        }
        return copia;
    }

    private void aumentarCapacidade() {
        int[] novosElementos = new int[this.elementos.length * 2];
        for (int i = 0; i < this.elementos.length; i++) {
            novosElementos[i] = this.elementos[i];
        }
        this.elementos = novosElementos;
    }
}