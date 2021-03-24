package br.com.eduardacf.assembleia.api.v1.response;

public class SessaoResponse {

    private String id;
    private String idPauta;
    private String fimSessao;
    private String inicioSessao;

    public SessaoResponse() {
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

    public String getFimSessao() {
        return fimSessao;
    }

    public void setFimSessao(String fimSessao) {
        this.fimSessao = fimSessao;
    }

    public String getInicioSessao() {
        return inicioSessao;
    }

    public void setInicioSessao(String inicioSessao) {
        this.inicioSessao = inicioSessao;
    }
}
