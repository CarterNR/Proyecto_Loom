package com.Loom.domain;


import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name="evento")
public class Evento implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_evento")
    private Long idEvento; 
    private String nombre;
    private String fecha;
    private String lugar;
    private String descripcion;
    private String rutaImagen;
    
    
    
    public Evento(){
    }
    
    public Evento(String nombre, String fecha, String lugar, String descripcion){
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.descripcion = descripcion;
    }
}
