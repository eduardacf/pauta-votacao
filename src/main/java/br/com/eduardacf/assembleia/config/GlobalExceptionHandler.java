package br.com.eduardacf.assembleia.config;

import br.com.eduardacf.assembleia.exception.NenhumaPautaEncontradaException;
import br.com.eduardacf.assembleia.exception.PautaNaoEncontradaException;
import br.com.eduardacf.assembleia.exception.PessoaJaVotouException;
import br.com.eduardacf.assembleia.exception.SessaoComPautaExistenteException;
import br.com.eduardacf.assembleia.exception.SessaoJaEncerradaException;
import br.com.eduardacf.assembleia.exception.SessaoNaoEncontradaException;
import br.com.eduardacf.assembleia.exception.SessoesInexistentesException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler
    public ResponseEntity handleException(final PautaNaoEncontradaException exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity handleException(final SessaoComPautaExistenteException exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity handleException(final SessaoNaoEncontradaException exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity handleException(final SessoesInexistentesException exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity handleException(final SessaoJaEncerradaException exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity handleException(final PessoaJaVotouException exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity handleException(final NenhumaPautaEncontradaException exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}