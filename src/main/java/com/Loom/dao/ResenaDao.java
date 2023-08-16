/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Loom.dao;

import com.Loom.domain.Resena;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ResenaDao extends JpaRepository<Resena, Long> {
   /* 
// Consulta JPQL personalizada para buscar resenas por rango de calificacion usando parámetros
    @Query(value = "SELECT a FROM resenas a WHERE a.calificacion BETWEEN :calificacionInf AND :calificacionSup ORDER BY a.comentario ASC")
    public List<Resena> metodoJPQL(@Param("calificacionInf") int calificacionInf, @Param("calificacionSup") int calificacionSup);

// Consulta nativa personalizada para buscar resenas por rango de calificacion usando parámetros
    @Query(nativeQuery = true,
            value = "SELECT * FROM resenas WHERE resenas.calificacion BETWEEN :calificacionInf AND :calificacionSup ORDER BY resena.comentario ASC")//preguntar si esto es lo que va a ir a la base de datos?
    public List<Resena> metodoNativo(@Param("calificacionInf") int calificacionInf, @Param("calificacionSup") int calificacionSup);*/

}
