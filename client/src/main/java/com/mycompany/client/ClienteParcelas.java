/**
 *
 * @author Marcelo Alfredo Paz Pezo
 */
package com.mycompany.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.client.model.Parcela;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ClienteParcelas {

    private static final String API_URL = "http://localhost:8080/api/parcelas";
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        System.out.println("--- 1. Listando todas las parcelas existentes ---");
        listarParcelas();

        System.out.println("\n--- 2. Agregando una nueva parcela ---");
        Parcela nueva = new Parcela("ROL-123", 0.95, 0.1, 35.5, 50.0);
        agregarParcela(nueva);
        
        System.out.println("\n--- 3. Listando parcelas de nuevo para ver el cambio ---");
        listarParcelas();
        
        System.out.println("\n--- 4. Obteniendo cantidad de parcelas propensas ---");
        contarParcelasPropensas();
    }

    public static void listarParcelas() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        List<Parcela> parcelas = mapper.readValue(response.body(), new TypeReference<List<Parcela>>() {});

        parcelas.forEach(p -> System.out.println("ROL: " + p.getROL() + ", Combustible: " + p.getIndiceCombustible()));
    }

    public static void agregarParcela(Parcela parcela) throws Exception {
        String requestBody = mapper.writeValueAsString(parcela);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        Parcela agregada = mapper.readValue(response.body(), Parcela.class);
        System.out.println("Parcela agregada con ROL: " + agregada.getROL());
    }

    public static void contarParcelasPropensas() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + "/propensas/cantidad"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        System.out.println("Número de parcelas propensas a incendio: " + response.body());
    }
}