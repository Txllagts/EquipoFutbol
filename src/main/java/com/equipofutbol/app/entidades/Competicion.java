package com.equipofutbol.app.entidades;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="competiciones")
public class Competicion {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String nombre;
	
	private int montoPremio;
	
	private LocalDate fechainicio;
	
	private LocalDate fechafin;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMontoPremio() {
		return montoPremio;
	}

	public void setMontoPremio(int montoPremio) {
		this.montoPremio = montoPremio;
	}

	public LocalDate getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(LocalDate fechainicio) {
		this.fechainicio = fechainicio;
	}

	public LocalDate getFechafin() {
		return fechafin;
	}

	public void setFechafin(LocalDate fechafin) {
		this.fechafin = fechafin;
	}
	
	
}
