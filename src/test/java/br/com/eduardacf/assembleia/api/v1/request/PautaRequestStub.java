package br.com.eduardacf.assembleia.api.v1.request;


public class PautaRequestStub {

    public static PautaRequest criarPauta() {
        return PautaRequest.of()
                .titulo("testeTitulo")
                .build();
    }

}
