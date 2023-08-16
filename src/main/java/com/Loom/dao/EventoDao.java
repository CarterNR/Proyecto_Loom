/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Loom.dao;

import com.Loom.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author NIKY
 */
public interface EventoDao extends JpaRepository<Evento, Long> {

}
