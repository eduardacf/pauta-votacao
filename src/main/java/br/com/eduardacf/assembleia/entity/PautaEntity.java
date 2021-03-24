package br.com.eduardacf.assembleia.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PautaEntity {

    @Id
    private String id;
    private String titulo;

    public PautaEntity() {
    }

    public PautaEntity(String id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public static Builder of() {
        return new Builder();
    }

    public static final class Builder {
        private PautaEntity pautaEntity;

        private Builder() {
            pautaEntity = new PautaEntity();
        }

        public Builder id(String id) {
            pautaEntity.setId(id);
            return this;
        }

        public Builder titulo(String titulo) {
            pautaEntity.setTitulo(titulo);
            return this;
        }

        public PautaEntity build() {
            return pautaEntity;
        }
    }
}
