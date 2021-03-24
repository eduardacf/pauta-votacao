package br.com.eduardacf.assembleia.api.v1;

import br.com.eduardacf.assembleia.api.v1.request.VotoRequest;
import br.com.eduardacf.assembleia.api.v1.response.VotoResponse;
import br.com.eduardacf.assembleia.mapper.VotoRequestMapper;
import br.com.eduardacf.assembleia.service.VotoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/votos")
public class VotoApi {


    private final Logger logger = LoggerFactory.getLogger(SessaoApi.class);
    private VotoService votoService;
    private final ObjectMapper objectMapper;

    public VotoApi(VotoService votoService, ObjectMapper objectMapper) {
        this.votoService = votoService;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/{idPauta}/votar")
    @ApiOperation(value = "Votar em uma sessão selecionada conforme ID informado.")
    public Mono<VotoResponse> votar(@PathVariable("idPauta") String idPauta,
                                    @RequestBody @Valid VotoRequest votoRequest) {
        logger.info("Iniciando chamada para Pauta {} com voto {}.", idPauta, votoRequest.getOpcaoVoto());
        return votoService.votar(idPauta, VotoRequestMapper.buildVoto(idPauta, votoRequest))
                .map(votoDto -> objectMapper.convertValue(votoDto, VotoResponse.class))
                .doOnSuccess(response -> logger.info("Finalizando chamada para Pauta {} com voto {}", idPauta, votoRequest.getOpcaoVoto()));
    }
}
