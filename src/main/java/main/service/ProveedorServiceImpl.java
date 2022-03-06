package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IProveedorDao;
import main.dto.Proveedor;

@Service
public class ProveedorServiceImpl implements IProveedorService {

	@Autowired
	IProveedorDao iProveedorDao;

	@Override
	public List<Proveedor> listarProveedor() {
		
		return iProveedorDao.findAll();
	}
	
	@Override
	public Proveedor proveedorXID(Character id) {
		
		return iProveedorDao.findById(id).get();
	}

	@Override
	public Proveedor guardarProveedor(Proveedor proveedor) {
		
		return iProveedorDao.save(proveedor);
	}

	@Override
	public Proveedor actualizarProveedor(Proveedor proveedor) {
		
		return iProveedorDao.save(proveedor);
	}

	@Override
	public void eliminarProveedor(Character id) {
		
		iProveedorDao.deleteById(id);
	}
}
