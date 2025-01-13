package com.example.currency_converter;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

@Service
public class CurrencyApiClient implements ApiCliente {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/ce3251eff2bd1b0224ed437a/latest/";

    public CurrencyApiClient(RestTemplate restTemplate) {
    }

    @Override
    public double convertirMoneda(String from, String to, double cantidad) throws Exception {
        Map<String, Double> rates = getExchangeRates(from);
        if (rates.containsKey(to)) {
            double tasa = rates.get(to);
            return cantidad * tasa;
        } else {
            throw new Exception("Moneda no disponible para la conversión.");
        }
    }

    private Map<String, Double> getExchangeRates(String baseCurrency) throws Exception {
        String urlString = API_URL + baseCurrency;
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("Error en la solicitud: Código " + responseCode);
        }

        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        Gson gson = new Gson();
        APIResponse response = gson.fromJson(reader, APIResponse.class);
        reader.close();

        if (response == null || response.conversion_rates == null || response.conversion_rates.isEmpty()) {
            throw new Exception("Las tasas de cambio no están disponibles.");
        }

        return response.conversion_rates;
    }

    // Clase interna que coincide con la estructura JSON de la API
    private static class APIResponse {
        public String result;
        public String documentation;
        public String terms_of_use;
        public long time_last_update_unix;
        public String time_last_update_utc;
        public long time_next_update_unix;
        public String time_next_update_utc;
        public String base_code;
        public Map<String, Double> conversion_rates;
    }
}
