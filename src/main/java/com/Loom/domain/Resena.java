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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="resenas")
public class Resena implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_resena")
    private Long idResena;
    private int calificacion;
    private String comentario;
    
    @ManyToOne
    @JoinColumn(name="id_producto")
    Producto producto;// producto a la que pertenece el resena
    
    
    public Resena(){
    }
    
    public Resena(int calificacion, String comentario){
        this.calificacion = calificacion;
        this.comentario = comentario;
    }
}
