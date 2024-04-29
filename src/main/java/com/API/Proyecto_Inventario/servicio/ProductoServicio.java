package com.API.Proyecto_Inventario.servicio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API.Proyecto_Inventario.exception.NotFoundException;
import com.API.Proyecto_Inventario.model.Producto;
import com.API.Proyecto_Inventario.repositorio.ProductoRepositorio;
import jakarta.transaction.Transactional;




@Service
public class ProductoServicio implements IProductoServicio {
	
	@Autowired
	private ProductoRepositorio productoRepo;

	@Override
	public Iterable<Producto> findAll() {

		return productoRepo.findAll();
	}

	@Transactional
	@Override
	public Producto save(Producto producto) {
		if (producto.getIdProducto() == null) {
	        // Si el ID del producto es nulo, significa que es un nuevo registro
	        return productoRepo.save(producto);
	    } else {
	        // Si el ID del producto no es nulo, significa que es una actualización
	        Producto existingProduct = productoRepo.findById(producto.getIdProducto()).orElse(null);
	        if (existingProduct != null) {
	            // Si el producto existente se encuentra, se actualiza con los nuevos datos
	            existingProduct.setDescripcion(producto.getDescripcion());
	            existingProduct.setNombre(producto.getNombre());
	            existingProduct.setPrecio(producto.getPrecio());
	            existingProduct.setPiezas(producto.getPiezas());
	            existingProduct.setCategoria(producto.getCategoria());
	            // Luego se guarda en la base de datos
	            return productoRepo.save(existingProduct);
	        } else {
	            // Si no se encuentra el producto existente, se podría lanzar una excepción o manejar el error de otra forma
	            throw new NotFoundException("Producto no encontrado con el ID: " + producto.getIdProducto());
	        }
	    }
	}

	@Transactional
	@Override
	public Producto findById(Integer id) {
		
		return productoRepo.findById(id).orElse(null);
	}
	

	  @Override
	    public void delete(Producto producto) {
	        productoRepo.delete(producto);
	    }

   
	
}
