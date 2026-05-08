package com.GestionTorneo.repository;


import com.GestionTorneo.model.Cartas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartasRepository extends JpaRepository<Cartas, Long> {
}
