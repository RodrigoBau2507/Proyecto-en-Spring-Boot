package com.API.Proyecto_Inventario.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;



import com.API.Proyecto_Inventario.model.Usuario;



public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{
	Usuario findByEmail(String email);
}
