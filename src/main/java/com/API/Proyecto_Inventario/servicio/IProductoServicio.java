package com.API.Proyecto_Inventario.servicio;


import com.API.Proyecto_Inventario.model.Producto;

public interface IProductoServicio {

	Iterable<Producto> findAll();
	
	Producto save(Producto producto);
	
	Producto findById(Integer id);

	void delete(Producto producto);
	
}
