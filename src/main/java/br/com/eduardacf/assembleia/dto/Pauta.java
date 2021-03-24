package br.com.eduardacf.assembleia.dto;

public class Pauta {

    private String id;
    private String titulo;

    public Pauta() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pauta(String titulo) {
        this.titulo = titulo;
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
        private Pauta pauta;

        private Builder() {
            pauta = new Pauta();
        }

        public Builder id(String id) {
            pauta.setId(id);
            return this;
        }

        public Builder titulo(String titulo) {
            pauta.setTitulo(titulo);
            return this;
        }

        public Pauta build() {
            return pauta;
        }
    }
}
