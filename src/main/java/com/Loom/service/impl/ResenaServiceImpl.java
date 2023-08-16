/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Loom.service.impl;

import com.Loom.dao.ResenaDao;
import com.Loom.domain.Resena;
import com.Loom.service.ResenaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ResenaServiceImpl implements ResenaService {

    @Autowired
    private ResenaDao resenaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Resena> getResenas() {
        var lista = resenaDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Resena getResena(Resena resena) {
        return resenaDao.findById(resena.getIdResena()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Resena resena) {
        resenaDao.save(resena);
    }

    @Override
    @Transactional
    public void delete(Resena resena) {
        resenaDao.delete(resena);
    }
/*
    @Override
    @Transactional(readOnly = true)
    public List<Resena> metodoJPQL(int calificacionInf, int calificacionSup) {
        return resenaDao.metodoJPQL(calificacionInf, calificacionSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Resena> metodoNativo(int calificacionInf, int calificacionSup) {
        return resenaDao.metodoNativo(calificacionInf, calificacionSup);
    }*/
}
