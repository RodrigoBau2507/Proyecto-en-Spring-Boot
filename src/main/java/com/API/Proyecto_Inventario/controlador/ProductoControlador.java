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
import com.API.Proyecto_Inventario.servicio.EmailService;
import com.API.Proyecto_Inventario.servicio.IProductoServicio;




@RestController
//http://locahost:8080/inventarioAPI
@RequestMapping("/inventarioAPI")

public class ProductoControlador {
	
	@Autowired
	private IProductoServicio productoServi;
	
	@Autowired
	private EmailService emailservi;
	private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);
	
	// creacion de la ruta para crear un nuevo producto 
	@PostMapping("producto")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto create(@RequestBody Producto producto) {
		logger.info("Producto a agregar: " + producto);
		Producto saveProducto = productoServi.save(producto);
		emailservi.enviarCorreoProductoGuardado(saveProducto.getEmail());
		return productoServi.save(producto);
	}
	
	
	// creacion del servicio de put para modificar algun registro
	@PutMapping("producto/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto update(@PathVariable Integer id, @RequestBody Producto producto) {
        Producto existingProduct = productoServi.findById(id);
        if (existingProduct == null) {
        	logger.warn("Producto no encontrado con el ID: " + id);
        }
        producto.setIdProducto(id); // Asegura que el ID del producto sea el mismo que el proporcionado en la ruta
        Producto updatedProduct = productoServi.save(producto);
        emailservi.enviarCorreoProductoModificado(updatedProduct.getEmail());
        return updatedProduct;
    }

	// Creacion del servicio Delete para eliminar algun registro 

	@DeleteMapping("producto/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		Producto productoDelete = productoServi.findById(id);
	    if (productoDelete != null) {
	        productoServi.delete(productoDelete);
	    } else {
	        // Si el producto no existe, puedes manejar la situación de alguna manera, como lanzar una excepción o simplemente registrar un mensaje de error.
	        logger.warn("Intento de eliminar un producto con ID no válido: " + id);
	        // Aquí puedes lanzar una excepción, registrar un mensaje de error, etc.
	    }
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