package com.covertidor.de.monedas.modulos;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {


    public ConsultarMoneda buscarMoneda(String conversion_rates) {
        String api = "https://v6.exchangerate-api.com/v6/4586d12e49cbc866cb5792c3/latest/" + conversion_rates;

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(api))
                .build();

        try{
            HttpResponse<String> repose = cliente
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Gson
        }catch (Exception e){

        }


    }


}
