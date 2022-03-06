package main.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "piezas")
public class Pieza {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nombre;

	@OneToMany
	@JoinColumn(name = "codigo")
	private List<Suministra> suministra;

	// Constructores
	public Pieza() {
	}

	public Pieza(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	// Getters y setters
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
		return "Pieza [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
}
