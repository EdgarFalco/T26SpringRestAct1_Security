package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.Proveedor;
import main.service.ProveedorServiceImpl;

@RestController
@RequestMapping("/api")
public class ProveedorController {

	@Autowired
	ProveedorServiceImpl proveedorServiceImpl;

	@GetMapping("/proveedores")
	public List<Proveedor> listarProveedor() {
		return proveedorServiceImpl.listarProveedor();
	}
	
	@GetMapping("/proveedores/{id}")
	public Proveedor proveedorXID(@PathVariable(name = "id") Character id) {

		Proveedor proveedor_xid = new Proveedor();

		proveedor_xid = proveedorServiceImpl.proveedorXID(id);

		System.out.println("Proveedor XID: " + proveedor_xid);

		return proveedor_xid;
	}

	@PostMapping("/proveedores")
	public Proveedor salvarProveedor(@RequestBody Proveedor proveedor) {

		return proveedorServiceImpl.guardarProveedor(proveedor);
	}

	@PutMapping("/proveedores/{id}")
	public Proveedor actualizarProveedor(@PathVariable(name = "id") Character id, @RequestBody Proveedor proveedor) {

		Proveedor proveedor_seleccionado = new Proveedor();
		Proveedor proveedor_actualizado = new Proveedor();

		proveedor_seleccionado = proveedorServiceImpl.proveedorXID(id);

		proveedor_seleccionado.setNombre(proveedor.getNombre());

		proveedor_actualizado = proveedorServiceImpl.actualizarProveedor(proveedor_seleccionado);

		System.out.println("El proveedor actualizado es: " + proveedor_actualizado);

		return proveedor_actualizado;
	}

	@DeleteMapping("/proveedores/{id}")
	public void eliminarProveedor(@PathVariable(name = "id") Character id) {
		proveedorServiceImpl.eliminarProveedor(id);
	}
}
