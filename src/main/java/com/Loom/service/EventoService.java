/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Loom.service;

import com.Loom.domain.Evento;
import java.util.List;

/**
 *
 * @author NIKY
 */
public interface EventoService {
    // Obtiene una lista de eventos con opción de filtrar por activos
    public List<Evento> getEventos(Evento evento);
    
     // Obtiene un evento a partir de su objeto evento
    public Evento getEvento(Evento evento);
    
    // Guarda un nuevo evento si el id del evento está vacío, o actualiza uno existente
    public void save(Evento evento);
    
    // Elimina un evento basado en su objeto evento
    public void delete(Evento evento);
}
