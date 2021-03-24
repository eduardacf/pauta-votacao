package br.com.eduardacf.assembleia.stub;

import br.com.eduardacf.assembleia.dto.Pauta;
import br.com.eduardacf.assembleia.entity.PautaEntity;

public class PautaStub {

    public static Pauta criarPauta() {
        return Pauta.of()
                .titulo("testeTitulo")
                .id("123456789")
                .build();
    }

}
