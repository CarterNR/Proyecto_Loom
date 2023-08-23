package com.Loom.service.impl;

import com.Loom.dao.DescuentoDao;
import com.Loom.domain.Descuento;
import com.Loom.service.DescuentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DescuentoServiceImpl implements DescuentoService {

    @Autowired
    private DescuentoDao descuentoDao;

// Método para obtener la lista de descuentos
    @Override
    @Transactional(readOnly = true)
    public List<Descuento> getDescuentos() {
        var lista = descuentoDao.findAll();
        return lista; // Devuelve la lista resultante
    }

// Método para obtener un descuento según su ID
    @Override
    @Transactional(readOnly = true)
    public Descuento getDescuento(Descuento descuento) {
        return descuentoDao.findById(descuento.getIdDescuento()).orElse(null);
    }

// Método para guardar o actualizar un descuento en la base de datos
    @Override
    @Transactional
    public void save(Descuento descuento) {
        descuentoDao.save(descuento);
    }

// Método para eliminar un descuento de la base de datos
    @Override
    @Transactional
    public void delete(Descuento descuento) {
        descuentoDao.delete(descuento);
    }
}
