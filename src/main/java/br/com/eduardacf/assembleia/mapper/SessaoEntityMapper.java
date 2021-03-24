package br.com.eduardacf.assembleia.mapper;


import br.com.eduardacf.assembleia.entity.SessaoEntity;

import java.time.LocalDateTime;

public class SessaoEntityMapper {
    public static SessaoEntity mapSessaoEntity(String idPauta, String duracaoEmMinutos) {
        return SessaoEntity.of()
                .fimSessao(LocalDateTime.now().plusMinutes(Long.parseLong(duracaoEmMinutos)))
                .inicioSessao(LocalDateTime.now())
                .idPauta(idPauta)
                .totalDeVotosNao(0)
                .totalDeVotosSim(0)
                .build();
    }
}
