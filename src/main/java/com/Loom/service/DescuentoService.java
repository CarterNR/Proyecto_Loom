/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Loom.service;

import com.Loom.domain.Descuento;
import java.util.List;

public interface DescuentoService {
    // Obtiene una lista de descuentos con opción de filtrar por activos
    public List<Descuento> getDescuentos();
    
     // Obtiene un descuento a partir de su objeto descuento
    public Descuento getDescuento(Descuento descuento);
    
    // Guarda un nuevo descuento si el id del descuento está vacío, o actualiza uno existente
    public void save(Descuento descuento);
    
    // Elimina un descuento basado en su objeto descuento
    public void delete(Descuento descuento);
}
