package com.techlab.ecommerce.exception;

/**
 * Excepción personalizada que se lanza cuando se intenta asignar
 * un stock inválido (por ejemplo, un valor negativo).
 */
public class StockInsuficienteException extends RuntimeException {

    public StockInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
