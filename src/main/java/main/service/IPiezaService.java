package main.service;

import java.util.List;

import main.dto.Pieza;

public interface IPiezaService {

	public List<Pieza> listarPieza();
	
	public Pieza piezaXID(Integer id);

	public Pieza guardarPieza(Pieza pieza);	

	public Pieza actualizarPieza(Pieza pieza);

	public void eliminarPieza(Integer id);
}
