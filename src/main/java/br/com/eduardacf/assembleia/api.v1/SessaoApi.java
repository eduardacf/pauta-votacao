package br.com.eduardacf.assembleia.api.v1;

import br.com.eduardacf.assembleia.api.v1.response.SessaoResponse;
import br.com.eduardacf.assembleia.service.SessaoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/sessoes")
public class SessaoApi {

    private final Logger logger = LoggerFactory.getLogger(SessaoApi.class);

    private final SessaoService sessaoService;
    private final ObjectMapper objectMapper;

    public SessaoApi(SessaoService sessaoService, ObjectMapper objectMapper) {
        this.sessaoService = sessaoService;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/{idPauta}/abrir-sessao")
    @ApiOperation(value = "Abrir uma sessão para votação.", response = SessaoResponse.class)
    public Mono<SessaoResponse> abrirSessao(
            @ApiParam(value = "ID para pauta para qual deseja abrir a sessão {pauta tem que ser existente}", required = true)
            @PathVariable("idPauta") String idPauta,
            @ApiParam(value = "Duração da sessão em minutos (opcional), caso não informado o padrão será de 1 minuto", defaultValue = "1", required = true)
            @RequestParam(defaultValue = "1") String duracaoEmMinutos) {
        logger.info("Iniciando chamada para abertura de sessão da pauta {} com duração de {} minutos", idPauta, duracaoEmMinutos);
        return sessaoService.abrirSessaoVotacao(idPauta, duracaoEmMinutos)
                .map(sessao -> objectMapper.convertValue(sessao, SessaoResponse.class))
                .doOnSuccess(sessao -> logger.info("Finalizando chamada para abertura de sessão da pauta {} com duração de {} minutos", idPauta, duracaoEmMinutos));
    }

    @GetMapping
    @ApiOperation(value = "Retorna uma lista com todas as sessões {Abertas e Fechadas}.", response = SessaoResponse.class)
    public Flux<SessaoResponse> buscarTodasSessoes() {
        logger.info("Iniciando chamada para listagem de todas as sessões.");
        return sessaoService.buscaTodasSessoes()
                .map(sessao -> objectMapper.convertValue(sessao, SessaoResponse.class))
                .doOnComplete(() -> logger.info("Finalizando chamada para listagem de todas as sessões"));
    }

    @GetMapping("/{idPauta}")
    @ApiOperation(value = "Retorna uma sessão especifica conforme id da pauta informado.", response = SessaoResponse.class)
    public Mono<SessaoResponse> retornarPauta(@PathVariable("idPauta") String idPauta) {
        logger.info("Iniciando chamada para listagem de sessão com id de pauta {}", idPauta);
        return sessaoService.buscarSessaoPorId(idPauta)
                .map(sessao -> objectMapper.convertValue(sessao, SessaoResponse.class))
                .doOnSuccess(o -> logger.info("Finalizando chamada para listagem de sessão com id de pauta {}", idPauta));
    }

    @GetMapping("/{idPauta}/resultado")
    @ApiOperation(value = "Resultado da votação", response = SessaoResponse.class)
    public Mono<SessaoResponse> retornarResultadoVotacao(@PathVariable String idPauta) {
        logger.info("Iniciando chamada para resultado da Votação. Código da pauta [{}]", idPauta);
        return sessaoService.resultadoVotacao(idPauta)
                .map(sessao -> objectMapper.convertValue(sessao, SessaoResponse.class))
                .doOnSuccess(x -> logger.info("Finalizando chamada para resultado da Votação. Código da pauta [{}]", idPauta));
    }
}
