package br.com.eduardacf.assembleia.mapper;

import br.com.eduardacf.assembleia.api.v1.request.VotoRequest;
import br.com.eduardacf.assembleia.dto.Voto;

public class VotoRequestMapper {

    public static Voto buildVoto(String idPauta, VotoRequest voto) {
        return Voto.of()
                .cpfPessoa(voto.getCpfPessoa())
                .idPauta(idPauta)
                .voto(voto.getOpcaoVoto().name())
                .build();
    }
}
