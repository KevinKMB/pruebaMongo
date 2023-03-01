package com.prueba.KevinMaldonado.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "Profesor")
@Data
public class Profesor {

	
	private Long Prof_ID;
	private Long Depto_ID;
	private String Nombre;
	private String Direccion;
	private String Telefono;

	private List<Curso> listadecursos;
	
	
	
	
}
