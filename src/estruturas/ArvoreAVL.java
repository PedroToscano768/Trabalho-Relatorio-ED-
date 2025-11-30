package estruturas;

public class ArvoreAVL extends ArvoreBST {

    @Override
    public void inserir(int valor) {
        raiz = inserirAVL(raiz, valor);
    }

    private No inserirAVL(No no, int valor) {
        //Inserção normal de BST
        if (no == null) return new No(valor);

        if (valor < no.valor)
            no.esquerda = inserirAVL(no.esquerda, valor);
        else if (valor > no.valor)
            no.direita = inserirAVL(no.direita, valor);
        else
            return no;

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

        //fator de balanceamento
        int balanceamento = getFatorBalanceamento(no);

        // Esquerda-Esquerda (Rotação à Direita)
        if (balanceamento > 1 && valor < no.esquerda.valor)
            return rotacaoDireita(no);

        // Direita-Direita (Rotação à Esquerda)
        if (balanceamento < -1 && valor > no.direita.valor)
            return rotacaoEsquerda(no);

        // Esquerda-Direita (Rotação Esquerda-Direita)
        if (balanceamento > 1 && valor > no.esquerda.valor) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        // Direita-Esquerda (Rotação Direita-Esquerda)
        if (balanceamento < -1 && valor < no.direita.valor) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    private int altura(No N) {
        if (N == null) return 0;
        return N.altura;
    }

    private int getFatorBalanceamento(No N) {
        if (N == null) return 0;
        return altura(N.esquerda) - altura(N.direita);
    }

    private No rotacaoDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private No rotacaoEsquerda(No x) {
        No y = x.direita;
        No T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }
}