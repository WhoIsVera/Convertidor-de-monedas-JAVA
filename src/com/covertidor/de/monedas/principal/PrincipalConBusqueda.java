package com.covertidor.de.monedas.principal;

import com.covertidor.de.monedas.modulos.ConsultarMoneda;
import java.text.DecimalFormat;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

            System.out.println("Ingrese el acronimo de la moneda que desea: ");
            var busqueda = teclado.nextLine().toUpperCase();

            System.out.println("Ingrese el acronimo de la moneda que desea hacerle la conversion: ");
            var objetivo = teclado.nextLine().toUpperCase();

            System.out.println("Ingrese la cantidad a convertir:");
            var cantidad = teclado.nextDouble();

        try{
                ConsultarMoneda consultor = new ConsultarMoneda();
                double tasaConversion = consultor.obtenerTasaConversion(busqueda, objetivo);

                double cantidadConvertida = cantidad * tasaConversion;
                DecimalFormat df = new DecimalFormat("#.00");

                String formatoNumero = df.format(cantidadConvertida);
                System.out.println(cantidad+ " "+ busqueda + ", "+ "equivale a: " + formatoNumero+ " "+ objetivo );

        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
            System.out.println("Programa finalizado, hasta luego");


    }


}
