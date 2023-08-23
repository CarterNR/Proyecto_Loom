package com.Loom.controller;

import com.Loom.domain.Descuento;
import com.Loom.service.DescuentoService;
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
@RequestMapping("/descuento")
public class DescuentoController {
    @Autowired
    DescuentoService descuentoService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        var descuentos = descuentoService.getDescuentos();
        model.addAttribute("descuentos", descuentos);
        // Obtiene la lista de descuentos y la agrega al modelo para la vista
        return "/descuento/listado"; // Devuelve la vista de listado de descuentos
    }

    @GetMapping("/nuevo")
    public String descuentoNuevo(Descuento descuento) {
        return "/descuento/modifica"; // Devuelve la vista de formulario para crear un nuevo descuento
    }

    @PostMapping("/guardar")
    public String descuentoGuardar(Descuento descuento) {
        // Guarda un descuento y redirige a la lista de descuentos
        descuentoService.save(descuento); // Guarda el descuento en la base de datos
        return "redirect:/descuento/listado"; // Redirige a la lista de descuentos
    }

    @GetMapping("/eliminar/{idDescuento}")
    public String descuentoEliminar(Descuento descuento) {
        // Elimina un descuento y redirige a la lista de descuentos
        descuentoService.delete(descuento); // Elimina el descuento de la base de datos
        return "redirect:/descuento/listado"; // Redirige a la lista de descuentos
    }
    
    @GetMapping("/modificar/{idDescuento}")
    public String descuentoModificar(Descuento descuento, Model model) {
        // Obtiene un descuento y lo agrega al modelo para el formulario de modificación
        descuento = descuentoService.getDescuento(descuento); // Obtiene el descuento con el ID especificado
        model.addAttribute("descuento", descuento); // Agrega el descuento al modelo

        return "/descuento/modifica"; // Devuelve la vista de formulario de modificación
    }
}
