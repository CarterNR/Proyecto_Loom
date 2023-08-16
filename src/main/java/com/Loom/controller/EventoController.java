/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Loom.controller;

import com.Loom.domain.Evento;
import com.Loom.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventoController {
    @Autowired
    EventoService eventoService;
    
    @GetMapping("/evento/listado")
    public String inicio(Model model) {
        var eventos = eventoService.getEventos();
        model.addAttribute("eventos", eventos);
        // Obtiene la lista de eventos y la agrega al modelo para la vista
        return "/evento/listado"; // Devuelve la vista de listado de eventos
    }

    @GetMapping("/evento/nuevo")
    public String nuevoEvento(Evento evento, Model model) {
        // Prepara la vista del formulario para crear un nuevo evento
        return "/evento/modificar"; // Devuelve la vista de formulario para crear un nuevo evento
    }

    @PostMapping("/evento/guardar")
    public String guardarEvento(Evento evento) {
        // Guarda un evento y redirige a la lista de eventos
        eventoService.save(evento); // Guarda el evento en la base de datos
        return "redirect:/evento/listado"; // Redirige a la lista de eventos
    }

    @GetMapping("/evento/modificar/{idEvento}")
    public String modificarEvento(Evento evento, Model model) {
        // Obtiene un evento y lo agrega al modelo para el formulario de modificación
        evento = eventoService.getEvento(evento); // Obtiene el evento con el ID especificado
        model.addAttribute("evento", evento); // Agrega el evento al modelo

        return "/evento/modificar"; // Devuelve la vista de formulario de modificación
    }

    @GetMapping("/evento/eliminar/{idEvento}")
    public String eliminarEvento(Evento evento) {
        // Elimina un evento y redirige a la lista de eventos
        eventoService.delete(evento); // Elimina el evento de la base de datos
        return "redirect:/evento/listado"; // Redirige a la lista de eventos
    }
}
