/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Loom.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FirebaseStorageService {
     // Carga una imagen en el almacenamiento de Firebase usando un archivo local, una carpeta y un ID
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);
    
    // Constantes para el nombre del bucket, rutas y nombre de archivo JSON de Firebase
    final String BucketName = "loom-f00c6.appspot.com";
    final String rutaSuperiorStorage = "Loom";
    final String rutaJsonFile = "firebase";
    final String archivoJsonFile = "loom-f00c6-firebase-adminsdk-iabzp-0fa8d17b75.json";
}
