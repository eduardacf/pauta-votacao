package br.com.eduardacf.assembleia.service;

import br.com.eduardacf.assembleia.dto.Sessao;
import br.com.eduardacf.assembleia.dto.Voto;
import br.com.eduardacf.assembleia.entity.SessaoEntity;
import br.com.eduardacf.assembleia.exception.PessoaJaVotouException;
import br.com.eduardacf.assembleia.exception.SessaoComPautaExistenteException;
import br.com.eduardacf.assembleia.exception.SessaoJaEncerradaException;
import br.com.eduardacf.assembleia.exception.SessaoNaoEncontradaException;
import br.com.eduardacf.assembleia.exception.SessoesInexistentesException;
import br.com.eduardacf.assembleia.repository.SessaoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Objects;

import static br.com.eduardacf.assembleia.mapper.SessaoEntityMapper.mapSessaoEntity;


@Service
public class SessaoService {

    private final SessaoRepository sessaoRepository;
    private final PautaService pautaService;
    private final ObjectMapper objectMapper;


    public SessaoService(SessaoRepository sessaoRepository, PautaService pautaService, ObjectMapper objectMapper) {
        this.sessaoRepository = sessaoRepository;
        this.pautaService = pautaService;
        this.objectMapper = objectMapper;
    }

    public Mono<Sessao> abrirSessaoVotacao(String idPauta, String duracaoEmMinutos) {
        return pautaService.buscarPautaPorId(idPauta)
                .flatMap(pauta -> buscarSessoesPorPauta(idPauta))
                .flatMap(sessaoMono -> sessaoRepository.save(mapSessaoEntity(idPauta, duracaoEmMinutos)))
                .map(pautaEntity -> objectMapper.convertValue(pautaEntity, Sessao.class));
    }

    public Flux<Sessao> buscaTodasSessoes() {
        return sessaoRepository.findAll()
                .switchIfEmpty(Mono.error(new SessoesInexistentesException()))
                .map(sessoes -> objectMapper.convertValue(sessoes, Sessao.class));
    }

    public Mono<Boolean> buscarSessoesPorPauta(String idPauta) {
        return sessaoRepository.findByIdPauta(idPauta)
                .hasElement()
                .filter(aBoolean -> !aBoolean)
                .switchIfEmpty(Mono.error(new SessaoComPautaExistenteException(idPauta)));
    }

    public Mono<Sessao> buscarSessaoPorId(String idPauta) {
        return sessaoRepository.findByIdPauta(idPauta)
                .switchIfEmpty(Mono.error(new SessaoNaoEncontradaException(idPauta)))
                .map(sessaoEntity -> objectMapper.convertValue(sessaoEntity, Sessao.class));
    }

    public Mono<Sessao> isSessaoExiste(String idPauta) {
        return buscarSessaoPorId(idPauta).filter(this::isSessaoAberta).switchIfEmpty(Mono.error(new SessaoJaEncerradaException()));
    }

    private boolean isSessaoAberta(Sessao sessao) {
        return sessao.getFimSessao().isAfter(LocalDateTime.now());
    }

    public Mono<Sessao> resultadoVotacao(String electionCode) {
        return sessaoRepository.findByIdPauta(electionCode)
                .switchIfEmpty(Mono.error(new SessaoNaoEncontradaException(electionCode)))
                .map(sessaoEntity -> objectMapper.convertValue(sessaoEntity, Sessao.class));

    }
}
