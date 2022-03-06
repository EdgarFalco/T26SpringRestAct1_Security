package main.service;

import java.util.List;

import main.dto.Suministra;

public interface ISuministraService {

	public List<Suministra> listarSuministra(); 
	
	public Suministra suministraXID(Integer id);
	
	public Suministra guardarSuministra(Suministra suministra);	
		
	public Suministra actualizarSuministra(Suministra suministra);
	
	public void eliminarSuministra(Integer id);
}
