package com.Loom.service;

import java.io.IOException;
import java.util.Map;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

public interface ReporteService {
     // Genera un reporte con los parámetros y tipo de archivo especificados
    public ResponseEntity<Resource> generateReporte (
        String reporte,
        Map<String, Object> parametros,
        String tipo
    ) throws IOException;
}
