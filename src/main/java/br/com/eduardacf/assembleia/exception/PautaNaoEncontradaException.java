package br.com.eduardacf.assembleia.exception;


public class PautaNaoEncontradaException extends RuntimeException {


    public PautaNaoEncontradaException(String idPauta) {
        super("Pauta com ID: " + idPauta + " não encontrada.");
    }

}
