package br.com.eduardacf.assembleia.type;

public enum VotoTipoEnum {
    SIM("SIM"),
    NÃO("NÃO");

    private String code;

    VotoTipoEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
