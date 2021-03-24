package br.com.eduardacf.assembleia.api.v1.response;

import io.swagger.annotations.ApiModelProperty;

public class PautaResponse {

    @ApiModelProperty(value = "Identificador da pauta.")
    private String id;
    @ApiModelProperty(value = "Título da pauta.")
    private String titulo;

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

    @Override
    public String toString() {
        return "PautaResponse{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }

    public static Builder of() {
        return new Builder();
    }

    public static final class Builder {
        private PautaResponse pautaResponse;

        private Builder() {
            pautaResponse = new PautaResponse();
        }

        public Builder id(String id) {
            pautaResponse.setId(id);
            return this;
        }

        public Builder titulo(String titulo) {
            pautaResponse.setTitulo(titulo);
            return this;
        }

        public PautaResponse build() {
            return pautaResponse;
        }
    }
}
