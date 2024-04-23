package com.API.Proyecto_Inventario.servicio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API.Proyecto_Inventario.model.Producto;
import com.API.Proyecto_Inventario.repositorio.ProductoRepositorio;
import jakarta.transaction.Transactional;




@Service
public class ProductoServicio implements IProductoServicio {
	
	@Autowired
	private ProductoRepositorio productoRepo;

	@Override
	public Iterable<Producto> findAll() {
		// TODO Auto-generated method stub
		return productoRepo.findAll();
	}

	@Transactional
	@Override
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return productoRepo.save(producto);
	}

	@Transactional
	@Override
	public Producto findById(Integer id) {
		// TODO Auto-generated method stub
		return productoRepo.findById(id).orElse(null);
	}
	
	@Transactional
	@Override
	public void delete(Producto id) {
		// TODO Auto-generated method stub
		productoRepo.delete(id);
	}

   
	
}
