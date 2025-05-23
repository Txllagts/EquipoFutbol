package com.equipofutbol.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equipofutbol.app.entidades.Club;

public interface ClubRepositorio extends JpaRepository<Club, Long> {

}
