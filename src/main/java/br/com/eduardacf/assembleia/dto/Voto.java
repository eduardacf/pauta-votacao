package br.com.eduardacf.assembleia.dto;

import br.com.eduardacf.assembleia.type.VotoTipoEnum;

public class Voto {

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

    public static Builder of() {
        return new Builder();
    }

    public static final class Builder {
        private Voto voto;

        private Builder() {
            voto = new Voto();
        }

        public Builder id(String id) {
            voto.setId(id);
            return this;
        }

        public Builder idPauta(String idPauta) {
            voto.setIdPauta(idPauta);
            return this;
        }

        public Builder voto(VotoTipoEnum voto) {
            voto.setCode(voto.getCode());
            return this;
        }

        public Builder cpfPessoa(String cpfPessoa) {
            voto.setCpfPessoa(cpfPessoa);
            return this;
        }

        public Voto build() {
            return voto;
        }
    }
}
