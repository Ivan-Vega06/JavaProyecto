package com.techlab.ecommerce.service;

import com.techlab.ecommerce.exception.ProductoNoEncontradoException;
import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.util.Validador;

import java.util.ArrayList;
import java.util.List;

/**
 * Capa de servicio: contiene la lógica de negocio del sistema.
 *
 * Es responsable de:
 *  - Mantener la colección de productos.
 *  - Asignar el id al guardar un nuevo producto.
 *  - Validar los datos antes de guardar o actualizar.
 *  - Buscar, modificar y eliminar productos por id.
 */
public class ProductoService {

    // Colección en memoria que guarda los productos.
    private List<Producto> productos = new ArrayList<>();

    // Contador para asignar ids únicos.
    private static int contadorId = 1;

    // ----------------------------------------------------------------
    // Operaciones del CRUD
    // ----------------------------------------------------------------

    // CREATE: agrega un nuevo producto al catálogo.
    public Producto guardar(Producto p) {
        
        Validador.validarNombre(p.getNombre());
        Validador.validarPrecio(p.getPrecio());
        Validador.validarStock(p.getStock());
        Validador.validarCategoria(p.getCategoria());

        p.setId(contadorId);
        contadorId++;

        productos.add(p);
        return p;
    }

    // READ: devuelve toda la lista de productos.
    public List<Producto> listarTodos() {
        return productos;
    }

    // READ: busca un producto por id. Si no existe, lanza excepción.
    public Producto obtenerPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new ProductoNoEncontradoException("No se encontró un producto con id " + id);
    }

    // UPDATE: actualiza los datos de un producto existente.
    
    public Producto actualizar(int id, Producto datos) {
      
        Producto p = obtenerPorId(id);

        Validador.validarNombre(datos.getNombre());
        Validador.validarPrecio(datos.getPrecio());
        Validador.validarStock(datos.getStock());
        Validador.validarCategoria(datos.getCategoria());

        
        p.setNombre(datos.getNombre());
        p.setPrecio(datos.getPrecio());
        p.setStock(datos.getStock());
        p.setCategoria(datos.getCategoria());

        return p;
    }

    // DELETE: elimina un producto por id.
    public void eliminar(int id) {
        
        Producto p = obtenerPorId(id);
        productos.remove(p);
    }
}
