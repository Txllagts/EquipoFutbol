package com.equipofutbol.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equipofutbol.app.entidades.Entrenador;

public interface EntrenadorRepositorio extends JpaRepository<Entrenador, Long> {

}
