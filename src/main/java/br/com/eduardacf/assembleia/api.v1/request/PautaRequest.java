package br.com.eduardacf.assembleia.api.v1.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

public class PautaRequest {

    @NotBlank(message = "Título para pauta é obrigatório.")
    @ApiModelProperty(value = "Título da pauta.")
    private String titulo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "PautaRequest{" +
                "titulo='" + titulo + '\'' +
                '}';
    }

    public static Builder of() {
        return new Builder();
    }

    public static final class Builder {
        private PautaRequest pautaRequest;

        private Builder() {
            pautaRequest = new PautaRequest();
        }

        public Builder titulo(String titulo) {
            pautaRequest.setTitulo(titulo);
            return this;
        }

        public PautaRequest build() {
            return pautaRequest;
        }
    }
}
