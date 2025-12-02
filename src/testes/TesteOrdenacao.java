package testes;

import ordenacao.BubbleSort;
import ordenacao.MergeSort;
import utils.Cronometro;

public class TesteOrdenacao {
    public void executarTeste(int[] dados, String tipo) {
        Cronometro cronometro = new Cronometro();
        BubbleSort bubble = new BubbleSort();
        MergeSort merge = new MergeSort();

        // Clona array para não afetar o teste seguinte
        int[] d1 = dados.clone(); 
        int[] d2 = dados.clone();

        cronometro.iniciar();
        bubble.ordenar(d1);
        double tBubble = cronometro.paraMilissegundos(cronometro.parar());

        cronometro.iniciar();
        merge.ordenar(d2);
        double tMerge = cronometro.paraMilissegundos(cronometro.parar());

        System.out.printf("Ordenação (%s): Bubble: %.4f ms | Merge: %.4f ms%n", tipo, tBubble, tMerge);
    }
}