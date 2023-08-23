/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Loom.controller;

import com.Loom.domain.Evento;
import com.Loom.service.EventoService;
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
@RequestMapping("/evento")
public class EventoController {
    @Autowired
    EventoService eventoService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        var eventos = eventoService.getEventos();
        model.addAttribute("eventos", eventos);
        // Obtiene la lista de eventos y la agrega al modelo para la vista
        return "/evento/listado"; // Devuelve la vista de listado de eventos
    }

    @GetMapping("/nuevo")
    public String eventoNuevo(Evento evento) {
        return "/evento/modifica"; // Devuelve la vista de formulario para crear un nuevo evento
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String eventoGuardar(Evento evento,
        @RequestParam("imagenFile") MultipartFile imagenFile) {  
        // Guarda la categoría y carga una imagen si se proporciona
        if (!imagenFile.isEmpty()) {
            eventoService.save(evento);
            evento.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "categoria", 
                            evento.getIdEvento()));
        }
        
        // Guarda un evento y redirige a la lista de eventos
        eventoService.save(evento); // Guarda el evento en la base de datos
        return "redirect:/evento/listado"; // Redirige a la lista de eventos
    }

    @GetMapping("/eliminar/{idEvento}")
    public String eventoEliminar(Evento evento) {
        // Elimina un evento y redirige a la lista de eventos
        eventoService.delete(evento); // Elimina el evento de la base de datos
        return "redirect:/evento/listado"; // Redirige a la lista de eventos
    }
    
    @GetMapping("/modificar/{idEvento}")
    public String eventoModificar(Evento evento, Model model) {
        // Obtiene un evento y lo agrega al modelo para el formulario de modificación
        evento = eventoService.getEvento(evento); // Obtiene el evento con el ID especificado
        model.addAttribute("evento", evento); // Agrega el evento al modelo

        return "/evento/modifica"; // Devuelve la vista de formulario de modificación
    }
}
