package modelo;

import java.time.LocalDate;

public class vehiculo {
	private int id;
	
	private String matricula;
	private int marcaModelo;
	private LocalDate fechaMatricula;
	private float precio;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getMarcaModelo() {
		return marcaModelo;
	}
	public void setMarcaModelo(int marcaModelo) {
		this.marcaModelo = marcaModelo;
	}
	public LocalDate getFechaMatricula() {
		return fechaMatricula;
	}
	public void setFechaMatricula(LocalDate fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}

}


	