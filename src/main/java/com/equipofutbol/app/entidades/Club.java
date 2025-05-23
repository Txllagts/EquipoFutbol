package com.equipofutbol.app.entidades;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="clubes")
public class Club {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String nombre;
	
	@OneToOne
	private Entrenador entrenador;
	
	@OneToMany
	@JoinColumn(name="id_club")
	private List<Jugador> jugadores;
	
	@ManyToOne
	private Asociacion asociacion;
	
	@ManyToMany
	private List<Competicion> competiciones;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}
	

	public Asociacion getAsociacion() {
		return asociacion;
	}

	public void setAsociacion(Asociacion asociacion) {
		this.asociacion = asociacion;
	}

	
	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}


	public List<Competicion> getCompeticiones() {
		return competiciones;
	}

	public void setCompeticiones(List<Competicion> competiciones) {
		this.competiciones = competiciones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
	
	
}
