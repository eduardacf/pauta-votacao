package br.com.eduardacf.assembleia.mapper;

import br.com.eduardacf.assembleia.dto.Voto;
import br.com.eduardacf.assembleia.entity.VotoEntity;

public class VotoEntityMapper {

    public static VotoEntity buildVotoEntity(String idPauta, Voto voto) {
        return VotoEntity.of()
                .cpfPessoa(voto.getCpfPessoa())
                .id(voto.getId())
                .voto(voto.getVoto())
                .idPauta(idPauta)
                .build();
    }
}
