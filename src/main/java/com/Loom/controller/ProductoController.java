package com.Loom.controller;

import com.Loom.domain.Producto;
import com.Loom.service.CategoriaService;
import com.Loom.service.ProductoService;
import com.Loom.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/producto/listado")
    public String inicio(Model model) {
        // Obtiene la lista de productos y la agrega al modelo para la vista
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);

        return "/producto/listado";// Devuelve la vista de listado de productos
    }
    

    @GetMapping("/producto/nuevo")
    public String nuevoProducto(Producto producto, Model model) {
// Prepara la vista del formulario para crear un nuevo producto
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        return "/producto/listado";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/producto/guardar")
    public String guardarProducto(Producto producto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {  
        // Guarda la categoría y carga una imagen si se proporciona
        if (!imagenFile.isEmpty()) {
            productoService.save(producto);
            producto.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "producto", 
                            producto.getIdProducto()));
        }
        productoService.save(producto);
        return "redirect:/producto/listado";
    }

    @GetMapping("/producto/modificar/{idProducto}")
    public String modificarProducto(Producto producto, Model model) {
// Obtiene un producto y lo agrega al modelo para el formulario de modificación
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);
        return "/producto/modifica";// Devuelve la vista de formulario de modificación
    }

    @GetMapping("/producto/eliminar/{idProducto}")
    public String eliminarProducto(Producto producto) {
// Elimina un producto y redirige a la lista de productos
        productoService.delete(producto);
        return "redirect:/producto/listado";
    }
}
