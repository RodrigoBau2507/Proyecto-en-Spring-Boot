package com.API.Proyecto_Inventario.servicio;


import com.API.Proyecto_Inventario.model.Usuario;

public interface IUsuario {
	Usuario save(Usuario producto);
	void delete(Usuario usuario);
	void enviarCorreoVerificacion(String email);
	void verificarCorreo(String email);
	Usuario findByEmail(String email);
}
