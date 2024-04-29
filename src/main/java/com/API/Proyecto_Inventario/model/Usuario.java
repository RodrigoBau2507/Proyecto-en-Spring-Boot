package com.API.Proyecto_Inventario.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonPropertyOrder
@Table(name="usuario")
public class Usuario implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_usuario;
	@Column(name = "Nombre")
	String Nombre;
	@Column(name = "Apellido")
	String apellido;
	@Column(name = "email")
	String email;
	@Column(name = "password")
	String password;
	@Column(name = "email_verificado")
	private boolean emailVerificado;
	

	
	
	public  Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Usuario(Integer id_usuario, String nombre, String apellido, String email, String password,
			boolean emailVerificado) {
		super();
		this.id_usuario = id_usuario;
		Nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.emailVerificado = emailVerificado;
	}




	public boolean isEmailVerificado() {
		return emailVerificado;
	}
	public void setEmailVerificado(boolean emailVerificado) {
		this.emailVerificado = emailVerificado;
	}
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	
	
	
	
}
