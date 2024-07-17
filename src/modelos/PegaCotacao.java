package modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class PegaCotacao {
    public Moeda realizaConversao(String moedaOrigem) {
        String key = System.getenv("KEY_MOEDAS");
        URI urlAPI = URI.create("https://v6.exchangerate-api.com/v6/" + key + "/latest/" + moedaOrigem);

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(urlAPI)
                .build();

        HttpResponse<String> response;
        try {
            response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Moeda moeda = new Gson().fromJson(response.body(), Moeda.class);

            if (moeda.getResult().equals("error")) {
                throw new RuntimeException(
                        "Erro ao realizar testar realizar conversão\nMoeda de entrada: " + moedaOrigem);
            } else {
                return moeda;
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao realizar a conversão!");
        }
    }

}
