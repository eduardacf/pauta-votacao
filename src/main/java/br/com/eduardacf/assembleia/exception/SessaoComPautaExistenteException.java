package br.com.eduardacf.assembleia.exception;


public class SessaoComPautaExistenteException extends RuntimeException {


    public SessaoComPautaExistenteException(String idPauta) {
        super("Pauta com ID: " + idPauta + " já está com uma sessão aberta.");
    }

}
