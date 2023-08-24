package com.Loom.controller;
import com.Loom.domain.Categoria;
import com.Loom.service.CategoriaService;
import com.Loom.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        // Obtiene la lista de categorías y la agrega al modelo para la vista
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalCategorias", categorias.size());
        return "/categoria/listado";// Devuelve la vista de listado de categorías
    }
    @GetMapping("/nuevo")
    public String categoriaNuevo(Categoria categoria) {
        return "/categoria/modifica";// Devuelve la vista de formulario para nueva categoría
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String categoriaGuardar(Categoria categoria,
            @RequestParam("imagenFile") MultipartFile imagenFile) {  
        // Guarda la categoría y carga una imagen si se proporciona
        if (!imagenFile.isEmpty()) {
            categoriaService.save(categoria);
            categoria.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "categoria", 
                            categoria.getIdCategoria()));
        }
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";// Redirige a la lista de categorías
    }

    @GetMapping("/eliminar/{idCategoria}")
    public String categoriaEliminar(Categoria categoria) {
        // Elimina una categoría y redirige a la lista de categorías
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }
}