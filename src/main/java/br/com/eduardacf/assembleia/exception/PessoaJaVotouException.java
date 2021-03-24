package br.com.eduardacf.assembleia.exception;


public class PessoaJaVotouException extends RuntimeException {


    public PessoaJaVotouException() {
        super("Pessoa já realizou o voto. Só é permitido um voto por sessão.");
    }

}
