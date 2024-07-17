package modelos;

public class InfoConversao {
    private String moedaEntrada;
    private String moedaSaida;
    private double valorEntrada;
    private double valorConvertido;

    public InfoConversao(String moedaEntrada, String moedaSaida, double valorEntrada, double valorConvertido) {
        this.moedaEntrada = moedaEntrada;
        this.moedaSaida = moedaSaida;
        this.valorEntrada = valorEntrada;
        this.valorConvertido = valorConvertido;
    }

    public String getMoedaEntrada() {
        return moedaEntrada;
    }

    public String getMoedaSaida() {
        return moedaSaida;
    }

    public double getValorEntrada() {
        return valorEntrada;
    }

    public double getValorConvertido() {
        return valorConvertido;
    }
}
