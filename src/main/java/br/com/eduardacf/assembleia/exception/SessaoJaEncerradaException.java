package br.com.eduardacf.assembleia.exception;


public class SessaoJaEncerradaException extends RuntimeException {


    public SessaoJaEncerradaException() {
        super("Esta sessão já está encerrada.");
    }

}
