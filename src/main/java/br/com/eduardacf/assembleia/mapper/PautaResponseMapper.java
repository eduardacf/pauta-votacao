package br.com.eduardacf.assembleia.mapper;

import br.com.eduardacf.assembleia.api.v1.response.PautaResponse;
import br.com.eduardacf.assembleia.dto.Pauta;

public class PautaResponseMapper {

    public static PautaResponse mapResponsePauta(Pauta pautaEntity) {
        return PautaResponse.of()
                .id(pautaEntity.getId())
                .titulo(pautaEntity.getTitulo())
                .build();
    }

}
