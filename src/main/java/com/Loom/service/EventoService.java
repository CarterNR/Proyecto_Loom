package com.Loom.service;

import com.Loom.domain.Evento;
import java.util.List;

public interface EventoService {
    // Obtiene una lista de eventos con opción de filtrar por activos
    public List<Evento> getEventos();
    
     // Obtiene un evento a partir de su objeto evento
    public Evento getEvento(Evento evento);
    
    // Guarda un nuevo evento si el id del evento está vacío, o actualiza uno existente
    public void save(Evento evento);
    
    // Elimina un evento basado en su objeto evento
    public void delete(Evento evento);
}
