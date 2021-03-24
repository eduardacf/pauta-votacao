package br.com.eduardacf.assembleia.api.v1.request;

import br.com.eduardacf.assembleia.type.VotoTipoEnum;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class VotoRequest {

    @NotNull
    @ApiModelProperty(value = "CPF da pessoa que irá votar.")
    private String cpfPessoa;
    @NotNull
    @ApiModelProperty(value = "Opção do voto, sim ou não.")
    private VotoTipoEnum opcaoVoto;

    public VotoRequest() {

    }


    public VotoRequest(String cpfPessoa, VotoTipoEnum opcaoVoto) {
        this.cpfPessoa = cpfPessoa;
        this.opcaoVoto = opcaoVoto;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }

    public VotoTipoEnum getOpcaoVoto() {
        return opcaoVoto;
    }

    public void setOpcaoVoto(VotoTipoEnum opcaoVoto) {
        this.opcaoVoto = opcaoVoto;
    }

    public static Builder of() {
        return new Builder();
    }

    public static final class Builder {
        private VotoRequest votoRequest;

        private Builder() {
            votoRequest = new VotoRequest();
        }

        public Builder cpfPessoa(String cpfPessoa) {
            votoRequest.setCpfPessoa(cpfPessoa);
            return this;
        }

        public Builder opcaoVoto(VotoTipoEnum opcaoVoto) {
            votoRequest.setOpcaoVoto(opcaoVoto);
            return this;
        }

        public VotoRequest build() {
            return votoRequest;
        }
    }
}
