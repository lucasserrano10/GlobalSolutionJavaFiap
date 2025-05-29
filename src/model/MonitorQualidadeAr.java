package model;

public class MonitorQualidadeAr {
    private String localizacao;
    private double pm25;
    //material particulado com diâmetro de 2,5 micrômetros ou menos

    public MonitorQualidadeAr(String localizacao, double pm25) {
        this.localizacao = localizacao;
        this.pm25 = pm25;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public double getPm25() {
        return pm25;
    }
}
