package com.equipofutbol.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equipofutbol.app.entidades.Competicion;

public interface CompeticionRepositorio extends JpaRepository<Competicion, Long> {

}
