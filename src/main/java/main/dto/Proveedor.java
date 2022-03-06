package main.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "proveedores")
public class Proveedor {

	//Atributos
	@Id
	private char id;
	private String nombre;

	@OneToMany
	@JoinColumn(name = "id")
	private List<Suministra> suministra;

	// Constructores
	public Proveedor() {
	}

	public Proveedor(char id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	// Getters y setters
	public Character getId() {
		return id;
	}

	public void setId(char id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "suministras")
	public List<Suministra> getSuministra() {
		return suministra;
	}

	public void setCaja(List<Suministra> suministra) {
		this.suministra = suministra;
	}

	// toString
	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombre=" + nombre + "]";
	}
}
