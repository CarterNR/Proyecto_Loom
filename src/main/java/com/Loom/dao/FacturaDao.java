/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Loom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Loom.domain.Factura;

public interface FacturaDao extends JpaRepository <Factura,Long> {
     
}
