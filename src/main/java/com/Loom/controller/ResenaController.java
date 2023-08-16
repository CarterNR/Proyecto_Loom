/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Loom.controller;

import com.Loom.domain.Resena;
import com.Loom.service.ProductoService;
import com.Loom.service.ResenaService;
import com.Loom.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResenaController {

    @Autowired
    ResenaService resenaService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ProductoService productoService;

    @GetMapping("/resena/listado")
    public String inicio(Model model) {
        // Obtiene la lista de resenas y la agrega al modelo para la vista
        var resenas = resenaService.getResenas();
        model.addAttribute("resenas", resenas);

        return "/resena/listado";// Devuelve la vista de listado de resenas
    }

    @GetMapping("/resena/nuevo")
    public String nuevoResena(Resena resena, Model model) {
// Prepara la vista del formulario para crear un nuevo resena
        var usuarios = usuarioService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        var productos = productoService.getProductos(true);
        model.addAttribute("productos", productos);
        return "/resena/modificar";
    }

    @PostMapping("/resena/guardar")
    public String guardarResena(Resena resena) {
// Guarda un resena y redirige a la lista de resenas
        resenaService.save(resena);
        return "redirect:/resena/listado";
    }

    @GetMapping("/resena/modificar/{idResena}")
    public String modificarResena(Resena resena, Model model) {
// Obtiene un resena y lo agrega al modelo para el formulario de modificación
        resena = resenaService.getResena(resena);
        model.addAttribute("resena", resena);
        return "/resena/modificar";// Devuelve la vista de formulario de modificación

    }

    @GetMapping("/resena/eliminar/{idResena}")
    public String eliminarResena(Resena resena) {
// Elimina un resena y redirige a la lista de resenas
        resenaService.delete(resena);
        return "redirect:/resena/listado";
    }
}
