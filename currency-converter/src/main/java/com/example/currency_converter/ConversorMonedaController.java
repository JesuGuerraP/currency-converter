package com.example.currency_converter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ConversorMonedaController {
    private final ApiCliente apiCliente;

    public ConversorMonedaController(ApiCliente apiCliente) {
        this.apiCliente = apiCliente;
    }

    @GetMapping("/")
    public String mostrarConversor(Model model) {
        model.addAttribute("opcionesCambio", getOpcionesCambio());
        return "conversor";
    }

    @PostMapping("/convertir")
    public String convertirMoneda(@RequestParam("opcion") int opcion,
                                  @RequestParam("cantidad") double cantidad,
                                  Model model) {
        try {
            if (cantidad <= 0) {
                throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");
            }
            ConversionResultado resultado = realizarConversion(opcion, cantidad);
            model.addAttribute("resultado", resultado.getMensaje());
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        model.addAttribute("opcionesCambio", getOpcionesCambio());
        return "conversor";
    }

    private List<Map<String, String>> getOpcionesCambio() {
        List<Map<String, String>> opciones = new ArrayList<>();
        opciones.add(Map.of("id", "1", "from", "USD", "to", "ARS"));
        opciones.add(Map.of("id", "2", "from", "ARS", "to", "USD"));
        opciones.add(Map.of("id", "3", "from", "USD", "to", "BRL"));
        opciones.add(Map.of("id", "4", "from", "BRL", "to", "USD"));
        opciones.add(Map.of("id", "5", "from", "USD", "to", "COP"));
        opciones.add(Map.of("id", "6", "from", "COP", "to", "USD"));
        return opciones;
    }

    private ConversionResultado realizarConversion(int opcion, double cantidad) throws Exception {
        String from = "";
        String to = "";
        switch (opcion) {
            case 1:
                from = "USD";
                to = "ARS";
                break;
            case 2:
                from = "ARS";
                to = "USD";
                break;
            case 3:
                from = "USD";
                to = "BRL";
                break;
            case 4:
                from = "BRL";
                to = "USD";
                break;
            case 5:
                from = "USD";
                to = "COP";
                break;
            case 6:
                from = "COP";
                to = "USD";
                break;
            default:
                throw new IllegalArgumentException("Opción inválida");
        }
        double valorConvertido = apiCliente.convertirMoneda(from, to, cantidad);
        String mensaje = String.format("El resultado de la conversión de %.2f %s a %s es %.2f", cantidad, from, to, valorConvertido);
        return new ConversionResultado(valorConvertido, mensaje);
    }

    public static class ConversionResultado {
        private final double valorConvertido;
        private final String mensaje;

        public ConversionResultado(double valorConvertido, String mensaje) {
            this.valorConvertido = valorConvertido;
            this.mensaje = mensaje;
        }

        public double getValorConvertido() {
            return valorConvertido;
        }

        public String getMensaje() {
            return mensaje;
        }
    }
}
