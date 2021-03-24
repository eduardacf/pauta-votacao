package br.com.eduardacf.assembleia.service;

import br.com.eduardacf.assembleia.dto.Pauta;
import br.com.eduardacf.assembleia.entity.PautaEntity;
import br.com.eduardacf.assembleia.exception.NenhumaPautaEncontradaException;
import br.com.eduardacf.assembleia.exception.PautaNaoEncontradaException;
import br.com.eduardacf.assembleia.repository.PautaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class PautaService {

    private final PautaRepository pautaRepository;
    private final ObjectMapper objectMapper;


    public PautaService(PautaRepository pautaRepository, ObjectMapper objectMapper) {
        this.pautaRepository = pautaRepository;
        this.objectMapper = objectMapper;
    }

    public Mono<Pauta> buscarPautaPorId(String idPauta) {
        return pautaRepository.findById(idPauta)
                .switchIfEmpty(Mono.error(new PautaNaoEncontradaException(idPauta)))
                .map(pautaEntity -> objectMapper.convertValue(pautaEntity, Pauta.class));
    }

    public Flux<Pauta> buscarTodasPautas() {
        return pautaRepository.findAll()
                .map(pautaEntity -> objectMapper.convertValue(pautaEntity, Pauta.class))
                .switchIfEmpty(Mono.error(new NenhumaPautaEncontradaException()));

    }

    public Mono<Pauta> criarPauta(Pauta pautaDto) {
        return pautaRepository.save(objectMapper.convertValue(pautaDto, PautaEntity.class))
                .map(pautaEntity -> objectMapper.convertValue(pautaEntity, Pauta.class));
    }
}
