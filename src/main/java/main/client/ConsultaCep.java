package main.client;

import com.google.gson.Gson;
import main.model.CepResponse;
import main.model.Endereco;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {

    private static final String URL = "https://viacep.com.br/ws/%s/json/";

    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    public Endereco buscaEndereco(String cep) {

        validarCep(cep);

        URI uri = URI.create(String.format(URL, cep));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        try {
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Erro na API: " + response.statusCode());
            }

            CepResponse cepResponse =
                    gson.fromJson(response.body(), CepResponse.class);

            return Endereco.from(cepResponse);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao consultar CEP", e);
        }
    }

    private void validarCep(String cep) {
        if (cep == null || !cep.matches("\\d{5}-?\\d{3}")) {
            throw new IllegalArgumentException("CEP inválido: " + cep);
        }
    }
}
