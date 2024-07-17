package modelos;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GerarConversao {
    private double valorEntrada;
    private double cotacao;
    private String moedaEntrada;
    private String moedaSaida;

    DecimalFormat df1 = new DecimalFormat("0.00");
    DecimalFormat df2 = new DecimalFormat("0.000");
    Scanner sc = new Scanner(System.in);

    private static List<InfoConversao> conversoes = new ArrayList<>();

    public GerarConversao(String moedaEntrada, String moedaSaida) {
        this.moedaEntrada = moedaEntrada;
        this.moedaSaida = moedaSaida;

        System.out.print("Digite o valor a ser convertido em " + moedaEntrada + ": ");
        double valor = sc.nextDouble();
        this.valorEntrada = valor;

        try {
            PegaCotacao pegaCotacao = new PegaCotacao();
            Moeda moeda = pegaCotacao.realizaConversao(this.moedaEntrada);
            if (moeda.getResult().equals("success")) {
                this.cotacao = moeda.getConversionRates().getGeral(this.moedaSaida);
            } else {
                throw new RuntimeException("Moeda entrada inválida!");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao realizar a conversão: " + e.getMessage());
        }

        InfoConversao conversao = new InfoConversao(moedaEntrada, moedaSaida, valorEntrada, cotacao * valorEntrada);
        conversoes.add(conversao);

        salvarConversoes();
    }

    public void imprimirConversao() {
        System.out.println("Conversão: " +
                df1.format(valorEntrada) + " [" + moedaEntrada + "] equivalem a " + df2.format(cotacao * valorEntrada)
                + " [" + moedaSaida + "]");
    }

    private void salvarConversoes() {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            String json = gson.toJson(conversoes);

            FileWriter writer = new FileWriter("conversoes.json");
            writer.write(json);
            writer.close();

            System.out.println("Conversões salvas em JSON com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar conversões em JSON: " + e.getMessage());
        }
    }

}
