package main.service;

import java.util.List;

import main.dto.Proveedor;

public interface IProveedorService {

	public List<Proveedor> listarProveedor();
	
	public Proveedor proveedorXID(Character id);
	
	public Proveedor guardarProveedor(Proveedor proveedor);	
		
	public Proveedor actualizarProveedor(Proveedor proveedor);
	
	public void eliminarProveedor(Character id);
}
