package api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
public class consultaAPI {
    public static void main(String[] args) {
        try {
            consultaAPI c1 = new consultaAPI();
            c1.convertir("EUR", "GBP", 2);
        }catch (Exception e){
            System.out.println("Error al obtener los datos");
        }
    }
    public String convertir(String monedaOrigen, String monedaDestino, double monto) throws IOException, InterruptedException {
        String apiKey = "86aba5495fcca4fabea055cd";

        String url = "https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/"+monedaOrigen+"/"+monedaDestino+"/"+monto;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpClient client = HttpClient.newHttpClient();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            double conversionResult = jsonObject.get("conversion_result").getAsDouble();
            return Double.toString(conversionResult);
        }catch (Exception e){
            throw new RuntimeException("La moneda ingresada no es valida");
        }
    }
}
