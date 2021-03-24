package br.com.eduardacf.assembleia.dto;

import java.time.LocalDateTime;

public class Sessao {

    private String id;
    private String idPauta;
    private LocalDateTime fimSessao;
    private LocalDateTime inicioSessao;
    private Integer totalDeVotosSim;
    private Integer totalDeVotosNao;

    public Sessao() {
    }

    public Sessao(String id, String idPauta, LocalDateTime fimSessao, LocalDateTime inicioSessao, Integer totalDeVotosSim, Integer totalDeVotosNao) {
        this.id = id;
        this.idPauta = idPauta;
        this.fimSessao = fimSessao;
        this.inicioSessao = inicioSessao;
        this.totalDeVotosSim = totalDeVotosSim;
        this.totalDeVotosNao = totalDeVotosNao;
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


    public static Builder of() {
        return new Builder();
    }

    public static final class Builder {
        private Sessao sessao;

        private Builder() {
            sessao = new Sessao();
        }

        public Builder id(String id) {
            sessao.setId(id);
            return this;
        }

        public Builder idPauta(String idPauta) {
            sessao.setIdPauta(idPauta);
            return this;
        }

        public Builder fimSessao(LocalDateTime fimSessao) {
            sessao.setFimSessao(fimSessao);
            return this;
        }

        public Builder inicioSessao(LocalDateTime inicioSessao) {
            sessao.setInicioSessao(inicioSessao);
            return this;
        }

        public Builder totalDeVotosSim(Integer totalDeVotosSim) {
            sessao.setTotalDeVotosSim(totalDeVotosSim);
            return this;
        }

        public Builder totalDeVotosNao(Integer totalDeVotosNao) {
            sessao.setTotalDeVotosNao(totalDeVotosNao);
            return this;
        }

        public Sessao build() {
            return sessao;
        }
    }
}
