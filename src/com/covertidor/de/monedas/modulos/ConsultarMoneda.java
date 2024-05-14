package com.covertidor.de.monedas.modulos;

import com.google.gson.Gson;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConsultarMoneda {

    public MonedaApi buscarMoneda(String busqueda) {
        String api = "https://v6.exchangerate-api.com/v6/4586d12e49cbc866cb5792c3/latest/" + busqueda;

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(api))
                .build();
        try {
            HttpResponse<String> response = cliente
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);
            return new Gson().fromJson(json, MonedaApi.class);

        } catch (Exception e) {
            throw new RuntimeException("No se encontro la moneda");
        }


    }

    public double obtenerTasaConversion(String busqueda, String objetivo) {
        String api = "https://v6.exchangerate-api.com/v6/4586d12e49cbc866cb5792c3/latest/" + busqueda;

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(api))
                .build();
        try {
            HttpResponse<String> response = cliente
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            Map<String, Object> jsonResponse = new Gson().fromJson(json, Map.class);
            Map<String, Double> conversionRates = (Map<String, Double>) jsonResponse.get("conversion_rates");

            // Obtener la tasa de conversión específica
            return conversionRates.get(objetivo);

        } catch (Exception e) {
            throw new RuntimeException("No se encontró la moneda o la tasa de conversión.");
        }
    }
}
