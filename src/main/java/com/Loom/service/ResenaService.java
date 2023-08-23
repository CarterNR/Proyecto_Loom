package com.Loom.service;

import com.Loom.domain.Resena;
import java.util.List;

public interface ResenaService {
    
    // Obtiene una lista de resenas con opción de filtrar por activos
    public List<Resena> getResenas();
    
     // Obtiene un resena a partir de su objeto resena
    public Resena getResena(Resena resena);
    
    // Guarda un nuevo resena si el id del resena está vacío, o actualiza uno existente
    public void save(Resena resena);
    
    // Elimina un resena basado en su objeto resena
    public void delete(Resena resena);
}
