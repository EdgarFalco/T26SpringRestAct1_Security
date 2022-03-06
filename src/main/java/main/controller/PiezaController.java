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

import main.dto.Pieza;
import main.service.PiezaServiceImpl;

@RestController
@RequestMapping("/api")
public class PiezaController {

	@Autowired
	PiezaServiceImpl piezaServiceImpl;

	@GetMapping("/piezas")
	public List<Pieza> listarPieza() {
		return piezaServiceImpl.listarPieza();
	}
	
	@GetMapping("/piezas/{id}")
	public Pieza piezaXID(@PathVariable(name = "id") Integer codigo) {

		Pieza pieza_xid = new Pieza();

		pieza_xid = piezaServiceImpl.piezaXID(codigo);

		System.out.println("Pieza XID: " + pieza_xid);

		return pieza_xid;
	}

	@PostMapping("/piezas")
	public Pieza salvarPieza(@RequestBody Pieza pieza) {

		return piezaServiceImpl.guardarPieza(pieza);
	}

	@PutMapping("/piezas/{id}")
	public Pieza actualizarPieza(@PathVariable(name = "id") Integer codigo, @RequestBody Pieza pieza) {

		Pieza pieza_seleccionada = new Pieza();
		Pieza pieza_actualizada = new Pieza();

		pieza_seleccionada = piezaServiceImpl.piezaXID(codigo);

		pieza_seleccionada.setNombre(pieza.getNombre());

		pieza_actualizada = piezaServiceImpl.actualizarPieza(pieza_seleccionada);

		System.out.println("La pieza actualizada es: " + pieza_actualizada);

		return pieza_actualizada;
	}

	@DeleteMapping("/piezas/{id}")
	public void eliminarPieza(@PathVariable(name = "id") Integer codigo) {
		piezaServiceImpl.eliminarPieza(codigo);
	}
}