import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {

    public void consulta() {

        // Crear conexion con API

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/f85523bc799550656f2485b6/latest/USD"))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);

        }
        String json = response.body();


        // Crear una instancia de Gson
        Gson gson = new Gson();
        MonedaAPI monedaAPI = gson.fromJson(json, MonedaAPI.class);
        Moneda moneda = monedaAPI.filtrarMonedas();


    }
}