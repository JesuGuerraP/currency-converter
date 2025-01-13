package com.example.currency_converter;

public interface ApiCliente {
    double convertirMoneda(String from, String to, double cantidad) throws Exception;
}
