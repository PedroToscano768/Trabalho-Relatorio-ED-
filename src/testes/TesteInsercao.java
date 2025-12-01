package testes;

import estruturas.ArvoreAVL;
import estruturas.ArvoreBST;
import estruturas.Vetor;
import utils.Cronometro;

public class TesteInsercao {
    public void executarTeste(int[] dados, String descricao) {
        Cronometro cronometro = new Cronometro();
        
        // 1. Teste Vetor
        Vetor vetor = new Vetor(dados.length);
        cronometro.iniciar();
        for (int v : dados) vetor.inserir(v);
        long tempoVetor = cronometro.parar();

        // 2. Teste BST
        ArvoreBST bst = new ArvoreBST();
        cronometro.iniciar();
        for (int v : dados) bst.inserir(v);
        long tempoBST = cronometro.parar();

        // 3. Teste AVL
        ArvoreAVL avl = new ArvoreAVL();
        cronometro.iniciar();
        for (int v : dados) avl.inserir(v);
        long tempoAVL = cronometro.parar();

        System.out.printf("%-20s | Vetor: %.4f ms | BST: %.4f ms | AVL: %.4f ms%n", 
            descricao, 
            cronometro.paraMilissegundos(tempoVetor), 
            cronometro.paraMilissegundos(tempoBST), 
            cronometro.paraMilissegundos(tempoAVL));
    }
}