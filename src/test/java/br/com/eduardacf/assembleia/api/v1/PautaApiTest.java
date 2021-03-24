package br.com.eduardacf.assembleia.api.v1;

import br.com.eduardacf.assembleia.api.v1.request.PautaRequestStub;
import br.com.eduardacf.assembleia.api.v1.response.PautaResponse;
import br.com.eduardacf.assembleia.dto.Pauta;
import br.com.eduardacf.assembleia.service.PautaService;
import br.com.eduardacf.assembleia.stub.PautaStub;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PautaApiTest {

    private WebTestClient webTestClient;

    @Mock
    private PautaService pautaService;

    @Mock
    private Logger logger;

    @Spy
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        webTestClient = WebTestClient
                .bindToController(new PautaApi(pautaService, objectMapper))
                .configureClient()
                .baseUrl("/v1/pautas")
                .build();
    }

    @Test
    public void deveRetornarTodasPautas() {
        when(pautaService.buscarTodasPautas()).thenReturn(Flux.just(PautaStub.criarPauta()));
        webTestClient.get()
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(PautaResponse.class);
    }

    @Test
    void deveRetornarUmaPauta() {
        when(pautaService.buscarPautaPorId("123456789")).thenReturn(Mono.just(PautaStub.criarPauta()));
        webTestClient.get()
                .uri("/123456789")
                .exchange()
                .expectStatus().isOk()
                .expectBody(PautaResponse.class);
    }


    @Test
    public void deveCriarPauta() {
        when(pautaService.criarPauta(any(Pauta.class))).thenReturn(Mono.just(PautaStub.criarPauta()));
        webTestClient.post()
                .bodyValue(PautaRequestStub.criarPauta())
                .exchange()
                .expectStatus().isCreated()
                .expectBody(PautaResponse.class);
    }
}
