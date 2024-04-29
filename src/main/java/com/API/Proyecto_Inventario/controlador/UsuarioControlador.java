package com.API.Proyecto_Inventario.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.API.Proyecto_Inventario.model.Usuario;
import com.API.Proyecto_Inventario.servicio.IUsuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

	@Autowired
    private IUsuario usuarioServicio;

    @PostMapping
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        usuario.setEmailVerificado(false);
    	Usuario usuarioRegistrado = usuarioServicio.save(usuario);
    	usuarioServicio.enviarCorreoVerificacion(usuarioRegistrado.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRegistrado);
    }
    
    @GetMapping("/verificar-correo")
    public ResponseEntity<String> verificarCorreo(@RequestParam("email") String email){
    	usuarioServicio.verificarCorreo(email);
    	return ResponseEntity.ok("Correo verificado exitosamente.");
    }
    
}
