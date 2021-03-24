package br.com.eduardacf.assembleia.exception;


public class SessaoNaoEncontradaException extends RuntimeException {


    public SessaoNaoEncontradaException(String idPauta) {
        super("Sessão com ID de pauta: " + idPauta + " não encontrada.");
    }

}
