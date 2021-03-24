package br.com.eduardacf.assembleia.api.v1;

import br.com.eduardacf.assembleia.api.v1.request.PautaRequest;
import br.com.eduardacf.assembleia.api.v1.response.PautaResponse;
import br.com.eduardacf.assembleia.dto.Pauta;
import br.com.eduardacf.assembleia.mapper.PautaResponseMapper;
import br.com.eduardacf.assembleia.service.PautaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/pautas")
public class PautaApi {

    private final Logger logger = LoggerFactory.getLogger(PautaApi.class);

    private final PautaService pautaService;
    private final ObjectMapper objectMapper;

    public PautaApi(PautaService pautaService, ObjectMapper objectMapper) {
        this.pautaService = pautaService;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cria uma nova pauta.", response = PautaResponse.class)
    public Mono<PautaResponse> criaPauta(@RequestBody @Valid PautaRequest pautaRequest) {
        logger.info("Iniciando chamada para criação de nova pauta: {}.", pautaRequest);
        return pautaService.criarPauta(objectMapper.convertValue(pautaRequest, Pauta.class))
                .map(pautaEntity -> objectMapper.convertValue(pautaEntity, PautaResponse.class))
                .doOnSuccess(pautaResponse -> logger.info("Finalizando chamada de criação de nova pauta, criada com sucesso: {};", pautaResponse));
    }

    @GetMapping
    @ApiOperation(value = "Retorna uma lista com todas as pautas.", response = PautaResponse.class)
    public Flux<PautaResponse> retornarTodasPautas() {
        logger.info("Iniciando chamada para listagem de todas as pautas.");
        return pautaService.buscarTodasPautas()
                .map(pautaEntity -> objectMapper.convertValue(pautaEntity, PautaResponse.class))
                .doOnComplete(() -> logger.info("Finalizando chamada de listagem de todas as pautas."));
    }

    @GetMapping("/{idPauta}")
    @ApiOperation(value = "Retorna uma pauta especifa conforme id informado.", response = PautaResponse.class)
    public Mono<PautaResponse> retornarPauta(@PathVariable("idPauta") String idPauta) {
        logger.info("Iniciando chamada para listagem da pauta com id {}", idPauta);
        return pautaService.buscarPautaPorId(idPauta)
                .map(PautaResponseMapper::mapResponsePauta)
                .doOnSuccess(pautaResponse -> logger.info("Finalizando chamada de listagem da pauta {}", pautaResponse));

    }
}
