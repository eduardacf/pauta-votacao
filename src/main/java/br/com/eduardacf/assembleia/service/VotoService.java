package br.com.eduardacf.assembleia.service;

import br.com.eduardacf.assembleia.dto.Voto;
import br.com.eduardacf.assembleia.entity.SessaoEntity;
import br.com.eduardacf.assembleia.exception.PessoaJaVotouException;
import br.com.eduardacf.assembleia.mapper.VotoEntityMapper;
import br.com.eduardacf.assembleia.repository.SessaoRepository;
import br.com.eduardacf.assembleia.repository.VotoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class VotoService {
    private final ObjectMapper objectMapper;
    private SessaoService sessaoService;
    private SessaoRepository sessaoRepository;
    private VotoRepository votoRepository;


    public VotoService(ObjectMapper objectMapper, SessaoService sessaoService, SessaoRepository sessaoRepository, VotoRepository votoRepository) {
        this.objectMapper = objectMapper;
        this.sessaoService = sessaoService;
        this.sessaoRepository = sessaoRepository;
        this.votoRepository = votoRepository;
    }

    public Mono<Void> verificaSessaoExisteSalvarVoto(String idPauta, Voto voto) {
        Mono<SessaoEntity> map = sessaoService.isSessaoExiste(idPauta).map(sessaoEntity -> objectMapper.convertValue(sessaoEntity, SessaoEntity.class));
        Mono<String> cpfPessoa = Mono.just(voto.getCpfPessoa());
        return Mono.zip(
                cpfPessoa,
                map,
                verificarPessoaJaVotou(voto.getIdPauta(), voto))
                .map(sessao -> {
                    sessao.getT2().addVoto(voto.getVoto().getCode());
                    sessaoRepository.save(sessao.getT2()).subscribe();
                    return sessao;
                }).then();
    }

    public Mono<Voto> votar(String idPauta, Voto voto) {
        return verificaSessaoExisteSalvarVoto(idPauta, voto)
                .flatMap(sessaoExiste -> votoRepository.save(VotoEntityMapper.buildVotoEntity(idPauta, voto)))
                .map(votoEntity -> objectMapper.convertValue(votoEntity, Voto.class));
    }

    public Mono<Boolean> verificarPessoaJaVotou(String idPauta, Voto voto) {
        return votoRepository.findByIdPautaAndCpfPessoa(idPauta, voto.getCpfPessoa())
                .hasElement()
                .filter(aBoolean -> !aBoolean)
                .switchIfEmpty(Mono.error(new PessoaJaVotouException()));
    }
}



