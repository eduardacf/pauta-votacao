package br.com.eduardacf.assembleia.entity;

import br.com.eduardacf.assembleia.type.VotoTipoEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class VotoEntity {

    @Id
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
        private VotoEntity votoEntity;

        private Builder() {
            votoEntity = new VotoEntity();
        }

        public Builder id(String id) {
            votoEntity.setId(id);
            return this;
        }

        public Builder idPauta(String idPauta) {
            votoEntity.setIdPauta(idPauta);
            return this;
        }

        public Builder voto(VotoTipoEnum voto) {
            votoEntity.setVoto(voto);
            return this;
        }

        public Builder cpfPessoa(String cpfPessoa) {
            votoEntity.setCpfPessoa(cpfPessoa);
            return this;
        }

        public VotoEntity build() {
            return votoEntity;
        }
    }
}
