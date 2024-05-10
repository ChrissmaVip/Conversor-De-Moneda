import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Menu {

    private double valorFinal;

    public void menuInicial() throws IOException, InterruptedException {

        // Crear conexion con API

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/f85523bc799550656f2485b6/latest/USD"))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();


        // Crear una instancia de Gson
        Gson gson = new Gson();
        MonedaAPI monedaAPI = gson.fromJson(json, MonedaAPI.class);
        Moneda moneda = monedaAPI.filtrarMonedas();

        Scanner lectura = new Scanner(System.in);


        int op = 1;

        while (op != 7) {

            System.out.println("""
                     *********************************************************
                     Sea bienvenido al Conversor de Moneda =]
                     
                                    1) Dólar ==> Peso Argentino.
                                    2) Peso Argentino ==> Dólar.
                                    3) Dólar ==> Real Brasileño.
                                    4) Real Brasileño ==> Dólar.
                                    5) Dólar ==> Peso Colombiano.
                                    6) Peso Colombiano ==> Dólar.
                                    7) Salir.
                                    
                      Elija una opción válida.
                    ********************************************************** """);


                op = lectura.nextInt();


                switch (op) {

                    case 1:

                        consulta();

                        int lectura1 = lectura.nextInt();

                        valorFinal = lectura1 * moneda.getArs();
                        System.out.println("Usted convirtio " + lectura1 + " USD" + " ==> a ARS :" + valorFinal);

                        break;

                    case 2:
                        consulta();
                        int lectura2 = lectura.nextInt();

                        valorFinal = lectura2 / moneda.getArs();
                        System.out.println("Usted convirtio " + lectura2 + " ARS" + " ==> a USD :" + valorFinal);

                        break;

                    case 3:
                        consulta();
                        int lectura3 = lectura.nextInt();

                        valorFinal = lectura3 * moneda.getBrl();
                        System.out.println("Usted convirtio " + lectura3 + " USD" + " ==> a BRL :" + valorFinal);
                        break;

                    case 4:
                        consulta();
                        int lectura4 = lectura.nextInt();

                        valorFinal = lectura4 / moneda.getBrl();
                        System.out.println("Usted convirtio " + lectura4 + " BRL" + " ==> a USD :" + valorFinal);
                        break;

                    case 5:
                        consulta();
                        int lectura5 = lectura.nextInt();

                        valorFinal = lectura5 * moneda.getCop();
                        System.out.println("Usted convirtio " + lectura5 + " USD" + " ==> a COP :" + valorFinal);

                        break;

                    case 6:
                        consulta();
                        int lectura6 = lectura.nextInt();

                        valorFinal = lectura6 / moneda.getBrl();
                        System.out.println("Usted convirtio " + lectura6 + " COP" + " ==> a USD :" + valorFinal);
                        break;
                    case 7:
                        if (op == 7) {
                            System.out.printf("***Gracias por usar los servicios de Cambio de Monedas***");
                        }
                        break;

                    default:
                        System.out.println("***No ingresó una opción válida, intente nuevamente***");

                }

        }


    }
    public void consulta() {
        System.out.println("Ingrese el valor que desea convertir: ");
        Scanner lectura = new Scanner(System.in);


    }

}



