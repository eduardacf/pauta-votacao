package br.com.eduardacf.assembleia.api.v1.response;

import br.com.eduardacf.assembleia.type.VotoTipoEnum;

public class VotoResponse {

    private String id;
    private String idPauta;
    private VotoTipoEnum voto;
    private String cpfPessoa;

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

    public VotoTipoEnum getVoto() {
        return voto;
    }

    public void setVoto(VotoTipoEnum voto) {
        this.voto = voto;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }


}
