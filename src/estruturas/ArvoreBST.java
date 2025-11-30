package estruturas;

public class ArvoreBST {
    protected No raiz;

    protected class No {
        int valor;
        No esquerda, direita;
        int altura;

        public No(int valor) {
            this.valor = valor;
            this.esquerda = null;
            this.direita = null;
            this.altura = 1;
        }
    }

    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    protected No inserirRecursivo(No no, int valor) {
        if (no == null) {
            return new No(valor);
        }
        if (valor < no.valor) {
            no.esquerda = inserirRecursivo(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserirRecursivo(no.direita, valor);
        }
        return no;
    }

    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(No no, int valor) {
        if (no == null) return false;
        if (valor == no.valor) return true;
        
        if (valor < no.valor) return buscarRecursivo(no.esquerda, valor);
        else return buscarRecursivo(no.direita, valor);
    }
}