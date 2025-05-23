package com.equipofutbol.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equipofutbol.app.entidades.Jugador;

public interface JugadorRepositorio extends JpaRepository<Jugador, Long> {

}
