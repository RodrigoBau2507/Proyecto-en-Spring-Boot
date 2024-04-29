package com.API.Proyecto_Inventario.servicio;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;


@Service
public class EmailService {

	 @Autowired
	    private JavaMailSender javaMailSender;

	    @Value("${spring.mail.username}")
	    private String remitente;

	    // Método para enviar correo de confirmación al guardar un producto
	    public void enviarCorreoProductoGuardado(String destinatario) {
	        String asunto = "Producto Almacenado";
	        String mensaje = "<html><body><h1>Producto Almacenado</h1><p>El producto se ha almacenado correctamente.</p></body></html>";
	        enviarCorreo(destinatario, asunto, mensaje);
	    }

	    // Método para enviar correo de confirmación al modificar un producto
	    public void enviarCorreoProductoModificado(String destinatario) {
	        String asunto = "Producto Modificado";
	        String mensaje = "<html><body><h1>Producto Modificado</h1><p>El producto se ha modificado correctamente.</p></body></html>";
	        enviarCorreo(destinatario, asunto, mensaje);
	    }

	    // Método para enviar correo de notificación al eliminar un producto
	    public void enviarCorreoProductoEliminado(String destinatario, String productoEliminado) {
	        String asunto = "Producto Eliminado";
	        String mensaje = "<html><body><h1>Producto Eliminado</h1><p>El siguiente producto ha sido eliminado: <strong>" + productoEliminado + "</strong></p></body></html>";
	        enviarCorreo(destinatario, asunto, mensaje);
	    }

	    // Método genérico para enviar correo electrónico
	    private void enviarCorreo(String destinatario, String asunto, String mensaje) {
	        MimeMessage message = javaMailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, StandardCharsets.UTF_8.name());
	        try {
	            helper.setTo(destinatario);
	            helper.setSubject(asunto);
	            helper.setText(mensaje, true); // Indicar que el mensaje es HTML
	            helper.setFrom(remitente);
	            javaMailSender.send(message);
	        } catch (MessagingException e) {
	            e.printStackTrace();
	            // Manejar la excepción adecuadamente
	        }
	    }
    
}
