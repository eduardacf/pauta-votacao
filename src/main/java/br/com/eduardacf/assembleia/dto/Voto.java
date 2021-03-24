package br.com.eduardacf.assembleia.dto;


public class Voto {

    private String id;
    private String idPauta;
    private String voto;
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

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
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

        public Builder voto(String votoDto) {
            voto.setVoto(votoDto);
            return this;
        }

        public Builder idPauta(String idPauta) {
            voto.setIdPauta(idPauta);
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
