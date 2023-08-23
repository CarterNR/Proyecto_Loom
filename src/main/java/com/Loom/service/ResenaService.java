/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Loom.service;

import com.Loom.domain.Resena;
import java.util.List;

/**
 *
 * @author NIKY
 */
public interface ResenaService {
    
    // Obtiene una lista de resenas con opción de filtrar por activos
    public List<Resena> getResenas(boolean activos);
    
     // Obtiene un resena a partir de su objeto resena
    public Resena getResena(Resena resena);
    
    // Guarda un nuevo resena si el id del resena está vacío, o actualiza uno existente
    public void save(Resena resena);
    
    // Elimina un resena basado en su objeto resena
    public void delete(Resena resena);
}
