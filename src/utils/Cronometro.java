package utils;

public class Cronometro {
    private long inicio;

    public void iniciar() {
        this.inicio = System.nanoTime();
    }

    public long parar() {
        return System.nanoTime() - this.inicio;
    }
    
    // Converte nanosegundos para milissegundos para facilitar leitura
    public double paraMilissegundos(long tempoNano) {
        return tempoNano / 1_000_000.0;
    }
}