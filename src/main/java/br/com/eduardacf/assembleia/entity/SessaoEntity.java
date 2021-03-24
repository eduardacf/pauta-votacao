package br.com.eduardacf.assembleia.entity;


import br.com.eduardacf.assembleia.type.VotoTipoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class SessaoEntity {

    @Id
    private String id;
    private String idPauta;
    private LocalDateTime fimSessao;
    private LocalDateTime inicioSessao;
    private Integer totalDeVotosSim;
    private Integer totalDeVotosNao;

    public SessaoEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPauta() {
        return idPauta;
    }

    public void setIdPauta(String idPauta) {
        this.idPauta = idPauta;
    }

    public LocalDateTime getFimSessao() {
        return fimSessao;
    }

    public void setFimSessao(LocalDateTime fimSessao) {
        this.fimSessao = fimSessao;
    }

    public LocalDateTime getInicioSessao() {
        return inicioSessao;
    }

    public void setInicioSessao(LocalDateTime inicioSessao) {
        this.inicioSessao = inicioSessao;
    }

    public Integer getTotalDeVotosSim() {
        return totalDeVotosSim;
    }

    public void setTotalDeVotosSim(Integer totalDeVotosSim) {
        this.totalDeVotosSim = totalDeVotosSim;
    }

    public Integer getTotalDeVotosNao() {
        return totalDeVotosNao;
    }

    public void setTotalDeVotosNao(Integer totalDeVotosNao) {
        this.totalDeVotosNao = totalDeVotosNao;
    }

    public void addSim() {
        this.totalDeVotosSim = totalDeVotosSim + 1;
    }

    public void addNao() {
        this.totalDeVotosNao = totalDeVotosNao + 1;
    }

    public void addVoto(String voto) {
        if (VotoTipoEnum.SIM.getCode().equalsIgnoreCase(voto)) {
            addSim();
        } else if (VotoTipoEnum.NÃO.getCode().equalsIgnoreCase(voto)) {
            addNao();
        }
    }

    public static Builder of() {
        return new Builder();
    }

    public static final class Builder {
        private SessaoEntity sessaoEntity;

        private Builder() {
            sessaoEntity = new SessaoEntity();
        }

        public Builder id(String id) {
            sessaoEntity.setId(id);
            return this;
        }

        public Builder idPauta(String idPauta) {
            sessaoEntity.setIdPauta(idPauta);
            return this;
        }

        public Builder fimSessao(LocalDateTime fimSessao) {
            sessaoEntity.setFimSessao(fimSessao);
            return this;
        }

        public Builder inicioSessao(LocalDateTime inicioSessao) {
            sessaoEntity.setInicioSessao(inicioSessao);
            return this;
        }

        public Builder totalDeVotosSim(Integer totalDeVotosSim) {
            sessaoEntity.setTotalDeVotosSim(totalDeVotosSim);
            return this;
        }

        public Builder totalDeVotosNao(Integer totalDeVotosNao) {
            sessaoEntity.setTotalDeVotosNao(totalDeVotosNao);
            return this;
        }

        public SessaoEntity build() {
            return sessaoEntity;
        }
    }
}
