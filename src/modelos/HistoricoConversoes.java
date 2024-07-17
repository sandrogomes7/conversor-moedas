package modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.List;

public class HistoricoConversoes {
    public static void exibirHistorico() {
        DecimalFormat df1 = new DecimalFormat("0.00");
        DecimalFormat df2 = new DecimalFormat("0.000");
        try {

            String arquivoJson = "conversoes.json";
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            Type conversaoListType = new TypeToken<List<InfoConversao>>() {
            }.getType();

            List<InfoConversao> conversoes = gson.fromJson(new FileReader(arquivoJson), conversaoListType);

            System.out.println("---------------------------");
            System.out.println("Histórico de Conversões:");
            for (InfoConversao conversao : conversoes) {
                System.out.println("Moeda de entrada: " + conversao.getMoedaEntrada());
                System.out.println("Moeda de saída: " + conversao.getMoedaSaida());
                System.out.println("Valor de entrada: " + df1.format(conversao.getValorEntrada()) + " ["
                        + conversao.getMoedaEntrada() + "]");
                System.out.println("Valor convertido: " + df2.format(conversao.getValorConvertido()) + " ["
                        + conversao.getMoedaSaida() + "]");
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar histórico de conversões: " + e.getMessage());
        }
    }
}
