package com.techlab.ecommerce.exception;

/**
 * Excepción personalizada que se lanza cuando se busca un producto
 * por su id y no existe en el sistema.
 */
public class ProductoNoEncontradoException extends RuntimeException {

    public ProductoNoEncontradoException(String mensaje) {
       
        super(mensaje);
    }
}
