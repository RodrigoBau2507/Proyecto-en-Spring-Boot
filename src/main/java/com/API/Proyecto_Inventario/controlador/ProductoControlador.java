package com.API.Proyecto_Inventario.controlador;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.API.Proyecto_Inventario.model.Producto;
import com.API.Proyecto_Inventario.servicio.IProductoServicio;




@RestController
//http://locahost:8080/inventarioAPI
@RequestMapping("/inventarioAPI")

public class ProductoControlador {
	
	@Autowired
	private IProductoServicio productoServi;
	private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);
	
	// creacion de la ruta para crear un nuevo producto 
	@PostMapping("producto")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto create(@RequestBody Producto producto) {
		logger.info("Producto a agregar: " + producto);
		return productoServi.save(producto);
	}
	
	
	// creacion del servicio de put para modificar algun registro
	@PutMapping("producto")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto update(@RequestBody Producto producto) {
		return productoServi.save(producto);
	}

	// Creacion del servicio Delete para eliminar algun registro 
	@DeleteMapping("producto/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		Producto productoDelete = productoServi.findById(id);
		productoServi.delete(productoDelete);
	}
	
	// buscar por algun producto por su ID 
	@GetMapping("producto/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Producto showById(@PathVariable Integer id) {
		return productoServi.findById(id);
	}
	
	// mostrar todos los productos 
	@GetMapping("producto")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Producto> show() {
		return productoServi.findAll();
	}
	
}