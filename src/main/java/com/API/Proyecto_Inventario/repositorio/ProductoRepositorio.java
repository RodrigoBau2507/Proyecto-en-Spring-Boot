package com.API.Proyecto_Inventario.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.API.Proyecto_Inventario.model.Producto;

public interface ProductoRepositorio extends CrudRepository<Producto, Integer> {

}
