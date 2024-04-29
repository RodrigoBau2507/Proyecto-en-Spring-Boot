package com.API.Proyecto_Inventario.servicio;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API.Proyecto_Inventario.model.Usuario;
import com.API.Proyecto_Inventario.repositorio.UsuarioRepositorio;


@Service
public class UsuarioServicio implements IUsuario {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
    private EmailService emailService; 
	
	
	@Override
    public Usuario save(Usuario usuario) {
        Usuario usuarioGuardado = usuarioRepositorio.save(usuario);
        enviarCorreoVerificacion(usuarioGuardado.getEmail());
        return usuarioGuardado;
    }
	

    @Override
    public void delete(Usuario usuario) {
        usuarioRepositorio.delete(usuario);
    }

    @Override
    public void enviarCorreoVerificacion(String email) {
    	emailService.enviarCorreoProductoGuardado(email);
    }

    @Override
	public  Usuario findByEmail(String email) {
		// TODO Auto-generated method stub
		return usuarioRepositorio.findByEmail(email);
	}


	@Override
	public void verificarCorreo(String email) {
		Usuario usuario = usuarioRepositorio.findByEmail(email);
		usuario.setEmailVerificado(true);
		usuarioRepositorio.save(usuario);
	}

	

	
}
