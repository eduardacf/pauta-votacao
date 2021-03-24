package br.com.eduardacf.assembleia.exception;


public class SessoesInexistentesException extends RuntimeException {


    public SessoesInexistentesException() {
        super("Não há sessões para listar.");
    }

}
