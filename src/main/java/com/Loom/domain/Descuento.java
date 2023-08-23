/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Loom.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;


@Data
@Entity
@Table(name="descuento")
public class Descuento implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_descuento")
    private Long idDescuento; 
    private String descuento;
    private String descripcion;
    private String fechai;
    private String fechaf;
    
    
    
    public Descuento(){
    }
    
    public Descuento(String descuento, String descripcion, String fechai, String fechaf){
        this.descuento = descuento;
        this.descripcion = descripcion;
        this.fechai = fechai;
        this.fechaf = fechaf;
    }
}
