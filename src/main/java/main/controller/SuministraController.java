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

import main.dto.Suministra;
import main.service.SuministraServiceImpl;

@RestController
@RequestMapping("/api")
public class SuministraController {

	@Autowired
	SuministraServiceImpl suministraServiceImpl;

	@GetMapping("/suministra")
	public List<Suministra> listarSuministra() {
		return suministraServiceImpl.listarSuministra();
	}
	
	@GetMapping("/suministra/{id}")
	public Suministra suministraXID(@PathVariable(name = "id") Integer id) {

		Suministra suministra_xid = new Suministra();

		suministra_xid = suministraServiceImpl.suministraXID(id);

		System.out.println("Suministra XID: " + suministra_xid);

		return suministra_xid;
	}

	@PostMapping("/suministra")
	public Suministra salvarSuministra(@RequestBody Suministra suministra) {

		return suministraServiceImpl.guardarSuministra(suministra);
	}

	@PutMapping("/suministra/{id}")
	public Suministra actualizarSuministra(@PathVariable(name = "id") Integer id, @RequestBody Suministra suministra) {

		Suministra suministra_seleccionada = new Suministra();
		Suministra suministra_actualizada = new Suministra();

		suministra_seleccionada = suministraServiceImpl.suministraXID(id);

		suministra_seleccionada.setPieza(suministra.getPieza());
		suministra_seleccionada.setProveedor(suministra.getProveedor());
		suministra_seleccionada.setPrecio(suministra.getPrecio());

		suministra_actualizada = suministraServiceImpl.actualizarSuministra(suministra_seleccionada);

		System.out.println("Suministra actualizado es: " + suministra_actualizada);

		return suministra_actualizada;
	}

	@DeleteMapping("/suministra/{id}")
	public void eliminarSuministra(@PathVariable(name = "id") Integer id) {
		suministraServiceImpl.eliminarSuministra(id);
	}
}
