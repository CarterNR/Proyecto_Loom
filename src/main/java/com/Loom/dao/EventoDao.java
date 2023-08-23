package com.Loom.dao;

import com.Loom.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoDao extends JpaRepository<Evento, Long> {

}
