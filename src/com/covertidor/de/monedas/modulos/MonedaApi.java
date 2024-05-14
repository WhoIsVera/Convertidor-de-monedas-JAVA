package com.covertidor.de.monedas.modulos;
import java.util.Map;


public record MonedaApi(String result,
                        String base_code,
                        Map<String, Double> conversion_rates
                         ) {



}
