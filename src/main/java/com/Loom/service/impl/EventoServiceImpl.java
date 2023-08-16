/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Loom.service.impl;

import com.Loom.dao.EventoDao;
import com.Loom.domain.Evento;
import com.Loom.service.EventoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoDao eventoDao;

// Método para obtener la lista de eventos
    @Override
    @Transactional(readOnly = true)
    public List<Evento> getEventos(Evento evento) {
        var lista = eventoDao.findAll();
        return lista; // Devuelve la lista resultante
    }

// Método para obtener un evento según su ID
    @Override
    @Transactional(readOnly = true)
    public Evento getEvento(Evento evento) {
        return eventoDao.findById(evento.getIdEvento()).orElse(null);
    }

// Método para guardar o actualizar un evento en la base de datos
    @Override
    @Transactional
    public void save(Evento evento) {
        eventoDao.save(evento);
    }

// Método para eliminar un evento de la base de datos
    @Override
    @Transactional
    public void delete(Evento evento) {
        eventoDao.delete(evento);
    }
}
