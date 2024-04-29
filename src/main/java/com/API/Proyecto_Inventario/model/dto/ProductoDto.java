package com.API.Proyecto_Inventario.model.dto;

import java.io.Serializable;

import com.API.Proyecto_Inventario.model.Usuario;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@ToString
@JsonPropertyOrder
@Builder
public class ProductoDto implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer idProducto;
	String descripcion;
	String nombre;
	Double precio;
	Integer piezas;
	String categoria;
	Usuario usuario;
}
