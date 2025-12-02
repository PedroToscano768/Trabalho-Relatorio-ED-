package testes;

import estruturas.ArvoreAVL;
import estruturas.ArvoreBST;
import estruturas.Vetor;
import utils.Cronometro;

public class TesteBusca {
    public void executarTeste(int[] dados, int alvo) {
        Cronometro cronometro = new Cronometro();

        // Popula estruturas
        Vetor vetor = new Vetor(dados.length);
        ArvoreBST bst = new ArvoreBST();
        ArvoreAVL avl = new ArvoreAVL();
        
        for (int v : dados) {
            vetor.inserir(v);
            bst.inserir(v);
            avl.inserir(v);
        }

        // Mede Busca
        cronometro.iniciar();
        vetor.buscar(alvo);
        double tVetor = cronometro.paraMilissegundos(cronometro.parar());

        cronometro.iniciar();
        bst.buscar(alvo);
        double tBST = cronometro.paraMilissegundos(cronometro.parar());

        cronometro.iniciar();
        avl.buscar(alvo);
        double tAVL = cronometro.paraMilissegundos(cronometro.parar());

        System.out.printf("Busca pelo valor %d: Vetor: %.4f ms | BST: %.4f ms | AVL: %.4f ms%n", alvo, tVetor, tBST, tAVL);
    }
}