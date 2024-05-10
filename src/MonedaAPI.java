import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class MonedaAPI {
    @SerializedName("conversion_rates")
    private Map<String, Double> listaDeMonedas;

    public MonedaAPI(Map<String, Double> listaDeMonedas) {
        this.listaDeMonedas = listaDeMonedas;
    }

    public Moneda filtrarMonedas() {
        Moneda monedaFiltrada = new Moneda();

        if (listaDeMonedas.containsKey("ARS")) {
            monedaFiltrada.setArs(listaDeMonedas.get("ARS").doubleValue());
        }
        if (listaDeMonedas.containsKey("BRL")) {
            monedaFiltrada.setBrl(listaDeMonedas.get("BRL").doubleValue());
        }
        if (listaDeMonedas.containsKey("COP")) {
            monedaFiltrada.setCop(listaDeMonedas.get("COP").doubleValue());
        }
        if (listaDeMonedas.containsKey("USD")) {
            monedaFiltrada.setUsd(listaDeMonedas.get("USD").doubleValue());
        }


        return monedaFiltrada;
    }
    }





  


