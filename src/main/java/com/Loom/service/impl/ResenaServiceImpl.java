package com.Loom.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.Loom.dao.ResenaDao;
import com.Loom.domain.Resena;
import com.Loom.service.ResenaService;
import org.springframework.stereotype.Service;

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
}
