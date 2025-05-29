package model;

public class Alerta {
    private String mensagem;
    private String localizacao;

    public Alerta(String mensagem, String localizacao) {
        this.mensagem = mensagem;
        this.localizacao = localizacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getLocalizacao() {
        return localizacao;
    }
}
