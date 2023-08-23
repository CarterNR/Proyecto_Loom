package com.Loom.service;

import java.util.List;
import com.Loom.domain.Producto;

public interface ProductoService {
    
    // Obtiene una lista de productos con opción de filtrar por activos
    public List<Producto> getProductos(boolean activos);
    
     // Obtiene un producto a partir de su objeto producto
    public Producto getProducto(Producto producto);
    
    // Guarda un nuevo producto si el id del producto está vacío, o actualiza uno existente
    public void save(Producto producto);
    
    // Elimina un producto basado en su objeto producto
    public void delete(Producto producto);
}
