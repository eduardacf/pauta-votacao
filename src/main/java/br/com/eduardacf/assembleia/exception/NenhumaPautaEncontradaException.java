package br.com.eduardacf.assembleia.exception;


public class NenhumaPautaEncontradaException extends RuntimeException {


    public NenhumaPautaEncontradaException() {
        super("Nenhuma pauta foi encontrada.");
    }

}
